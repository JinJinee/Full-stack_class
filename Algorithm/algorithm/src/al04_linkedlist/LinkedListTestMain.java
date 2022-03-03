package al04_linkedlist;

import java.util.Scanner;

public class LinkedListTestMain {

	static Scanner scan = new Scanner(System.in);
			
	// 번호와 이름을 저장할 수 있는 내부클래스
	static class Data {
		private Integer no;  // 번호
		private String name; // 이름
		
		static final int NO = 1;    // 번호를 입력받을지 확인
		static final int NAME = 2;  
		
		// String 리턴으로 값을 반환
		public String toString() {
			return no + " : " + name;
		}
		
		// 번호 또는 이름을 입력받는 메소드
		public void scanData(String msg, int s) {
			// s에는 1,2,3 중에 하나가 대입된다.
			if((s & NO) == NO) {
				System.out.print("번호->");  // 번호입력
				no = scan.nextInt();
			}
			if((s & NAME) == NAME) {
				// 이름입력
				System.out.print("이름->");
				name = scan.next();   // 공백을 기준으로 1단어를 입력, nextLine()->enter까지 1줄입력받는다.
			}
		}
	}
	
	// 메뉴를 열거형으로 만들기
	enum Menu {
		ADD_FIRST("머리에 노드 삽입"),
		ADD_LAST("꼬리에 노드 삽입"),
		REMOVE_FIRST("머리 노드 삭제"),
		REMOVE_CURRENT("선택한 노드 삭제"),
		DUMP("모든 노드 출력"),
		TERMINATE("종료");
		
		private final String message;
		
		static Menu MenuAt(int idx) {
			for (Menu m: Menu.values()) {
				if(m.ordinal()==idx)
					return m;
			}
			return null;
		}
		Menu(String str){
			message = str;
		}
		String getMessage() {
			return message;
		}
	}
	
	// 메뉴를 표시하고 메뉴의 index를 입력받아 선택한 메뉴객체를 리턴하는 메소드
	static Menu SelectMenu() {
		int key;
		do {
			for(Menu m : Menu.values()) {
				System.out.printf("(%d)%s ", m.ordinal(), m.getMessage());
			}
			System.out.print("->");
			key = scan.nextInt();
		} while(key<Menu.ADD_FIRST.ordinal() || key>Menu.TERMINATE.ordinal());
		
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args) {
		Menu menu;    // 선택한 메뉴
		LinkedListTest<Data> list = new LinkedListTest<Data>();
		
		do {
			// 메뉴가 표시
			Data data;
			menu = SelectMenu();
			switch(menu) {
			case ADD_FIRST :   // 머리에 노드삽입
				data = new Data();
				data.scanData("머리노드삽입", Data.NO | Data.NAME);
				list.addFirst(data);// List에 저장
				break;
				 
			case ADD_LAST :    // 꼬리에 노드삽입
				data = new Data();
				data.scanData("꼬리노드삽입", Data.NO | Data.NAME);
				list.addLast(data);
				break;
				
			case REMOVE_FIRST :   // 머리 노드삭제
				list.removeFirst();
				break;
				
			case REMOVE_CURRENT :  // 선택 노드삭제
				list.removeCurrent();
				break;
				
			case DUMP :       // 모든 노드출력
				list.dump();
				break;

				
			}
			
		} while(menu != Menu.TERMINATE);
		System.out.println("프로그램이 종료되었습니다.");
		
		
	}

}
