package al01_basic;

import java.util.Scanner;

public class Solution02 {
	/*
	 실행
	 5
	 5*2=10
	 :
	 :
	 :
	 5*9=45
	 */
	
	public static void gugudan(int dan) {
		for(int i=2; i<10; i++) {
			int r = dan*i;
			System.out.printf("%2d * %2d = %3d\n", dan, i, r);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();
		gugudan(dan);
	}

}
