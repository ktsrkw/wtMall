package com.wt.mall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.Query;

import com.wt.mall.product.dao.CategoryDao;
import com.wt.mall.product.entity.CategoryEntity;
import com.wt.mall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类数据
        List<CategoryEntity> categoryEntities = categoryDao.selectList(null);

        //2、以父子方式组装起来
        //2.1、找到所有的1级分类
        List<CategoryEntity> level01CategoryEntities = new ArrayList<CategoryEntity>();
        for (CategoryEntity categoryEntity : categoryEntities) {
            if (categoryEntity.getParentCid() == 0){
                level01CategoryEntities.add(categoryEntity);
            }
        }

        //2.2、调用递归方法构建树形分类结构
//        for (CategoryEntity level01CategoryEntity : level01CategoryEntities) {
//            List<CategoryEntity> level01Children = new ArrayList<CategoryEntity>();
//            for (CategoryEntity categoryEntity : categoryEntities) {
//                if (categoryEntity.getParentCid().equals(level01CategoryEntity.getCatId())){
//                    List<CategoryEntity> level02Children = new ArrayList<CategoryEntity>();
//                    for (CategoryEntity categoryEntity1 : categoryEntities){
//                        if (categoryEntity1.getParentCid().equals(categoryEntity.getCatId())){
//                            level02Children.add(categoryEntity1);
//                        }
//                    }
//                    categoryEntity.setChildrenCategoryEntities(level02Children);
//                    level01Children.add(categoryEntity);
//                }
//            }
//            level01CategoryEntity.setChildrenCategoryEntities(level01Children);
//        }

        return buildCategoryTree(level01CategoryEntities,categoryEntities);
    }

    @Override
    public void removeCategoryByIds(List<Long> catIds) {
        //TODO:检查当前删除的菜单是否被其他菜单引用
        categoryDao.deleteBatchIds(catIds);
    }

    private List<CategoryEntity> buildCategoryTree(List<CategoryEntity> bootCategoryEntities,
                                                   List<CategoryEntity> allCategoryEntities){
        for (CategoryEntity bootCategoryEntity : bootCategoryEntities) {
            List<CategoryEntity> childCategoryEntityList = new ArrayList<>();
            for (CategoryEntity categoryEntityInAll : allCategoryEntities) {
                if (categoryEntityInAll.getParentCid().equals(bootCategoryEntity.getCatId())){
                    childCategoryEntityList.add(categoryEntityInAll);
                }
            }
            buildCategoryTree(childCategoryEntityList,allCategoryEntities);
            bootCategoryEntity.setChildrenCategoryEntities(childCategoryEntityList);
        }

        //根据sort字段进行排序
        if (!bootCategoryEntities.isEmpty()){
            Collections.sort(bootCategoryEntities);
        }

        return bootCategoryEntities;
    }

}