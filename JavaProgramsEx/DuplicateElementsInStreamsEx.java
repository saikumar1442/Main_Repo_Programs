package JavaProgramsEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElementsInStreamsEx {

	public static void main(String[] args) {
		
		
		List<Integer> asList = Arrays.asList(10,20,10,30,40,40,10,60,25,40,25);
		
		Set<Integer> hashSet = new HashSet<>();
		
//		System.out.println("the below are non-duplicate values");
//		
//		asList.stream().filter(item -> hashSet.add(item)).forEach(System.out::println);
//		
		// below code is also working as the above by using distinct()
		
//		List<Integer> collect = asList.stream().distinct().collect(Collectors.toList());
//		
//		System.out.println("COLLECT :"+collect);scdccccscscccc
		
		System.out.println("the below are duplicate values");
		
		
		List<Integer> itemsList = Arrays.asList(10, 12, 10, 33, 40, 40, 61, 61, 61);
		
//		itemsList.stream().filter(num -> !hashSet.add(num))
//					.forEach(System.out::println);
		
		
		Set<Integer> collect = itemsList.stream().filter(num -> !hashSet.add(num))
					.collect(Collectors.toSet());
		
		System.out.println("TO find the duplicate elements in the set : "+collect);

		
		
//		Set<Integer> duplicates = asList.stream()
//		         .filter(itr -> Collections.frequency(asList, itr) > 1) // checking the frequency of duplicate items
//		         .collect(Collectors.toSet()); // adding only duplicate items to set
//		      // printing the duplicate items    
//		      System.out.println("The list of duplicate Items:" + duplicates); 
//		   
		
	}

}
