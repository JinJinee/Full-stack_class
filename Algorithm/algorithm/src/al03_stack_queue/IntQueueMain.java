package al03_stack_queue;

import java.util.Scanner;

public class IntQueueMain {
	
	static Scanner s = new Scanner(System.in);
	// 메뉴를 입력받는 메소
	static String getMenu() {
		System.out.print("[메뉴] 1.enqueue 2.dequeue 3.peek 4.info 9.end ->");
		return s.nextLine();
	}
	
	public static void main(String[] args) {

		IntQueue queue = new IntQueue(10);
		
		while(true) {
			String menu = getMenu();
			if(menu.equals("9")) {  // 9.end 선택
				break;
			} else {  // 그외 메뉴 선택시
				switch(menu) {
				case "1" :    // 큐에 데이터를 추가한다.
					int data = Integer.parseInt(s.nextLine());
					try {
						int result = queue.enqueue(data);
					} catch(Exception e) {
						System.out.println("큐가 가득찼습니다.");
					}
					break;
					
				case "2" :    // 큐의 데이터 가져오기(제일앞에)
					try {
						int result = queue.dequeue();
						System.out.println("큐에서 가져온 데이터-> " + result);
					} catch(Exception e) {
						System.out.println("큐가 비어있습니다.");
					}
					break;
					
				case "3" :  // 제일 앞의 값을 구하여 출력
					try {
						int result = queue.peek();
						System.out.println("peek->" + result);
					} catch (Exception e) {
						System.out.println("큐가 비어있습니다.");
					}
					break;
					
				case "4" :
					// 큐의 크기
					System.out.println("큐의 크기:" + queue.getCapacity());
					// 데이터의 수
					System.out.println("데이터의 수:" + queue.getSize());
					// front 인덱스
					System.out.println("front의 인덱스:" + queue.getFrontIndex());
					// rear 인덱스
					System.out.println("rear의 인덱스:" + 	queue.getRearIndex());
					// 처음값, 마지막값을 구하라.
					System.out.println("처음값:" + queue.peek());
					System.out.println("마지막값:" + queue.getRearData());
					break;
					
				default :
					System.out.println("메뉴를 잘못선택하였습니다.");
					
				}
			}
		} 
		System.out.println("프로그램이 종료되었습니다.");
	}

}
