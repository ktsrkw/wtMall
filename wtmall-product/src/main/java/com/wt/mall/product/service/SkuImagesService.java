package com.wt.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.mall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-18 22:29:12
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

