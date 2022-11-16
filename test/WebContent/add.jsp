<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写商家具体信息</title>
</head>
<body>
<c:if test="${empty sessionScope.user}">
<%response.sendRedirect("admin_login.jsp"); %>
</c:if>
<c:if test="${not empty sessionScope.user}">
<a href="admin_function.jsp">返回</a>
<h1>填写商家具体信息</h1>
<form action="addrs.jsp" >
商家姓名：<input type="text" name="sellername"><br/>
商家电话：<input type="text" name="sellerphone"><br/>
商家店铺id：<input type="text" name="shopid"><br/>
<input type="submit" value="提交">
</form>
</c:if>
</body>
</html>