package com.kyotoyx.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum CouponCategory {

    ADDTIONAL_COUPON("Valid when subtotal price reaches a given number", "001"),
    PERCENTAGE_COUNPON("Give discounts in percentage", "002"),
    INSTANT_COUPON("Give discounts in a given number", "003");

    private String description;

    private String code;

    public static CouponCategory of(String code) {
        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(" The code: " + code + " not exists!"));
    }
}
