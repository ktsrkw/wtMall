package com.wt.mall.product.dao;

import com.wt.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-18 22:29:12
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
