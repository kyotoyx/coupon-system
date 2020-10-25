package com.kyotoyx.coupon.service;

import com.kyotoyx.coupon.entity.CouponTemplate;
import com.kyotoyx.coupon.exception.CouponException;
import com.kyotoyx.coupon.vo.TemplateRequest;

public interface IBuildTemplateService {


    CouponTemplate buildTemplate(TemplateRequest request) throws CouponException;
}
