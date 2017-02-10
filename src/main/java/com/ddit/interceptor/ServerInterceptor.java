package com.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ServerInterceptor extends HandlerInterceptorAdapter{
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("()()()()()()()()()()()()()()()()()()()()()()");
		System.out.println("Serverinterceptor 입니다.");
		System.out.println("요청 클라이언트 ip");
	    System.out.println(request.getRemoteAddr());
         request = 
        		((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
       
        /*HTTP Header 인 X-Forwarded-For 값을 확인해서 있으면 이걸 사용하고 없으면 getRemoteAddr() 사용*/
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = request.getRemoteAddr();
        System.out.println("client 진짜 ip");
        System.out.println(ip);
	    System.out.println("()()()()()()()()()()()()()()()()()()()()()()");
		
		request.setAttribute("clientIP", ip);
		
		
		
		return true;
	}


	
	
	
	
	
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}


	
	
	
	
	
	
	
	
}

