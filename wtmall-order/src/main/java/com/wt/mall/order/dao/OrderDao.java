package com.wt.mall.order.dao;

import com.wt.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-19 13:13:16
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
