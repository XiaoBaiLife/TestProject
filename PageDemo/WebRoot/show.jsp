<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		<table border="1" cellpadding="5" cellspacing="5">
  			<tr>
  				<td>商品编号</td>
  				<td>商品名称</td>
  				<td>商品价格</td>
  				<td>商品类型</td>
  			</tr>
  			<c:forEach var="sp" items="${sessionScope.list }">
	  			<tr>
	  				<td>${sp.gid }</td>
	  				<td>${sp.gname }</td>
	  				<td>${sp.price }</td>
	  				<td>${sp.type }</td>
	  			</tr>
  			</c:forEach>
  			<tr>
  				<td><a href="PageServlet?pageNum=1">首页</a></td>
  				<td><a href="PageServlet?pageNum=${pageNum-1 }">上一页</a></td>
  				<td><a href="PageServlet?pageNum=${pageNum+1 }">下一页</a></td>
  				<td><a href="PageServlet?pageNum=${totalPage }">末页</a> | 当前：${pageNum }/${totalPage }</td>
  			</tr>
  			
  		</table>
  </body>
</html>
