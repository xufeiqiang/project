package com.itmuch.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZC-16-012 on 2019/1/17.
 * 自定义zuul 过滤器
 */
public class PreRequestLogFilter  extends ZuulFilter{

    private  Logger logger= LoggerFactory.getLogger(PreRequestLogFilter.class);

    // 返回true 或者 false表示是否执行该过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //具体执行过滤器的逻辑
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request= ctx.getRequest();
        logger.info("进入zuul过滤器。。。");
        logger.info(String.format("send %s request to %s",request.getMethod(),
                request.getRequestURL().toString()));
        return null;
    }

    //过滤器的排序,执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //过滤器的类型
    @Override
    public String filterType() {
        //pre 类型的过滤器,该过滤器确定路由的地址，以及怎样去路由
        return FilterConstants.PRE_TYPE;
    }


    @Override
    public boolean isStaticFilter() {
        return super.isStaticFilter();
    }

    @Override
    public String disablePropertyName() {
        return super.disablePropertyName();
    }

    @Override
    public boolean isFilterDisabled() {
        return super.isFilterDisabled();
    }

    @Override
    public ZuulFilterResult runFilter() {
        return super.runFilter();
    }

    @Override
    public int compareTo(ZuulFilter filter) {
        return super.compareTo(filter);
    }


}
