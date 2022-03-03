<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 에러가 발생하면 실행할 페이지일 경우 -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>에러가 발생하였습니다.</h1>
<h2>이미지를 클릭하시면 홈으로 이동합니다.</h2>
<div>
	errorMessage : <%=exception.getMessage() %>
</div>
<a href="/webJSP/index.jsp"><img src="../img/error.png"/></a>

</body>
</html>