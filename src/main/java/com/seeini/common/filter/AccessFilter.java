package com.seeini.common.filter;

import com.google.gson.Gson;
import com.seeini.common.utils.IpUtil;
import com.seeini.system.entity.Access;
import com.seeini.system.mq.AccessPublisherMQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;


@WebFilter(filterName = "AccessFilter", urlPatterns = {"/guidelines"})
public class AccessFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Autowired
    private AccessPublisherMQ accessPublisherMQ;

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
////        System.out.println("AccessFilter init()");
//        logger.info("Start Filter [{}]",filterConfig.getFilterName());
//    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("AccessFilter doFilter()");

        HttpServletRequest req = (HttpServletRequest) request;

        Access access = new Access();
        access.setIp(IpUtil.getIpAddr(req));
        access.setLoginTime(LocalDateTime.now());

        String me = req.getMethod();
        Map<String, String[]> paramsMap = req.getParameterMap();
        Gson gson = new Gson();
        String paramsString = gson.toJson(paramsMap);
        access.setParams(paramsString);
        logger.info("AccessFilter doFilter Message:{}",gson.toJson(access));
        accessPublisherMQ.send(gson.toJson(access));
        System.out.println("Filter,"+req.getRequestURI());

        //执行
        chain.doFilter(request, response);
    }


//    @Override
//    public void destroy() {
//
//    }
}
