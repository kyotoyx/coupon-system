package com.kyotoyx.coupon.converter;

import com.alibaba.fastjson.JSON;
import com.kyotoyx.coupon.vo.TemplateRule;

import javax.persistence.AttributeConverter;

public class TemplateRuleConverter implements AttributeConverter<TemplateRule, String> {
    @Override
    public String convertToDatabaseColumn(TemplateRule templateRule) {
        return JSON.toJSONString(templateRule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String rule) {
        return JSON.parseObject(rule, TemplateRule.class);
    }
}
