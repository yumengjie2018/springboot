//package com.example.service.filter;
//import javax.servlet.*;
///**
// * title：CustomFilter
// * description:
// *
// * @author yumengjie
// * @date 2019/3/26 15:39
// */
//
//import lombok.extern.slf4j.Slf4j;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
////注册器名称为customFilter,拦截的url为所有
//@Slf4j
//public class CustomFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("filter 初始化");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        // TODO Auto-generated method stub
//        log.info("doFilter 请求处理");
//        //对request、response进行一些预处理
//        // 比如设置请求编码
//        // request.setCharacterEncoding("UTF-8");
//        // response.setCharacterEncoding("UTF-8");
//        //TODO 进行业务逻辑
//
//        //链路 直接传给下一个过滤器
////        chain.doFilter(request, response);
//
//
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        System.out.println("过滤器开始工作。。"+httpServletRequest.getRequestURL());
//        chain.doFilter(request,response);
//    }
//
//    @Override
//    public void destroy() {
//        log.info("filter 销毁");
//    }
//}