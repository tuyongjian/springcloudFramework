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
 * 过滤器是zuul的核心功能。
 *
 */
public class AccessFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器的类型，决定过滤器在请求的那个生命周期中执行，
     * pre 代表在请求被路由之前执行
     * routing 在路由请求时被调用
     * error 处理请求发生错误的时候被调用
     * post  在routing和error过滤器之后被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序，数值越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤去是否要被执行，这里直接返回true,因此该过滤器对所有的请求都会生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /***
     * 过滤器的具体逻辑
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