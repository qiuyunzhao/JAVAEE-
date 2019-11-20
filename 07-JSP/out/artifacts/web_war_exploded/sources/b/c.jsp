<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(basePath);
%>

<html>
  <head>
	<base href="<%=basePath%>">
  </head>
  
  <body>
   		我是c.jsp <br>
   		<a href="02jspPro.jsp">自带的全局路径声明 02jspPro.jsp</a>
  </body>
</html>
