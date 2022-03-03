package al02_sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void swap(int a[], int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	public static void myQuick(int a[], int left, int right) {
		int pl = left;    // 왼쪽부터 검색할 index위치
		int pr = right;   // 오른쪽부터 검색할 index위
		int pivot = a[(left+right)/2];    // 피봇위치의 값을 구한다.
		
		do {
			// 피봇기준 왼쪽에서 오른쪽으로 피봇의 값보다 큰데이터가 있는 index 찾기
			while(a[pl] < pivot) {pl++;}
			// 피봇기준 오른쪽에서 왼쪽으로 피봇의 값보다 작은 데이터가 있는 index 찾기
			while(a[pr] > pivot) {pr--;}
			
			if (pl <= pr) {  // pl의 위치값과, pr위치의 값을 교환한다.
				swap(a, pl++, pr--);
			}
		} while(pl <= pr);
		// 정렬후 왼족을 재정렬할 재귀호출
		if(left < pr) {
			myQuick(a, left, pr);
		}
		//정렬후 오른쪽 재정렬할 재귀호출
		if(pl < right) {
			myQuick(a, pl, right);
		}
		
	}

	public static void main(String[] args) {
		int arr[] = {175, 170, 160, 168, 165, 172, 155, 150};
		
		System.out.println("정렬전:" + Arrays.toString(arr));
		myQuick(arr, 0, 7);
		System.out.println("정렬후:" + Arrays.toString(arr));
		
	}

}
