import java.util.Scanner;

import dao.BookDAO;
import dto.BookDTO;

public class BookTest {
	Scanner scan = new Scanner(System.in);
	
	public void start() {
		while(true) {
			menuOutput();
			int menu = Integer.parseInt(scan.nextLine());
			
			if(menu==1) {   // 책목록 출력
				bookAllList();
			} else if(menu==2) {  // 책등록
				bookInsert();
			} else if(menu==3) {  // 프로그램 종료
				System.exit(0);
			} else {
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		} // end of while
	} // end of start method
	
	// 책 등록하기
	public void bookInsert() {
		// 등록할 책정보를 입력받아서 DTO객체에 setter를 한다.
		BookDTO dto = new BookDTO();
		System.out.print("도서 번호-> ");
		dto.setBookNo(scan.nextLine());
		System.out.print("도서 제목-> ");
		dto.setBookTitle(scan.nextLine());
		System.out.print("저자-> ");
		dto.setBookAuthor(scan.nextLine());
		System.out.print("발행연도-> ");
		dto.setBookYear(Integer.parseInt(scan.nextLine()));
		System.out.print("가격-> ");
		dto.setBookPrice(Integer.parseInt(scan.nextLine()));
		System.out.print("출판사-> ");
		dto.setBookPublisher(scan.nextLine());
		
		BookDAO dao = new BookDAO();
		int result = dao.insertBook(dto);
		if(result > 0) {  // 책등록
			System.out.println(dto.getBookTitle() + "의 정보가 등록되었습니다.");
		} else {  // 등록실패
			System.out.println("회원등록이 실패하였습니다.");
		}
	}
	
	
	public void bookAllList() {
		BookDAO dao = new BookDAO();
		dao.selectBook();
	}
	
	
	// 메뉴 출력 메소드
	public void menuOutput() {
		System.out.print("[메뉴] 1.책목록 2.책등록 3.종료 ");
	} // end of menuOuput method
	
	
	
	public BookTest() {}

	public static void main(String[] args) {
		new BookTest().start();
	}

} // end of class 
