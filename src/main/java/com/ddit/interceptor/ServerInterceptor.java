package com.ddit.interceptor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ServerInterceptor extends HandlerInterceptorAdapter {
	static Map<String,Map> classMap = new LinkedHashMap<String,Map>();
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Map<String,String> valueMap = new HashMap<String, String>();
		System.out.println("()()()()()()()()()()()()()()()()()()()()()()");
		System.out.println("Serverinterceptor 입니다.");
		System.out.println("요청 클라이언트 ip");
	    System.out.println(request.getRemoteAddr());
         request = 
        		((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
       
       // HTTP Header 인 X-Forwarded-For 값을 확인해서 있으면 이걸 사용하고 없으면 getRemoteAddr() 사용
   /*     String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = request.getRemoteAddr();
        System.out.println("client 진짜 ip");
        System.out.println(ip);
		*/
		CloseableHttpResponse httpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		String ip = (String)request.getParameter("testIp"); 
		String hostName = (String)request.getParameter("hostName");
		String saveyn = request.getParameter("saveyn");
		String cpu_pcnt = request.getParameter("cpu_pcnt");
		String cpu_user_pcnt = request.getParameter("cpu_user_pcnt");
		String cpu_total_pcnt = request.getParameter("cpu_total_pcnt");
		String cpu_idle = request.getParameter("cpu_idle");
		String cpu_ip = request.getParameter("cpu_ip");
		
		if(request.getParameter("ip") != null || request.getParameter("hostName") != null){
			System.out.println("()()()()");
			System.out.println( "request에 testIP ========"+(String)request.getParameter("testIp"));
			System.out.println((String)request.getParameter("ip"));
			System.out.println((String)request.getParameter("hostName"));
			System.out.println((String)request.getParameter("cpu_pcnt"));
			System.out.println((String)request.getParameter("cpu_user_pcnt"));
			System.out.println(request.getMethod());
			
			valueMap.put("hostName", hostName);
			valueMap.put("saveyn", saveyn);
			valueMap.put("cpu_pcnt", cpu_pcnt);
			valueMap.put("cpu_user_pcnt", cpu_user_pcnt);
			valueMap.put("cpu_total_pcnt", cpu_total_pcnt);
			valueMap.put("cpu_idle", cpu_idle);
			valueMap.put("cpu_ip", cpu_ip);
			
			
			classMap.put(ip, valueMap);
			System.out.println("()()())");
			
		}
		
		System.out.println("classMap = "+classMap);
		request.setAttribute("testIp", ip);
		request.setAttribute("classMap", classMap);
		
	/*	HttpSession session = request.getSession();
		session.setAttribute("classMap", classMap);*/
		
		
		
		System.out.println("()()()()()()()()()()()()()()()()()()()()()()");
		
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
