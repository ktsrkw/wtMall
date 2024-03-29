package com.wt.mall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wt.mall.product.entity.CategoryEntity;
import com.wt.mall.product.service.CategoryService;
import com.wt.common.utils.PageUtils;
import com.wt.common.utils.R;



/**
 * 商品三级分类
 *
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-18 23:07:45
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类，并以父子方式组装起来
     */
    @RequestMapping("/list/tree")
    public R list(){
        List<CategoryEntity> categoryEntities = categoryService.listWithTree();

        return R.ok().put("categoryEntities", categoryEntities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 批量修改
     */
    @RequestMapping("/update/batch")
    public R updateBatch(@RequestBody CategoryEntity[] categoryEntities){
        categoryService.updateBatchById(Arrays.asList(categoryEntities));

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){

		//categoryService.removeByIds(Arrays.asList(catIds));

        categoryService.removeCategoryByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
