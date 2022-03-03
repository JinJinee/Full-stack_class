package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnection {

	// 1. 드라이브 로딩
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(Exception e) {
			System.out.println("드라이브로딩 예외 발생!!!");
			e.printStackTrace();
		}
	}
	
	// 멤버영역에 변수 선언
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	// 2. DB연결 메소드
	public void getConn() {
		String url = "jdbc:mysql://localhost/mydb";
		String id = "root";
		String password = "tls97486";
		try {
			conn = DriverManager.getConnection(url, id, password);
		} catch(Exception e) {
			System.out.println("데이터베이스 연결 예외 발생!!!");
			e.printStackTrace();
		}
	}
	
	// 3. DB종료 메소드
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			System.out.println("데이터베이스 닫기 예외 발생!!!");
		}
	}
	
	public MysqlConnection() {}

}
