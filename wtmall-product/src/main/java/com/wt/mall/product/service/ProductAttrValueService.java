package com.wt.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.mall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-18 22:29:12
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

