<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码页面</title>
<link rel="stylesheet" href="denglu.css">
<script type="text/javascript">
<%
String result=(String)session.getAttribute("xgsjmm_result");
if(result!=null){%>
	alert("<%=result%>");
	<%session.setAttribute("xgsjmm_result", null);
}%>
</script>
</head>
<body >
<c:if test="${empty sessionScope.user}">
<%response.sendRedirect("admin_login.jsp"); %>
</c:if>
<c:if test="${not empty sessionScope.user}">
<div class="allbody">
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_yhspxx">商品首页</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_spxx">已上传商品</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_jl">查看申请记录</a>
    <a class="us_a" href="<%=request.getContextPath()%>/servlet_lsjl">查看历史记录</a>
    <a class="us_a" href="admin_change.jsp">修改密码</a>
    <a class="us_a" href="admin_waresup.jsp">上传商品</a>
    <a class="us_a" href="servlet_tcdl">退出登录</a>
    <hr />
</div>
 <%
	String mess = (String)request.getAttribute("mess");         // 获取错误属性
	if(mess != null) {
	%>
	<script type="text/javascript" language="javascript">
	alert("<%=mess%>");                                            // 弹出错误信息
	window.location='admin_change.jsp' ;                            // 跳转到登录界面
	</script>
	<%
	}
	%>
   <div class="bodydelu">
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>修改密码</h4>
            <form action="servlet_xgsjmm">
                 <input class="acc" placeholder="旧密码" type="text" name="pwd1"><br/>
           		 <input class="acc" placeholder="新密码" type="password" name="pwd2"><br/>
            	<input class="acc" placeholder="确认密码" type="password" name="pwd3"><br/>
                <input class="submit" type="submit" name="submit" value="确认">
            </form>
        </div>
    </div>
</div>
</c:if>
</body>

</html>