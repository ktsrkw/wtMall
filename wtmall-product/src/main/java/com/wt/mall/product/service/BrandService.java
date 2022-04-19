package com.wt.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-18 22:29:12
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

