package com.fish.system.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName WebUtils
 * @Description Web的工具类
 * @Author 柚子茶
 * @Date 2020/11/26 12:06
 * @Version 1.0
 */
public class WebUtils {

	/**
	 * @Description 获取ServletRequestAttributes类对象
	 * @author 柚子茶
	 * @date 2020/11/26 12:08
	 * @param
	 * @return ServletRequestAttributes对象
	 **/
	public static ServletRequestAttributes getServletRequestAttributes(){
		return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	}

	/**
	 * @Description 获取request请求对象
	 * @author 柚子茶
	 * @date 2020/11/26 12:11
	 * @param
	 * @return HttpServletRequest对象
	 **/
	public static HttpServletRequest getHttpServletRequest(){
		return getServletRequestAttributes().getRequest();
	}

	/**
	 * @Description 获取response响应对象
	 * @author 柚子茶
	 * @date 2020/11/26 12:13
	 * @param
	 * @return HttpServletResponse对象
	 **/
	public static HttpServletResponse getHttpServletResponse(){
		return getServletRequestAttributes().getResponse();
	}

	/**
	 * @Description 获取session对象
	 * @author 柚子茶
	 * @date 2020/11/26 12:16
	 * @param
	 * @return HttpSession对象
	 **/
	public static HttpSession getHttpSession(){
		return getHttpServletRequest().getSession();
	}

	/**
	 * @Description 获取servletContext对象
	 * @author 柚子茶
	 * @date 2020/11/26 12:19
	 * @param
	 * @return ServletContext对象
	 **/
	public static ServletContext getServletContext(){
		return getHttpServletRequest().getServletContext();
	}


}
