package com.wt.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.common.utils.PageUtils;
import com.wt.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author wt
 * @email ktsrkw@163.com
 * @date 2022-04-19 13:01:07
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

