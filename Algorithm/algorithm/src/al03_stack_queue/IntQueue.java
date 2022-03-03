package al03_stack_queue;

public class IntQueue {
	int capacity;     // 큐의 크기
	int queue[];      // 큐의 메모리를 선언
	
	// 정수0, 실수:0.0, 논리:false, 객체형:null
	int front;        // 제일앞 위치
	int rear;         // 마지막 위치
	int dataCnt;      // queue의 데이터 개수
	
	public IntQueue() {}
	
	public IntQueue(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		
//		front = 0;
//		rear = 0;
//		dataCnt = 0;
//		
//		front = rear = dataCnt =0;
	}
	
	// 큐의 데이터를 추가하는 메소드
	public int enqueue(int data) throws QueueOverFlowException {
		// 데이터가 가득 찼는지 확인
		// capacity:용량, dataCnt:현재 데이터수
		if(capacity <= dataCnt) {  // 오버플로우 발생
			throw new QueueOverFlowException();
		}
		// 데이터를 큐에 담는다(rear:위치에)
		queue[rear++] = data;
		dataCnt++;  // 데이터 수 증가
		// rear위치를 링형으로 처리하기
		if(rear == capacity) {
			rear = 0;
		}
		System.out.println("rear->"+ rear + ", 남은 데이터수=" + dataCnt);
		return data;
	}
	
	// 큐에서 데이터를 얻어오기
	public int dequeue() throws QueueEmptyException {
		// 큐가 비어있을 때
		if(dataCnt <= 0) {
			throw new QueueEmptyException();
		}
		// 큐에 데이터가 있을 때
		// 납은 객체의 수를 1감소
		dataCnt--;
		int deData = queue[front++];
		if(front == capacity) {
			front = 0;
		}
		System.out.println("front->" + front + ", 남은 데이터수=" + dataCnt);
		return deData;
		
	}
	
	// 제일 앞의 값(front)을 구하는 메소드
	public int peek() throws QueueEmptyException {
		if(dataCnt <= 0) {
			throw new QueueEmptyException();
		}
		return queue[front];
	}
	
	// 큐의 크기를 구하는 메소드
	public int getCapacity() {
		return capacity;
	}
	
	// 데이터 수를 구하는 메소드
	public int getSize() {
		return dataCnt;
	}
	
	// front 인덱스를 구하는 메소드
	public int getFrontIndex() {
		return front;
	}
	
	// rear 인덱스를 구하는 메소드
	public int getRearIndex() {
		if(rear==0) {
			rear = capacity;
		}
		return rear-1;
	}
	
	// 마지막 값 
	public int getRearData() throws QueueEmptyException {
		if(rear == front) {
			throw new QueueEmptyException();
		}
		return queue[rear-1];
	}
	
	// 큐가 비어있을때 Empty 예외클래스
	class QueueEmptyException extends RuntimeException {
		QueueEmptyException() {}
	}

	// 오버플로우 발생시 처리할 예외
	class QueueOverFlowException extends RuntimeException {
		QueueOverFlowException() {}
		
	}
	
	
	
}
