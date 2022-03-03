<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body>
<!-- top.jsp파일 include 하기 -->
<!-- 액션태그 -->
<jsp:include page="top.jsp"></jsp:include>
<section>
	<%//=name // top.jsp의 데이터 호환되지 않는다.%>
	<img src="../img/09.png"/>
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>