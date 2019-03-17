package com.yunche.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yunche
 * @date 2019/03/17
 */
@Component
@Slf4j
public class AccessLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        //定义优先级最低，用于精确统计从接受请求到返回请求的耗费时间
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        Long startTime = (Long)context.get("starTime");
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        long duration =System.currentTimeMillis() - startTime;
        log.info("uri:{}, duration:{} s", uri, duration / 1000);
        return null;
    }
}
