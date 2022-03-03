package al05_binary_tree_search;

public class BinaryTree<K, V> {
	// 객체 1개를 저장할 노드클래스
	//              key, Data
	static class Node<K, V> {
		private K key;    // key
		private V data;   // data
		private Node<K, V> left;   // 왼쪽노드
		private Node<K, V> right;  // 오른쪽노드
		
		Node(K key, V data, Node<K,V> left, Node<K,V> right) {
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		// 키
		K getKey() {
			return key;
		}
		// 데이터
		V getValue() {
			return data;
		}
		// 출력
		void print() {
			System.out.println(data);
		}
		
	} // Node
	
	private Node<K, V> root;  // 루트노드
	BinaryTree() {
		root = null;   // 루트노드 초기화	
	}
	
	public int comp(K key1, K key2) {
		//       key1-key2     0:key1과 key2같다, 양수:key1크다,  음수:key2크다
		return ((Comparable<K>)key1).compareTo(key2);
	}
	
	// 노드추가(위치를 찾아서 노드추가)
	public void addNode(Node<K,V> node, K key, V data) {
		// 비교
		int result = comp(key, node.getKey());
		if(result == 0) {// 이미 있는 키값일때
			return;
		} else if(result < 0) {  // (음수)왼쪽노드를 검색
			if(node.left==null) {  // node의 왼쪽이 비어있으면, 새로운 노드를 node왼쪽에 추가
				node.left = new Node<K, V>(key, data, null, null);
			} else {
				addNode(node.left, key, data);
			}
		} else {  // (양수)오른쪽 노드를 검색
			if(node.right==null) {
				node.right = new Node<K, V>(key, data, null, null);
			} else {
				addNode(node.right, key, data);
			}
			
		}
	}
	
	// 노드추가
	public void add(K key, V data) {
		
		if(root == null) { 
			// 루트가 비어있으면 data를 노드를 만들어 root에 대입하면된다.
			root = new Node<K, V>(key, data, null, null);
		} else {
			// 루트가 비어있지 않으면 key를 이용하여 위치를 찾아서 추가해야한다.
			addNode(root, key, data);
		}
	}
	
	// 노드 삭제
	public boolean remove(K key) {
		Node<K, V> point = root;     // root 
		Node<K, V> parent = null;    // 부모
		boolean isLeftChild = true;  // 왼쪽, 오른쪽 노드인지의 정보가 필요함.
		
		while(true) {
			if(point == null) {// point가 null이면 노드가 존재하지 않는다.
				return false;
			}
			
			// 삭제할 노드 찾기
			int cond = comp(key, point.getKey());
			
			if(cond == 0) {  // 검색할 노드 찾음.
				break;
			} else {
				parent = point;  // 부모노드
				if(cond < 0) {  // 양수->오른쪽검색, 음수->왼쪽검색
					point = point.left;  // 다음노드(왼쪽의 다음노드)
					isLeftChild = true;
				} else {
					point = point.right;
					isLeftChild = false;
				}
			} 
		}
		// 부모노드, 삭제할 노드 정해짐.
		if(point.left == null && point.right==null) {
			if(point == root) root = null;
			else if(isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			
		} else if(point.left == null) { // left 노드가 없을때 (삭제할 노드의 right를 부모노드의 left에 대입한다.
			// 삭제할 노드가 root이면 오른쪽 노드를 root
			if(point == root) {
				root = point.right;
			} else if(isLeftChild) {
				parent.left = point.right;
			} else {
				parent.right = point.right;
			}
		} else if(point.right == null) {  // 삭제할 노드가 right가 없을때
			if(point == root) {
				root = point.left;
			} else if(isLeftChild) {
				parent.left = point.left;
			} else {
				parent.left = point.right;
			}
		
		} else {  // left노드와 right노드가 모두 있을때
				// point의 자식들중 제일 큰 노드구하기
			parent = point;
			Node<K, V> maxNode = point.left;
			isLeftChild = true;
			while(maxNode.right != null) {
				parent = maxNode;
				maxNode = maxNode.right;
				isLeftChild = false;
			}
			
			point.key = maxNode.key;
			point.data = maxNode.data;
			
			if(isLeftChild) {
				parent.left = maxNode.left;
			} else {
				parent.right = maxNode.left;
			}
			
		}
		// 노드삭제
		return true;
		
	}
	
	
	
	// 노드검색
	public V search(K key) {
		Node<K, V> point = root;
		
		while(true) {
			if(point == null) {
				return null;  // 노드가 없을때
			}
			// 입력받은 키와 point에 있는 키의 크기를 구하여
			// 음수가 나오면 key가 크다, 0이 나오면, 양수가 나오면 key가 적다.
			int result = comp(point.getKey(), key);
			if(result == 0) {  // key와 같은 정보를 가진 data가 검색됨.
				return point.getValue();
			} else if (result > 0) {
				point = point.left;
			} else {
				point = point.right;
			}
			
		}
		
	}
	
	
	// 노드출력
	public void subNodePrint(Node node) {
		if(node != null) {
			subNodePrint(node.left);
			System.out.println(node.getKey() + " " + node.data);
			subNodePrint(node.right);
		}
	}
	
	// 노드출력
	public void print() {
		if(root == null) {  // 노드가 비어있을 때
			System.out.println("등록된 회원이 없습니다.");
		} else {
			subNodePrint(root);
			
		}
	}
	

	
	
}
