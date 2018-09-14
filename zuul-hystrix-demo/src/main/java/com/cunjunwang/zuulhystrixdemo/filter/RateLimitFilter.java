package com.cunjunwang.zuulhystrixdemo.filter;

import com.cunjunwang.zuulhystrixdemo.exception.RateLimitException;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * Created by CunjunWang on 2018/9/1.
 */

// 限流

@Component
public class RateLimitFilter extends ZuulFilter {

    // 令牌桶限流 每秒放100个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        // 取令牌 没取到就抛异常
        if(!RATE_LIMITER.tryAcquire()){
            throw new RateLimitException();
        }

        return null;
    }
}
