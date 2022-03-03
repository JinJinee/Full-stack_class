package al05_binary_tree_search;

import java.util.Scanner;

public class BinarySearchTreeTest {
	static Scanner s = new Scanner(System.in);

	// 데이터를 담을 객체
	static class Data {
		private int no;
		private String name;

		final int NO = 1; // 번호입력받을지 확인
		final int NAME = 2; // 이름 입력받은 확인

		// 번호를 얻을 수 있는 메소드
		Integer getkeyCode() {
			return no;
		}

		public String toString() {
			return name;
		}

		// 데이터 입력받는 메소드
		public void inData(String msg, int sw) {
			System.out.println(msg + "입력하세요.");

			if ((sw & NO) == NO) {
				System.out.print("번호:");
				no = Integer.parseInt(s.nextLine());
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름:");
				name = s.nextLine();

			}
		}
	}

	// Data
	// Menu
	enum Menu {
		ADD("삽입"), REMOVE("삭제"), SEARCH("검색"), PRINT("출력"), TERMINATE("종료");

		private final String message;

		Menu(String msg) {
			message = msg;
		}

		String getMessage() {
			return message;
		}

		// 사용자가 입력한 메뉴객체를 리턴하는 메소드
		static Menu menuAt(int idx) {
			for (Menu m : Menu.values()) {
				if (m.ordinal() == idx) {
					return m;
				}
			}
			return null;

		}
	} // Menu

	// 메뉴를 출력하고 사용자에게 메뉴를 입력받은 메소드
	// 반환형 : 선택한 메뉴 객체
	static Menu selectMenu() {
		int menuNo;
		do { // 메뉴를 잘못입력하면 다른 메뉴를 입력받기 위해서 반복을 실행한다.
			for (Menu m : Menu.values()) { // 메뉴출력
				System.out.printf("%d.%s ", m.ordinal(), m.getMessage());
			}
			System.out.print(": ");
			menuNo = Integer.parseInt(s.nextLine());
		} while (menuNo < Menu.ADD.ordinal() || menuNo > Menu.TERMINATE.ordinal());
		return Menu.menuAt(menuNo);
	}

	public static void main(String[] args) {
		Menu m;

		BinaryTree<Integer, Data> tree = new BinaryTree<Integer, Data>();
		Data data;
		do {
			m = selectMenu(); // 사용자가 선택한 메뉴
			switch (m) {
			case ADD: // 번호, 이름 입력받아 Node->tree에 저장
				data = new Data();
				data.inData("회원정보", data.NO | data.NAME);
				// 새로운 노드 추가하기
				tree.add(data.getkeyCode(), data);
				break;

			case REMOVE:
				// 삭제할 키를 입력받기
				data = new Data();
				data.inData("삭제할 key", data.NO);
				boolean result = tree.remove(data.getkeyCode());
				if(result) {
					System.out.println(data.getkeyCode() + "번 회원이 삭제되었습니다.");
				} else {
					System.out.println("회원정보");
				}
				break;

			case SEARCH:
				data = new Data();
				data.inData("검색할 key", data.NO);	// key가 저장됨
				
				// 검색한 결과를 리턴받는다.
				Data searchData = tree.search(data.getkeyCode());
				
				if(searchData == null) {
					System.out.println("해당키의 회원정보는 존재하지 않습니다.");
				} else {   // 검색한 결과가 있을 때
					System.out.println("번호:" + searchData.getkeyCode() + ", 이름:" + searchData.toString());
				}
				
				break;

			case PRINT:
				tree.print();
				break;
			}
			
		} while (m != Menu.TERMINATE);
		// 프로그램 종료됨

	}
	
}
