package test;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 테스트케이스
		int t = scan.nextInt();

		
		// 숫자채우기
		for(int i=0; i<t; i++) {
			// 점수를 저장할 배열생성
			int cnt = scan.nextInt();
			int arr[] = new int[101];
			
			// 학생들의 점수를 배열에 카운트
			for(int j=0; j<1000; j++) {
				arr[scan.nextInt()]++;	
			}
			
			// 최대값구하기
			int max = 0;
			int idx = 0;
			for(int k=0; k<arr.length; k++) {
				if(arr[k] >= max) {
					max = arr[k];
					idx = k;
				}
			}
			System.out.println("#" + cnt + " " + idx);
		}
	}		
}
		
			