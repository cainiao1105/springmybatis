<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢迎你！！！</h1>
<form action="${pageContext.request.contextPath}/excel/importExcel.do" method="post" enctype="multipart/form-data" target="resultShow">
<input type="text" name="username" value="${user.id}">
<input type="file" name="file" /> <input type="submit" value="提交" />
</form>

</body>
<iframe name="resultShow"></iframe>
</html>