import java.util.Scanner;

import algorithm_sort.QuickSort;

public class ScoreSortTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생 수 입력 : ");
		// 학생수를 입력받는다.
		int stuNum = scan.nextInt();
		System.out.println();
		
		// 학생 수 만큼의 크기 배열 생성
		int[] score = new int[stuNum];
		
		// 학생 수 만큼 점수를 입력받아 배열에 저장
		for(int i=0; i<stuNum; i++) {
			System.out.print("학생 " + (i+1) + " 점수 입력 : ");
			score[i] = scan.nextInt();
		}
		
		// 퀵정렬 실행
		QuickSort quick = new QuickSort();
		quick.myQuickSort(score, 0, score.length-1);
		
		System.out.println();
		System.out.println("성적 순으로 정렬");
		
		for(int i=0; i<stuNum; i++) {
			System.out.println((i+1) + "등 : " + score[i]);
		}

	}

}
