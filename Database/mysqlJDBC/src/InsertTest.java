import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	public InsertTest() {
		
		
	}

	public void empInsert() {
		// 사원번호, 이름, 급여, 입사일을 레코드 추가하기
		
		try {
			// 1. 드라이브 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB 연결
			//    										 server/dbname
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/demo", "root", "root1234");
			
			// 3. preparedStatement 객체 생성 : 쿼리문을 이용
			// 사원번호 : 5555, 이름 : kim, 급여 : 4500, 입사일 : 현재 날짜와 시간으로 설정
			String sql = "insert into emp(empno, ename, sal, hiredate) values(?, ?, ?, now())";
			pstmt = con.prepareStatement(sql);
			
			// ?에 값을 셋팅한다
			pstmt.setInt(1, 5555);
			pstmt.setString(2, "kim");
			pstmt.setDouble(3, 4500);
			
			// 4. 실행
			// 쿼리문을 실행하여 추가된 레코드의 수를 반환한다.
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("레코드가 추가되었습니다.");
			} else {
				System.out.println("레코드 추가 실패하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		new InsertTest().empInsert();

	}

}
