package al03_stack_queue;

import java.util.Scanner;

import al03_stack_queue.IntStack.EmptyIntStackException;
import al03_stack_queue.IntStack.OverflowIntStackException;

public class IntStackMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("stack의 크기입력=");
		int max = s.nextInt();
		
		// 스택객체 생성
		IntStack stack = new IntStack(max);
		
		while(true) {
			// 현재 스택의 데이터개수와 스택의 크기를 출력하고
			System.out.print("데이터의 수 -> " + stack.getSize());
			System.out.println(", 메모리크기 -> " + stack.getCapacity());
			
			// 메뉴표시 : push, pop, peek, print, search, empty, stack정보표시, 종료
			System.out.println("[메뉴] 1.push 2.pop 3.peek 4.print 5.search 6.empty 7.정보표시 8.종료");
			int menu = s.nextInt();
			if(menu==8) break;
			// 변수, 수식, 상수 -> 정수형, char, String
			switch(menu) {
			case 1 : // 스택에 값을 추가한다.
				System.out.print("스택에 추가할 데이터:");
				int data = s.nextInt();
				try {
					stack.push(data);
				} catch(OverflowIntStackException oise) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
				
			case 2 :  // 스택에서 값을 얻어온다.
				try{ 
					int result = stack.pop();
					System.out.println("스택에서 " + result + " pop하였습니다.");
				} catch(EmptyIntStackException eise) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
				
			case 3 :     // 스택에서 제일 위에 있는 데이터 가져오기
				try {
					int result = stack.peek();
					System.out.println("현재 가장 위에있는 값은 " + result + "입니다.");
				} catch (Exception e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;
				
			case 4 :     // 스택의 모든 데이터 출력
				stack.print();
				break;
				
			case 5 :     // 값을 입력하면 값이 있는 index 구하기
				System.out.println("검색할 데이터: ");
				int search = s.nextInt();
				int idx = stack.indexOf(search);
				if(idx >=0) {
					System.out.println(search + "는 스택의 " + idx + "위치에 있습니다.");	
				} else {
					System.out.println(search + "는 스택에 없습니다.");
				}
				break;
				
			case 6 :     // 스택이 비어있는지 확인
				if(stack.isEmpty()) {
					System.out.println("스택이 비어있습니다.");
				} else {
					System.out.println("스택에 데이터가 있습니다.");
				}
				break;
				
			case 7 : // 정보표시
				// 스택의 크기
				System.out.println("스택의 크기:" + stack.getCapacity());
				// 데이터 개수
				System.out.println("데이터의 갯수:" + stack.getSize());
				// 비어있는지 확인
				System.out.println("데이터 존재 유무:" + (stack.isEmpty()?"비어있음":"데이터있음"));
				// 가득찼는지 확인
				System.out.println("데이터 full 유무" + (stack.isFull()?"가득참":"여유가 있음"));
				
			}
			
		}
		System.out.println("프로그램이 종료되었습니다.");
		
	}

}
