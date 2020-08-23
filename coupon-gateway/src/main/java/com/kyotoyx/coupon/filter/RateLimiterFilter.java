package com.kyotoyx.coupon.filter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
@SuppressWarnings("all")
public class RateLimiterFilter extends AbstractPreZuulFilter {

    /**
     * Get 2 rate tatokens per second.
     */
    RateLimiter limiter = RateLimiter.create(2.0);
    @Override
    protected Object cRun() {
        HttpServletRequest request = context.getRequest();
        if (limiter.tryAcquire()) {
            log.info("Successfully get the rate token!");
            return success();
        } else {
            log.error(String.format(
                    "Rate limited to %s", request.getRequestURL().toString()
            ));
            return fail(402, " Rate limited. ");
        }
    }

    @Override
    public int filterOrder() {
        return 2;
    }
}
