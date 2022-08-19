package com.flock.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

//对所有url进行过滤
@WebFilter(filterName = "LoginFilter", urlPatterns = "/*", initParams = {
		@WebInitParam(name = "url", value = "index.jsp;LoginServlet;error.jsp"),
		@WebInitParam(name = "encoding", value = "UTF-8") })
public class TestFilter implements Filter {
	private String charSet; // 定義字符串常量，用於保存request對象嘅字符編碼。
	private String encodingPage;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println("doFilter()");
//		request.setCharacterEncoding(this.charSet);// 設定request對象嘅字符編碼。
		chain.doFilter(request, response);// 向下放行。
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init()");
		this.charSet = config.getInitParameter("charSet"); // 獲得web.xml中設定嘅初始化參數。
		this.encodingPage = config.getInitParameter("encodingPage"); // 獲得web.xml中設定嘅初始化參數。
	}

	@Override
	public void destroy() {
		System.out.println("destroy()");
	}

}
