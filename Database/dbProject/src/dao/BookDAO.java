package dao;

import dbConn.MysqlConnection;
import dto.BookDTO;

public class BookDAO extends MysqlConnection{
	
	// 책등록
	public int insertBook(BookDTO bookDTO) {
		int result = 0;
		try {
			getConn();
			
			String sql = "insert into book(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher) values(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 값 셋팅
			pstmt.setString(1, bookDTO.getBookNo());
			pstmt.setString(2, bookDTO.getBookTitle());
			pstmt.setString(3, bookDTO.getBookAuthor());
			pstmt.setInt(4, bookDTO.getBookYear());
			pstmt.setInt(5, bookDTO.getBookPrice());
			pstmt.setString(6, bookDTO.getBookPublisher());
			
			// 추가된 레코드의 수 반
			result = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("책등록 예 발생!!!");
		} finally {
			dbClose();
		}	
		return result;
	}
	
	// 회원전체 목록 출력 메소드
	public void selectBook() {
		try {
			getConn();
			
			String sql = "select bookNo, bookTitle, bookAuthor, bookYear, bookprice, bookPublisher"
					+ " from book order by bookNo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%s\t%s\t%s\t%d\t%d\t%s\n", 
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
			}
		} catch(Exception e) {
			System.out.println("책목록 선택 예외발생");
		} finally {
			dbClose();
		}
	}
	
	
	public BookDAO() {}

}
