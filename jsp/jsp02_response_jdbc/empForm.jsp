<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>

<%!
	// 2. 드라이브로딩
	public Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/demo","root","tls97486");
		} catch(Exception e){
			System.out.println("DB연결 에러 발생...");
			e.printStackTrace();
		}
		return con;
	}
%>
<%
	// dept테이블의 deptno, dname을 선택
	Connection conn = getConnection();
	String sql = "select deptno, dname from dept order by dname asc";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	ResultSet rs = pstmt.executeQuery();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--      						/webJSP
 -->
<form method="post" action="<%=request.getContextPath()%>/jsp02_response_jdbc/empFormOk.jsp">
	사원번호 : <input type="text" name="empno"><br>
	사원명 : <input type="text" name="ename"><br>	
	부서코드 : 
		<select name="deptno">
			<%while(rs.next()){ %>
			<option value="<%=rs.getInt(1)%>"><%=rs.getString(2) %></option>
			<%} %>
		</select><br>
	<input type="submit" value="사원등록">
</form>

</body>
</html>
<%
	rs.close();
	pstmt.close();
	conn.close();
%>