<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.Wares"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城</title>
<link rel="stylesheet" href="page.css">

<script type="text/javascript">
<%
String result=(String)session.getAttribute("buyit_result");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("buyit_result", null);
}%>
</script>
</head>

<body class="allbody">
<c:if test="${empty sessionScope.user}">
<%response.sendRedirect("admin_login.jsp"); %>
</c:if>
<c:if test="${not empty sessionScope.user}">
     <a class="us_a" href="<%=request.getContextPath()%>/servlet_yhspxx">商品预览</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_spxx">商品记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_jl">申请记录</a>
    <a class="us_a" href="admin_change.jsp">修改密码</a>
    <a class="us_a" href="admin_waresup.jsp">上传商品</a>
     <a class="us_a" href="servlet_tcdl">退出登录</a>
    <hr />
<%
	List<Wares> asd= new ArrayList<Wares>();
	asd=(List<Wares>)session.getAttribute("yhspxx");
	int n=0;
	%>
	<div class="spzhuye">
		<%for(int i=0;i<asd.size();i++){
			Wares qwe=new Wares();
			qwe=asd.get(i);
			if(!qwe.getWaresstate().equals("remove")){
				n++;
			%>
        <div class="spzhuye1" onclick="window.open('servlet_pergood_admin?wid=<%= qwe.getWaresid()%>','_self')">
            <div class="spzhuye1_1">
                <img src="upload1/<%= qwe.getWarespicture()%>">
            </div> 
            <div class="spzhuye1_2">
                    <%=qwe.getWaresname() %>
            </div>
            <div class="spzhuye1_3">
                    <%=qwe.getWaresprice() %>元
            </div>
        </div>
        <%}} %>
    </div>
    <%if(n==0){ %>
    <h1 style="text-align:center;">暂无出售商品</h1>
    <%} %>
</c:if>
</body>
</html>