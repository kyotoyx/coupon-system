package com.kyotoyx.coupon.converter;

import com.kyotoyx.coupon.constant.DistributeTarget;

import javax.persistence.AttributeConverter;

public class DistributeTargetConverter implements AttributeConverter<DistributeTarget, Integer> {
    @Override
    public Integer convertToDatabaseColumn(DistributeTarget distributeTarget) {
        return distributeTarget.getCode();
    }

    @Override
    public DistributeTarget convertToEntityAttribute(Integer integer) {
        return DistributeTarget.of(integer);
    }
}
