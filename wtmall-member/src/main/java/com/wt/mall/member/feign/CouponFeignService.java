package com.wt.mall.member.feign;

import com.wt.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("wtmall-coupon")
public interface CouponFeignService {
    @RequestMapping("/coupon/coupon/member/list")
    R membercoupons();
}
