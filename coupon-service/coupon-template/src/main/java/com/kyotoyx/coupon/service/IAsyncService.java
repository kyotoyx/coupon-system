package com.kyotoyx.coupon.service;

import com.kyotoyx.coupon.entity.CouponTemplate;

public interface IAsyncService {

    void asyncConstructCouponByTemplate(CouponTemplate template);
}
