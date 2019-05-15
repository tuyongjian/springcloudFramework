package com.tu.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 自定义过滤器。继承ZuulFilter 进行一些特定的控制
 * @Classname AccessFilter
 * @Date 2019/5/15 11:38
 * @Created by tuyongjian
 */
public class AccessFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /***
     * 自定义的规则，如果请求中没有accessToken参数并且为空的话，返回401
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext cxt = RequestContext.getCurrentContext();
        HttpServletRequest request = cxt.getRequest();
        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        Object accessToken = request.getParameter("accessToken");
        if(accessToken==null){
            logger.warn("access token is empty");
            cxt.setSendZuulResponse(false);
            cxt.setResponseStatusCode(401);
            return null;
        }
        return null;
     }
}