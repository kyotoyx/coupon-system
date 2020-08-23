package com.kyotoyx.coupon.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum PeriodType {

    REGULAR("Fixed period", 1),
    DYNAMIC("Dynamic period starting from collection date", 2);

    private String description;

    private Integer code;

    public static PeriodType of(Integer code) {
        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(" The code: " + code + " not exists!"));
    }
}
