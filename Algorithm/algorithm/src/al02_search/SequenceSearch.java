package al02_search;

import java.util.Scanner;

// 선형검색(LenearSearch, SequenceSearch)
// 순착적으로 검색한다.
public class SequenceSearch {
	// for문을 이용하여 검색하기
	// key의 값이 있는 위치를 구하여 index를 반환하는 메소드
	static int linearSearch1(int[] data, int n, int key) {
		// 배열에서 key값을 검색하여 index를 리턴한다.
		// 만약 검색된 index가 없으면 -1을 리턴한다.
		for(int i=0; i<n; i++) {  // 0,1,2,3,....n
			if(data[i] == key) {
				return i;
			}
		}
		return -1;
	}
	// while문을 이용한 데이터위치 검
	static int linearSearch2(int[] d, int n, int k) {
		int i = 0;
		while(true) {
			// i index위치가 존재하는가 
			if(i==n) {
				return -1;
			} 
			if(d[i] == k) { // 검색할 데이터를 찾은 경
				return i;
			}
			// 다음 index의 값을 확인하기 위해서 index를 1증가
			++i;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// 데이터의 개수 입력 : 배열을 생성
		System.out.print("데이터수->");
		int n = s.nextInt();
		
		// 배열을 생성
		int data[] = new int[n]; // 5-> 0,1,2,3,4
		
		// 데이터입력
		for(int i=0; i<n; i++) {
			System.out.print("data["+ i + "]=");
			data[i] = s.nextInt();
		}
		
		// 찾은 숫자를 입력받는다.
		System.out.print("검색할 데이터->");
		int key = s.nextInt();
		
		// for를 이용한 선형검색 호출
		int idx = linearSearch1(data, n, key);   // -1,0,1,2,3,...
		if(idx>=0) {   // 검색한 데이터가 있을 때 
			System.out.println(key + "는 data[" + idx + "]에 있습니다.");
		} else { // 검색한 데이터가 없을 때 
			System.out.println(key + "는 존재하지 않는 데이터입니다.");
		}
		
		// while문을 이용한 선형검색 호출
		int idx2 = linearSearch2(data, n, key);
		if(idx2>=0) {   // 검색한 데이터가 존재한다.
			System.out.println(key + "는 data[" + idx2 + "]에 존재한다.");
		} else {        // 검색한 데이터가 존재하지 않는다.
			System.out.println(key + "는 존재하지 않는 데이터입니다.");
		}
		

	}

}
