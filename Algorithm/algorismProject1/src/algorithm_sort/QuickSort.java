package algorithm_sort;

public class QuickSort {
	public static void swap(int arr[], int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
	
	// 내림차순으로 퀵정렬을 하는 메소드 
	public static void myQuickSort(int arr[], int left, int right) {
		int pl = left;    // 왼쪽부터 검색할 index위치
		int pr = right;   // 오른쪽부터 검색할 index위치
		int pivot = arr[(left+right)/2];    // 피봇위치의 값을 구한다.
		
		do {
			// 피봇기준 가장 왼쪽에서 오른쪽으로 피봇의 값보다 작은 데이터가 있는 index 찾기
			while(arr[pl] > pivot) pl++;
			// 피봇기준 가장 오른쪽에서 왼쪽으로 피봇의 값보다 큰 데이터가 있는 index 찾기
			while(arr[pr] < pivot) pr--;
			
			// pl의 위치값과, pr위치의 값을 교환한다.
			if(pl <= pr) swap(arr, pl++, pr--);

		} while(pl <= pr);
		
		// 정렬후 왼족을 재정렬할 재귀호출
		if(left < pr) myQuickSort(arr, left, pr);
		//정렬후 오른쪽 재정렬할 재귀호출
		if(pl < right) myQuickSort(arr, pl, right);
	}
}
