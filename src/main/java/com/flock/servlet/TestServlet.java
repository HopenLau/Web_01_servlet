package com.flock.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/servlet/test" }, asyncSupported = true, loadOnStartup = -1, displayName = "TestServlet", initParams = {
				@WebInitParam(name = "username", value = "tom") })
public class TestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if ("admin".equals(username) && "admin".equals(password)) {
			request.getSession().setAttribute("username", "admin");
			request.getSession().setAttribute("password", "admin");
//			response.sendRedirect("../sucess.jsp");
		} else {
//			response.sendRedirect("../failed.jsp");
		}

		response.setContentType("text/html;charset-utf-8");
		response.getWriter().write("TestServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
