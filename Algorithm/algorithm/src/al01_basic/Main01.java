package al01_basic;

import java.util.Scanner;

public class Main01 {
	/*
	 1행. 입력받을 년도의 개수
	 
	 [실행]
	 6
	 4 100 400 2000 2001 2004
	 
	 [결과]
	 #1 윤년 
	 #2 평년
	 #3 윤년
	 #4 윤년
	 #5 평년
	 #6 윤년
	 */

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//		int n = scan.nextInt();
//		for(int i=1; i<n+1; i++) {
//			int year = scan.nextInt();
//			if((year%4==0 && year%100!=0) || (year%400==0)) {
//				System.out.printf("#%d 윤년\n",i);
//			} else {
//				System.out.printf("#%d 평년\n", i);
//			}
//		}
		
		
		// 강사님 풀이
		int n = Integer.parseInt(scan.nextLine());
		String data[] = scan.nextLine().split(" ");
		String r[] = new String[n];
		for(int i=0; i<n; i++) {   // 0,1,2,3,4,5
			// 4년마다 윤년(단 100의 배수는 아님), 400년마다 윤년
			int y = Integer.parseInt(data[i]);
			if((y%4==0 && y%100!=0) || (y%400==0)) { // 윤년
				r[i] = "윤년";
			} else { // 평년
				r[i] = "평년";
			}
		}
		// 출력
		for(int i=1; i<=n; i++) {
			System.out.println("#" + i + " " + r[i-1]);
		}
		
	}

}
