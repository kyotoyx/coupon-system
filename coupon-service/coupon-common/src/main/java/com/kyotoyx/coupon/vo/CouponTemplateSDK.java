package com.kyotoyx.coupon.vo;


// The data of coupon template used between microserivces.


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponTemplateSDK {

    private Integer id;

    private String name;

    private String logo;

    private String desc;

    private String category;

    private Integer productLine;

    // code of the coupon template
    private String key;

    private Integer target;

    private TemplateRule rule;


}
