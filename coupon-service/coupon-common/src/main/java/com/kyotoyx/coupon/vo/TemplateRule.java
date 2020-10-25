package com.kyotoyx.coupon.vo;

import com.kyotoyx.coupon.constant.PeriodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRule {

    // The expiration rule
    private Expiration expiration;

    private Discount discount;

    // THe limitation of number of coupons that one person can get.
    private Integer limitation;

    private Usage usage;

    /**
     * This is used to determined which coupons can be combined.
     * The same type can not be combined.
     */
    private String weight;

    public static class Expiration {
        // The code for PeriodType.
        private Integer period;

        // Only valid for dynamic period.
        private Integer interval;

        // The expiration date, valid for both types of period
        private Long deadline;

        boolean validate() {
            // Simple validate, more logic to implement.
            return null != PeriodType.of(period) && interval > 0 && deadline > 0;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Discount {
        // The value that can be redeemed.
        private Integer quota;

        // Required base price to make coupon valid.
        private Integer base;

        boolean validate() {
            return quota > 0 && base > 0;
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Usage {
        // The type of good that can be discounted.
        private String goodType;

        boolean validate() {
            return StringUtils.isNotEmpty(goodType);
        }
    }

    public boolean validate() {
        return expiration.validate() && discount.validate() && limitation > 0
                && usage.validate()
                && StringUtils.isEmpty(weight);
    }
}
