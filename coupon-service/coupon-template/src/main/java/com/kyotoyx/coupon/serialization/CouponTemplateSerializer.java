package com.kyotoyx.coupon.serialization;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.kyotoyx.coupon.entity.CouponTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class CouponTemplateSerializer extends JsonSerializer<CouponTemplate> {
    @Override
    public void serialize(CouponTemplate couponTemplate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        // begin to serialize this object
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("id", couponTemplate.getId().toString());
        jsonGenerator.writeStringField("name", couponTemplate.getName());
        jsonGenerator.writeStringField("logo", couponTemplate.getLogo());
        jsonGenerator.writeStringField("desc", couponTemplate.getDescription());
        jsonGenerator.writeStringField("category", couponTemplate.getCategory().getDescription());
        jsonGenerator.writeStringField("productLine", couponTemplate.getProductLine().getDescription());
        jsonGenerator.writeStringField("count", couponTemplate.getCount().toString());
        jsonGenerator.writeStringField("ceateTime",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(couponTemplate.getCreateTime()));
        jsonGenerator.writeStringField("userId", couponTemplate.getUserId().toString());
        jsonGenerator.writeStringField("key", couponTemplate.getKey() + String.format("%04d", couponTemplate.getId()));
        jsonGenerator.writeStringField("target", couponTemplate.getTarget().getDescription());
        jsonGenerator.writeStringField("rule",
                JSON.toJSONString(couponTemplate.getRule()));

        // End the serialization
        jsonGenerator.writeEndObject();
    }
}
