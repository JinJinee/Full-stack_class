package al04_linkedlist;

public class LinkedListTest<E> {

	// 노드 클래스
	class Node<E> {
		private E data;
		private Node<E> next; // 뒤쪽 노드
		// 생성자 메소드
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	
	//
	public LinkedListTest() {
		// head, current를 초기화
		head = null;
		current = null;
	}
	
	// 머리 노드를 저장할 변수
	private Node<E> head;
	private Node<E> current;
	
	// 머리에 노드 삽입
	public void addFirst(E data) {
		// 지금현재 헤더
		Node<E> point = head;
		new Node<E>(data, point);
		head = current = new Node<E>(data, point); 
	}
	
	// 꼬리에 노드 삽입
	public void addLast(E data) {
		if(head == null) {  // 저장된 리스트가 없다.
			addFirst(data);
		} else {   // 저장된 리스트가 있다.
			Node<E> point = head;
			while(point.next != null) {
				point = point.next;
			}
			// point는 next가 null인 노드이다.
			current = point.next = new Node<E>(data, null);
		}
	}
	
	// 머리 노드 삭제
	public void removeFirst() {
		if(head != null) {   // 노드가 존재하면
			current = head = head.next;
		}
	}
	
	// 노드 삭제
	public void remove(Node delNode) {
		if(head != null) {// 노드 있을 경우
			if(head == delNode) {
				removeFirst();
			} else {
				Node<E> point = head;
				while(point.next != delNode) {  // delNode의 앞노드 찾기
					point = point.next;
				}
				// point는 delNode의 이전노드이다.
				point.next = delNode.next;
				current = point;
			}
		}
	}
	
	// 선택 노드 삭제
	public void removeCurrent() {
		remove(current);
	}
	
	
	
	
	// 출력
	public void dump() {
		Node<E> point = head;
		while(point != null) {
			System.out.println(point.data);
			point = point.next;
		}
		
	}

	
}
