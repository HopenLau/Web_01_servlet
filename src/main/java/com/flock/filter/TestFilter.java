package com.flock.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = { "TestServlet" }, filterName = "TestFilter")
public class TestFilter implements Filter {
	private String charSet; // 定義字符串常量，用於保存request對象嘅字符編碼。
	private String encodingPage;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println("doFilter()");
		request.setCharacterEncoding(this.charSet);// 設定request對象嘅字符編碼。
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
