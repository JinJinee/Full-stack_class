import java.util.Scanner;

import algorithm_tree.BinarySearchTree;

public class ProductSearchTest {
	static Scanner sc = new Scanner(System.in);
	
	// 데이터를 담을 객체
	static class Data {
		private int no;
		private String name;
		
		final int NO = 1;    // 번호를 입력받은지 확인
		final int NAME = 2;  // 이름을 입력받은지 확인
		
		// 번호를 얻을 수 있는 메소드
		Integer getKeyCode() {
			return no;
		}
		
		public String toString() {
			return name;
		}
		
		// 데이터 입력받는 메소드
		public void inData(String msg, int sw) {
			System.out.println("상품 " + msg);
			// 상품 번호를 입력받음
			if((sw & NO) == NO) {
				System.out.print("상품 번호 입력 : ");
				no = Integer.parseInt(sc.nextLine());
			}
			// 상품명 입력받음
			if((sw & NAME) == NAME) {
				System.out.print("상품명 입력 : ");
				name = sc.nextLine();
			}
		}
	} // Data

	// Menu 생성
	enum Menu {
		ADD("상품 등록"),
		REMOVE("상품 삭제"),
		SEARCH("상품 검색"),
		PRINT("전체 상품 조회"),
		TERMINATE("종료");
		
		private final String message;
		
		Menu(String msg) {
			message = msg;
		}
		
		String getMessage() {
			return message;
		}
		
		// 사용자가 입력한 메뉴객체를 리턴하는 메소드
		static Menu menuAt(int idx) {
			for(Menu m : Menu.values()) {
				if(m.ordinal()+1 == idx) {
					return m;
				}
			}
			return null;
		}
	} // Menu
	
	// 메뉴를 출력하고 사용자에게 메뉴를 입력받는 메소드
	// 반환형 : 선택한 메뉴 객체
	static Menu selectMenu() {
		int menuNo;
		do { // 메뉴를 잘못입력하면 다른 메뉴를 입력받기 위해서 반복을 실행한다.
			for(Menu m : Menu.values()) { // 메뉴출력
				System.out.printf("(%d) %s ", m.ordinal()+1, m.getMessage());
			} 
			System.out.println();
			System.out.print("메뉴 선택 : ");
			menuNo = Integer.parseInt(sc.nextLine());
			
		} while(menuNo < Menu.ADD.ordinal() || menuNo > Menu.TERMINATE.ordinal()+1);
		return Menu.menuAt(menuNo);
	}
	
	public static void main(String[] args) {
		Menu m;
		
		BinarySearchTree<Integer, Data> tree = new BinarySearchTree<Integer, Data>();
		Data data;
		do {
			m = selectMenu();  // 사용자가 선택한 메뉴
			switch(m) {
			case ADD:  // 번호, 상품명을 입력받아 Node->tree에 저장	
				System.out.println();
				data = new Data();
				data.inData("등록", data.NO | data.NAME);
				// 새로운 노드 추가하기
				tree.add(data.getKeyCode(), data);
				System.out.println();
				break;
				
			case REMOVE:
				System.out.println();
				// 삭제할 키를 입력받기
				data = new Data();
				data.inData("삭제", data.NO); 
				boolean result = tree.remove(data.getKeyCode());
				if(result) {
					System.out.println("상품 삭제 완료");
				} else {
					System.out.println("등록된 상품이 없습니다.");
				}
				System.out.println();
				break;
				
			case SEARCH:
				System.out.println();
				data = new Data();
				data.inData("검색", data.NO);  // key가 저장됨
				
				// 검색한 결과를 리턴받는다.
				Data searchData = tree.search(data.getKeyCode());
				
				if(searchData == null) {  // 검색한 결과가 없을 때
					System.out.println();
					System.out.println("등록된 상품이 없습니다.");
				} else {  // 검색한 결과가 있을 때
					System.out.println("상품명 : " + searchData.toString());
				}
				System.out.println();
				break;
				
			case PRINT:
				tree.print();
				System.out.println();
				break;	
			}
		} while(m != Menu.TERMINATE);
		System.out.println("종료합니다.");
		// 프로그램 종료됨
		
	} // main
} // class
