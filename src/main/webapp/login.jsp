<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
</script>
<body>
<form action="${pageContext.request.contextPath}/login/login.do" method="post">
	<table>
	<tr>
	<th>用户名：</th>
	<td><input type="text" name="username" > </td>
	</tr>
	<tr>
	<th>密码：</th>
	<td><input type="password" name="password" > </td>
	</tr>
	<tr><td align="center"><input type="submit" value="登录"> </td></tr>
	</table>

</form>

</body>
</html>