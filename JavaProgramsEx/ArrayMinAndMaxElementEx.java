package JavaProgramsEx;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayMinAndMaxElementEx {

	public static void main(String[] args) {
		
		
		int arr[] = {19,23,77,89,3};
		
		int min = arr[0];
		
//		int len = arr.length;
		
//		System.out.println("LENGTH :: "+len);


		for(int i=1; i<arr.length; i++) {
			
		if(min < arr[i])   // to find the min value we need use the > or max <
				
			min = arr[i];
		}
		System.out.println("Array Min Value : "+min);
		
		
		// Using Java 8 
		
		List<Integer> asList = Arrays.asList(10,20,30,40,50,10,30);
		
		Integer integer = asList.stream().min(Integer::compare).get();
		
		System.out.println("Minimum Value : "+integer);
		
		
		Integer integer2 = asList.stream().max(Integer::compare).get();
		
		System.out.println("Maximum Value : "+integer2);
		
		
		
		List<Integer> collect = asList.stream().distinct().collect(Collectors.toList());
		
		System.out.println("To remove the duplicates in the list : "+collect);
	
		HashSet<Integer> set = new HashSet<>();
		
		
		for(Integer temp : asList) {
			
			set.add(temp);
			
		}
		System.out.println("To remove the duplicates using the Hashset : "+set);
		
		
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
		
		for(Integer temp : asList) {
			
			lhs.add(temp);
			
		}
		
		System.out.println("To remove the duplicates using the LinkedHashset : "+lhs);
 	}
	

}
