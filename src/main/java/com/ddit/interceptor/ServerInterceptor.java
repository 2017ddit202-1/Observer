package com.ddit.interceptor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;
@Component
public class ServerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("()()()()()()()()()()()()()()()()()()()()()()");
		System.out.println("Serverinterceptor 입니다.");
	/*	System.out.println("요청 클라이언트 ip");
	    System.out.println(request.getRemoteAddr());
         request = 
        		((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
       
        HTTP Header 인 X-Forwarded-For 값을 확인해서 있으면 이걸 사용하고 없으면 getRemoteAddr() 사용
        String ip = request.getHeader("X-FORWARDED-FOR");
        if (ip == null)
            ip = request.getRemoteAddr();
        System.out.println("client 진짜 ip");
        System.out.println(ip);*/
		
		CloseableHttpResponse httpResponse = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
					"http://localhost:8181/observer/server/getServer?ip="
							+ request.getParameter("ip")
							+ "&hostName="
							+ request.getParameter("hostName")
				);
		
		
		try{
			httpResponse = httpclient.execute(httpGet);
			System.out.println(httpResponse.getStatusLine());
			String str = EntityUtils.toString(httpResponse.getEntity());
			HttpEntity entity = httpResponse.getEntity();
			Gson gson = new Gson();
			 Map<String,Object> map = new HashMap<String,Object>();
	            map = (Map<String,Object>) gson.fromJson(str, map.getClass());
	            
	            System.out.println(map.toString());
	            request.setAttribute("map", map);
	            EntityUtils.consume(entity);
	            
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("()()()()()()()()()()()()()()()()()()()()()()");
		
		return true;
		}
	}

	@RequestMapping(value = "getServer", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getServer(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("GET Server Response");
		Map<String, Object> map = new HashMap<String, Object>();

		request = ((ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes()).getRequest();

		/*
		 * HTTP Header 인 X-Forwarded-For 값을 확인해서 있으면 이걸 사용하고 없으면 getRemoteAddr()
		 * 사용
		 */
		String ip = request.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = request.getRemoteAddr();
		System.out.println("client 진짜 ip");
		System.out.println(ip);
		String hostName = "";
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("ip", ip);
		map.put("hostName", hostName);
		/*
		 * map.put("flag", "get"); map.put("success", true);
		 */
		return map;
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
