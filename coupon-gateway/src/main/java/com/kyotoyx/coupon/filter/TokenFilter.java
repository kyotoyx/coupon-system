package com.kyotoyx.coupon.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class TokenFilter extends AbstractPreZuulFilter {
    @Override
    protected Object cRun() {
        HttpServletRequest request = context.getRequest();
        log.info(String.format(
                "%s request to %s", request.getMethod(), request.getRequestURL().toString()
        ));

        // Below is a ideal model of token verifying.
        // Additional implementation is needed in terms of different requirement.
        Object token = request.getParameter("token");

        if (token == null) {
            log.error(" Token is empty ! ");
            return fail(401, "Token is empty");
        }

        // Token verification is needed here.
        return success();
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}
