package com.seeini.common.request;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author Vincent
 * @Date 2021/7/23 10:46
 * @Version 1.0
 * @Description
 */
@Slf4j
public class ReplaceStreamFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("StreamFilter初始化...");
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        ServletRequest requestWrapper = new RequestWrapper((HttpServletRequest) request);
//        chain.doFilter(requestWrapper, response);
        ServletRequest requestWrapper = null;
        if (!ObjectUtils.isEmpty(request.getContentType()) && request.getContentType().equals("application/json") && request instanceof HttpServletRequest) {
            // 获取请求中的流，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
            requestWrapper = new RequestWrapper((HttpServletRequest) request);
        }
        if (ObjectUtils.isEmpty(requestWrapper)) {
            chain.doFilter(request, response);
        } else {
            // 若不为空 在chain.doFiler方法中传递包装后的request对象
            chain.doFilter(requestWrapper, response);
        }

    }

//    @Override
//    public void destroy() {
//        log.info("StreamFilter销毁...");
//    }

}
