package com.yunche.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;


/**
 * @author yunche
 * @date 2019/03/17
 */
@Component
public class PreRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //定义该过滤器的类型为pre
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //指定过滤器的优先级，同种过滤器，越小越先执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //指定该过滤器在一定的条件下生效
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取当前请求的上下文
        RequestContext context = RequestContext.getCurrentContext();
        //记录当前系统的时间戳用于
        context.set("startTime", System.currentTimeMillis());
        return null;
    }
}
