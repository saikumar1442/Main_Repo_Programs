package JavaProgramsEx;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySumEx {

	public static void main(String[] args) {
		
//		int arr[] = {1,2,3,4,5,6,7,8,9};
//		
//		int sum = 0;
//		
////		for(int i =0; i<arr.length;i++) {
////			
////			sum = sum + arr[i];
////		}
//		
//		for(int temp : arr) {
//			
//			sum = sum + temp;
//			
//		}
//
//		System.out.println("Total sum count : "+sum);
		
		
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream()
		  .collect(Collectors.summingInt(Integer::intValue));
		
		System.out.println("SUM : "+sum);
		
	}

}
