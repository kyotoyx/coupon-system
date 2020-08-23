package com.kyotoyx.coupon.converter;

import com.kyotoyx.coupon.constant.ProductLine;

import javax.persistence.AttributeConverter;

public class ProductLineConverter implements AttributeConverter<ProductLine, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductLine productLine) {
        return productLine.getCode();
    }

    @Override
    public ProductLine convertToEntityAttribute(Integer code) {
        return ProductLine.of(code);
    }


}
