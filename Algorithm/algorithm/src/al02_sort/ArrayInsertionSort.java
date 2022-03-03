package al02_sort;

import java.util.Arrays;
import java.util.Random;

public class ArrayInsertionSort {

	// 삽입정렬(Insertion sort)
	public static void mySort(int a[], int n) {
		for(int i=1; i<n; i++) {   // 1,2,3,4,5,6,7,...
			int tmp = a[i];
			int j;
			for(j=i; j>0  && a[j-1] > tmp; j--) {   // 1,
				if(a[j-1] > tmp) {
					a[j] = a[j-1]; 
				}
			}
			a[j] = tmp;
			
		}
	}
	
	
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] arr = new int[10];
		
		for (int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(100)+1;   // 1~100
		}
		
		System.out.println("정렬전:" + Arrays.toString(arr));
		mySort(arr, 10);
		System.out.println("정렬후:" + Arrays.toString(arr));
		
		
	}

}
