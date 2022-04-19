package com.wt.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.mall.ware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-19 13:27:57
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

