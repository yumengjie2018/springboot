package com.boco.xjappservice.interceptor;


import com.boco.xjappservice.entity.domainModel.TokenOriginEntity;
import com.boco.xjappservice.service.impl.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 公共拦截器
 * 
 * @author pangkang 
 * 2018-1-25 09:00:31
 */
public class CommonInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private TokenService tokenService;

	private void reWriteResponse(HttpServletResponse response, String json) throws IOException{
		response.setContentType("application/json;charset=utf-8");
		PrintWriter writer;
		writer = response.getWriter();
		writer.write(json);
	}
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());

		if ("GET".equalsIgnoreCase(request.getMethod()) || "POST".equalsIgnoreCase(request.getMethod())) {
			if (url.contains("/api/")) {
//				String key = request.getHeader("key");
//				String value = request.getHeader("value");
//				String md5SignResult = Md5SignUtil.getMd5SignResult(key);
//				//非法用户
//				if (!value.equals(md5SignResult)){
//                    String json = tokenService.returnIllegalUser();
//                    reWriteResponse(response, json);
//                    return false;
//                }
				String token = request.getHeader("authorization");
				String userId = request.getParameter("userId");
				if (token != null && userId != null) {
					String tokenSource = tokenService.getToken(userId);
					//根据用户ID未找到token
					if (tokenSource == null) {
						String json = tokenService.returnNullToken();
						reWriteResponse(response, json);
						return false;
					}
					// 如果token验证不通过，返回已经登录的用户信息
					if (!token.equals(tokenSource)) {
						String json = tokenService.decryptTokenToResponse(tokenSource, TokenOriginEntity.class);
						reWriteResponse(response, json);
						return false;
					}
				} else {
					//用户名或token为空
					String json = tokenService.returnNullUserOrToken();
					reWriteResponse(response, json);
					return false;
				}
			}
			return true;
		} else {
			throw new Exception("不支持的请求类型!");
		}

	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 可在modelAndView中加入数据，比如当前时间
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
	 * 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
