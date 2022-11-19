<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息填写</title>
<link rel="stylesheet" href="buyit.css">
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
<a class="us_a" href="servlet_yhspxxcus">商城首页</a>
	<a class="us_a" href="admin_login.jsp">登录</a>
    <hr />
<h1>填写个人信息</h1>
<% 
	String wid= request.getParameter("wid");
	String shopid = request.getParameter("shopid");
%>


<div class="bodydelu">
    <div class="box">
        <div class="left"></div>
        <div class="right">
            <h4>填写个人信息</h4>
            <form action="servlet_scjlcus">              
		            <input class="acc" type="hidden" name="waresid" value=<%=wid %>>
					<input  class="acc" type="hidden" name="shopid" value=<%=shopid %>>
					<input class="acc" type="text" name="buyerid"  placeholder="客户名"><br/><%--之后系统自动获取 --%>
					<input class="acc" type="hidden" name="waresnumber" value=1>
					<input class="acc" type="text" name="buyeraddress" placeholder="收货地址(必填)"><br/>
					<input class="acc" type="text" name="buyerphone" placeholder="电话号码(必填)"><br/>
                <input class="submit" type="submit" name="submit" value="确认">
            </form>
        </div>
    </div>
</div>

</body>
</html>