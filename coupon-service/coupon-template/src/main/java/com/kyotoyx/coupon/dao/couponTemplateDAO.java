package com.kyotoyx.coupon.dao;

import com.kyotoyx.coupon.entity.CouponTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface couponTemplateDAO extends JpaRepository<CouponTemplate, Integer>{

    CouponTemplate findByName(String name);


    List<CouponTemplate> findAllByAvailableAndExpired(
            Boolean available, Boolean expired
    );


    List<CouponTemplate> findAllByExpired(Boolean expired);



}
