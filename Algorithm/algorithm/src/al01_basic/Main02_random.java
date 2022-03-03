package al01_basic;

public class Main02_random {
/*
 1. 1~100까지의 난수를 50개 만들어 합을 구하라.
 2. 한줄에 6개의 난수를 출력하고
 3. 마지막줄에 합을 출력한다.
 4. Random클래스 사용불가
 */

	
	public static void main(String[] args) {
//		int cnt = 0;
//		int sum = 0;
//		for(int i=0; i<(50/6)+1; i++) {
//			for(int j=0; j<6; j++) {
//			int r = (int)(Math.random()*100)+1;
//			System.out.printf("%4d", r);
//			cnt++;
//			sum += a;
//			if(cnt==50) break;
//			}
//			System.out.println();
//		}
//		System.out.println("합=" + sum);
		
		
		// 강사님 풀이
		int s=0;
		// 난수
		for(int i=1; i<=50; i++) {
			int ran = (int)(Math.random()*100)+1;   // 난수
			System.out.printf("%3d", ran);    // 출
			s += ran;    // 합
			if(i%6 == 0) System.out.println();
		}
		// 합출력
		System.out.println("\n합=" + s);
		
		
		
	}

}
