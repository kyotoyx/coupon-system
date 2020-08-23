package com.kyotoyx.coupon.advice;


import com.kyotoyx.coupon.exception.CouponException;
import com.kyotoyx.coupon.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = CouponException.class)
    public CommonResponse<String> handleCouponException(
            HttpServletRequest req, CouponException ex
    ) {
        CommonResponse<String> response = new CommonResponse<>(
                -1, "bussiness error"
        );
        response.setData(ex.getMessage());
        return response;
    }
}
