<%@page import="com.vo.Wares"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城</title>
<link rel="stylesheet" href="page.css">
</head>
<body class="allbody">
<%
Wares w=(Wares)session.getAttribute("ware");
int id=w.getWaresid();
%>
    <a class="us_a" href="servlet_yhspxxcus">商城首页</a>
    <a class="us_a" href="admin_login.jsp">登录</a>
    <hr />
    <div class="spxq1">
        <div class="spxq1_1">
            <img style="width: 100%;height:100%;" src="upload1/<%= w.getWarespicture()%>">
        </div>
        <div class="spxq1_2">
            <div class="spxq1_1_1">
            商品名：<%= w.getWaresname()%>
            </div>
            <div class="spxq1_1_1">
             商品价格：<%=w.getWaresprice()%>￥
            </div>
            <form action="cus_buyit.jsp">
            	<input type="hidden" name="wid" value="<%=w.getWaresid() %>">
            	<input type="hidden" name="shopid" value="<%=w.getShopid() %>">
            	<%if(w.getWaresstate().equals("putaway")){ %>
                <input class="spxqgm" type="submit" name="submit" value="购买并填写个人信息">
                <%}else{ %>
                <%="商品已冻结" %>
                <%} %>
            </form>
            <div class="spxq1_1_1">
            </div>
        </div>
    </div>
    <div class="spxq2">
        <a class="us_a" href="">商品详情</a>
        <hr/>
        <%= w.getMatkering()%>
        <div class="spxq2_1">
    </div>

</body>
</html>
