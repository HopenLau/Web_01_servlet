<%-- 設定JSP頁面嘅屬性：設定MIME類型，設定字符編碼 --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>flock</title>
</head>
<%-- 設定頁面背景顏色 --%>
<body bgcolor="#ffffc0" onLoad="welcome()" onUnload="bye()" >
<% System.out.println(
		"/test.jsp {\r\n" + 
		"	[" + new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS").format(new java.util.Date()) + "]"
		);  %>

<%
	request.setCharacterEncoding("UTF-8") ;
%>
      name：<%=request.getAttribute("name")%><br>
   <%-- 使用EL輸出表達式 --%>
      age：${requestScope.age}

<% System.out.println("} /test.jsp\r\n"); %>
</body>
</html>
