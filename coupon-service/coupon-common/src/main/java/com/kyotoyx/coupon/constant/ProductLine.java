package com.kyotoyx.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum ProductLine {

    DIRECT_SALE("Direct-sale store", 1),
    DISTRIBUTOR_PARTNER("Third party distributor partner", 2);

    private String description;
    private Integer code;

    public static ProductLine of(Integer code) {
        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(" The code: " + code + " not exists!"));
    }
}
