package al02_sort;

import java.util.Scanner;

public class QuichSortEx {
	
	public static void swap(int a[], int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}
	
	// 내림차순으로 정렬
	public static void myQuickDesc(int a[], int left, int right) {
		int pl = left;    // 왼쪽부터 검색할 index위치
		int pr = right;   // 오른쪽부터 검색할 index위
		int pivot = a[(left+right)/2];    // 피봇위치의 값을 구한다.
		
		do {
			while(a[pl] > pivot) {pl++;}
			while(a[pr] < pivot) {pr--;}
			
			if (pl <= pr) swap(a, pl++, pr--);

		} while(pl <= pr);
		// 정렬후 왼족을 재정렬할 재귀호출
		if(left < pr) myQuickDesc(a, left, pr);
		//정렬후 오른쪽 재정렬할 재귀호출
		if(pl < right) myQuickDesc(a, pl, right);
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수의 수 : ");
		// 입력받을 점수의 개수
		int n = sc.nextInt();
		// 입력받을 점수를 저장할 배열
		int score[] = new int[n];
		
		// 점수를 입력받아 배열에 저장한다.
		for(int i=0; i<n; i++) {
			System.out.print("국어점수" + (i+1) + " = ");
			score[i] = sc.nextInt();
		}
		
		// 퀵정렬 메소드를 사용해 높은 순서대로 점수를 정렬
		myQuickDesc(score, 0, score.length-1);
		
		for(int i=0; i<n; i++) {
			System.out.println((i+1) + "등 : " + score[i]);
		}
	}
}


/*
국어점수를 입력받아 점수순으로 출력하라. 
퀵정렬을 이용하라.

입력
국어점수의 수 : 5
국어점수1 = 56
국어점수2 = 92
국어점수3 = 95
국어점수4 = 85
국어점수5 = 56

점수순으로 출력
1등 : 95
2등 : 92
3등 : 85 
4등 : 56
5등 : 56
*/