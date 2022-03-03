package al02_search;

import java.util.Scanner;

public class BinarySearch {
	// 이진 검색(BinarySearch)
	// 데이터가 정렬되어 있어야한다.
	// 가운데 위치를 구하여 검색한다.
	
	static int binarySearch(int[] arr, int n, int key) {
		// 왼쪽 시작 index
		int left = 0;
		// 오른쪽 마지막 index
		int right = n-1;
		
		do {
			// 중간 index를 구한다.
			int center = (left + right)/2;
			// 검색할 값이 중간 index에 있을 경우
			if(key == arr[center]) {
				return center;
			} else if(arr[center] < key) {  // 찾고자하는 값이 중앙값보다 크면 
				left = center+1;
			} else {    // 찾고자하는 값이 중앙값보다 작으면
				right = center-1;
			}
		} while(left <= right); 
			// 검색한 값이 없을 경우
			return -1;
	}
	
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("데이터수->");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			System.out.print("arr[" + i + "]=");
			arr[i] = s.nextInt();
		}
		
		// 검색할 수입력
		int key = s.nextInt();
		
		// 이진검색
		int result = binarySearch(arr, n, key);
		if(result >= 0) {
			System.out.println(key + "는 arr[" + result + "]위치에 존재합니다.");
		} else {
			System.out.println(key + "는 존재하지 않는 데이터입니다.");
		}

	}

}
