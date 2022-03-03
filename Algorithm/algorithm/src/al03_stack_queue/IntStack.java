package al03_stack_queue;

public class IntStack {
	int capacity;  // 최대로 저장할 수 있는 객체의 
	int stk[];     // 정수를 저장할 수 있는 배열생성
	int point;     // stack의 채워진 값의 위치+1
	
	IntStack() {}
	IntStack(int max) {
		capacity = max;   // 값을 저잘할 수 있는 크
		point = 0;
		stk = new int[max];
		
	}

	// 데이터의 수를 리턴하는 메소드
	public int getSize() {
		return point;
	}
	
	// 메모리크기를 리턴하는 메소드
	public int getCapacity() {
		return capacity;
	}
	
	// 스택에 데이터를 추가하는 메소드
	public int push(int data) throws OverflowIntStackException {
		if(point >= capacity) {
			throw new OverflowIntStackException();
		}
		return stk[point++] = data;
	}
	
	// 스택의 제일 나중에 저장된 위치(point-1)의 값을 리턴하는 메소드
	public int pop() throws EmptyIntStackException {
		// 스택이 비어있으면 empty예외 발생시킴
		if(point<=0) {
			throw new EmptyIntStackException();
		}
		return stk[--point];
	}
	
	// 제일 위(point-1)에 있는 데이터를 리턴한다.
	public int peek() throws EmptyIntStackException {
		if(point <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[point-1];
	}
	
	// stack의 모든 데이터 출력하기
	public void print() {
		if(point <= 0) {
			System.out.println("스택이 비어있습니다.");
		} else {
			for(int i=0; i<point; i++) {
				System.out.println("stk[" + i + "]=" + stk[i]);
			}
		}
	}
	
	// 데이터의 index 구하기
	public int indexOf(int search) {
		for(int i=point-1; i>=0; i--) {  // point-1, point-2, point-3,....
			if(stk[i] == search) {
				return i;
			}
		}
		return -1;

	}
	
	// 스택에 데이터가 존재하는지 확인하는 메소드
	public boolean isEmpty() {
		// 비어있으면 true, 데이터가 있으면 false
		return point <= 0;
		
	}
	
	// 스택에 데이터가 가득찼는지 확인하는 메소드
	public boolean isFull() {
		return point >= capacity;
	}
	
	
	// 오버플로우 발생시 예외처리 클래스
	class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	// 스택이 비어있을 때 발생시킬 예외 클래스
	class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {};
	}
	
	
	
}
