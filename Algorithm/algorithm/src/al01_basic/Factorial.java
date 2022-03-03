package al01_basic;

import java.util.Scanner;

public class Factorial {
	// for문을 이용한 팩토리얼 구하기
	static int factorial1(int max) {
		// 5*4*3*2*1
		// 결과를 저장할 변수
		int result = 1;
		for(int i=max; i>=1; i--) { // 5,4,3,2,1
			result *= i;
		}
		return result;
	}
	
	// 재귀호출로 팩토리얼 구하기
	static int result = 1;
	public static void factorial2(int max) {
		// 재귀호출중단
		if(max<=0) return;
		result *= max;
		factorial2(max-1);
	}
	
	// 재귀호출 팩토리얼 구하기
	// 팩토리얼 구한 결과를 리턴하는 방법
	public static int factorial3(int max) {
		if(max <= 1) return 1;
		return max * factorial3(max-1);
	}
	
	// 팩토리얼 구하기(while문)
	public static int factorial4(int max) {
		int r = 1;
		while(true) {
			if(max<=1) return r;
			r *= max;
			max--;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// 입력한 수까지 팩토리얼 구하기
		int max = s.nextInt();
		
		// for문을 이용한 팩토리얼 구하
		int res1 = factorial1(max);
		System.out.println("f1->" + res1);
		
		// 재귀호출로 팩토리얼 구하기
		result = 1;
		factorial2(max);
		System.out.println("f2->" + result);
		
		int r = factorial3(max);
		System.out.println("f3->" + r);
		
		System.out.println("f4->" + factorial4(max));
		
		
		//
		
	}

}
