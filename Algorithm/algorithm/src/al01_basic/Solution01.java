package al01_basic;

import java.util.Scanner;

public class Solution01 {
	/*
	 실행
	 5
	 5*2=10
	 :
	 :
	 :
	 5*9=45
	 */
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();
		for(int i=2; i<10; i++) {
			System.out.printf("%2d * %2d = %3d\n", dan, i, dan*i);
		}
	}

}
