package com.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.programs.entity.Product;

public class ArrayPrograms {

	public static void main(String[] args) {

		Integer arr[] = { 5, 2, 9, 4, 1, 7, 2 };
		
// Convert List of Integer into Integer array

        List<Integer>integerList = new ArrayList<>();
					integerList.add(10);
					integerList.add(20);
					integerList.add(30);
					integerList.add(40);

// Convert List<Integer> to int[] using streams
		int[] intArray = integerList.stream()
									.mapToInt(Integer::intValue) // or i ->i
									.toArray();
		System.out.println("Original List: " + integerList);  // [10, 20, 30, 40]
		System.out.println("Converted Array: " + Arrays.toString(intArray)); // [10, 20, 30, 40]

// Convert array into a List, Set and Map

		List<Integer> asList = Arrays.asList(arr);

		List<Integer> list1 = Arrays.stream(arr).collect(Collectors.toList());

		System.out.println("Convert an array to an List" + list1 + " asList : " + asList); // [5, 2, 9, 4, 1, 7, 2]

		Set<Integer> priceSet = Arrays.stream(arr).collect(Collectors.toSet());

		System.out.println("Convert an array to an set" + priceSet); // [1, 2, 4, 5, 7, 9]

		Product[] products = { new Product("P001", "Laptop"), new Product("P002", "Mouse"),
				new Product("P003", "Keyboard") };

		Map<String, String> productMap = Arrays.stream(products).collect(Collectors.toMap(Product::getId, // Key is the
																											// product
																											// ID
				Product::getName // Value is the product name
		));
		System.out.println("Convert an array to an Map" + productMap); // {P001=Laptop, P003=Keyboard, P002=Mouse}

		List<Integer> list = Arrays.asList(2, 7, 4, 2, 2, 6, 1, 9, 4);

// To find the max integer number

		// Integer maxNumber = list.stream().max(Integer::compare).get();

		// Integer maxNumber =
		// list.stream().max(Comparator.comparing(Integer::valueOf)).get();

		// Integer maxNumber = Collections.max(list);

		// int maxNumber = list.stream().mapToInt( n ->
		// n).max().orElseThrow(NoSuchElementException::new);

		// Integer integer2 = list.stream().sorted((a,b) -> b-a).findFirst().get();

		// System.out.println("Maximum Number ::: " + integer2);

		Optional<Integer> max = list1.stream().max(Integer::compareTo);

		max.ifPresent(val -> System.out.println("The Maximum Number is : " + val)); // Output : 9
		


// TO find the minimum integer number

		// Integer integer = list.stream().min(Integer::compare).get();

		// Integer integer2 =
		// list.stream().min(Comparator.comparing(Integer::valueOf)).get();

		// min = Collections.min(list);

		// int orElseThrow = list.stream().mapToInt(n ->
		// n).min().orElseThrow(NoSuchElementException::new);

		// Integer min =
		// list.stream().sorted(Comparator.comparingInt(Integer::valueOf)).findFirst().get();

		Integer min = list.stream().sorted().findFirst().get();

		System.out.println("Minimum Number ::: " + min); // Output : 1
		
// Find the Maximum element/value/number in an array
		
		int aa[] = {66,24,98,33,76};

        int asInt = Arrays.stream(aa).max().getAsInt();

        System.out.println("TO find the maximum number in an array : " + asInt); // 98
		
// Find the minimum element/value/number in an array 

        int asInt2 = Arrays.stream(aa).min().getAsInt();

        System.out.println("To find the minimum number in an array  : " +asInt2); // 24

// To sort the order in Ascending

		List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
		
		// asList.stream().sorted().forEach(n ->System.out.println("Sorted Order : "+n));

		// List<Integer> collect = list.stream().sorted().toList();
		
		System.out.println("elements in Sorted Order"+collect); // [1, 2, 2, 2, 4, 4, 6, 7, 9]
		
		List<Integer> sortingwithRemoveDuplicate = list.stream().sorted().distinct().collect(Collectors.toList());
		
		System.out.println("elements in Sorted Order + duplicate remove : "+sortingwithRemoveDuplicate); // [1, 2, 4, 6, 7, 9]


// To Unsort the order in descending

		List<Integer> collect2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		// List<Integer> collect2 = list.stream().sorted((a,b) -> b-a).toList();

		System.out.println("UnSorting order ::: " + collect2); // [9, 7, 6, 4, 4, 2, 2, 2, 1]
		
		List<Integer> unSortedOrderwithRemoveDuplicate = asList.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
		
		System.out.println("Unsorted order using sorted() with duplicate removed : "+unSortedOrderwithRemoveDuplicate); // [9, 7, 5, 4, 2, 1]
		
		Collections.reverse(asList);

// By using the distinct()

		List<Integer> removeDuplicateValues = list.stream().sorted().distinct().collect(Collectors.toList());

		System.out.println("To Sort and Remove Duplicate values ::: " + removeDuplicateValues); // [1, 2, 4, 6, 7, 9]

// TO remove the duplicate using 2 ways 1. distinct() and 2. set

		List<Integer> collect3 = list.stream().distinct().collect(Collectors.toList());

		System.out.println("To Remove the duplicates ::: " + collect3); // [2, 7, 4, 6, 1, 9]

		HashSet<Integer> set = new HashSet<>();

		List<Integer> collect4 = list.stream().sorted().filter(n -> !set.add(n)).collect(Collectors.toList());

		System.out.println("To print the Duplicates elements :::: " + collect4); // [2, 2, 4]

		List<Integer> duplicates = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());

		System.out.println("Duplicate elements: " + duplicates); // [2, 4]

// To find the 2nd highest number in the list of Integer

		// So here if we want to find the 3rd or 4th highest number, in the skip() we
		// need to pass the values like n-1

		Integer integer = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

		System.out.println("Second highest number ::: " + integer); // 7

		Optional<Integer> secondHighest = list.stream().sorted((a, b) -> b - a) // Sort in descending order
				.skip(1) // Skip the first (highest) element
				.findFirst(); // Get the second element

		secondHighest.ifPresent(second -> System.out.println("The second highest number is: " + second)); // 7

// To find the sum of Each element in the list of integer

		List<Integer> asList1 = Arrays.asList(2, 4, 1, 3, 5);

		Integer collect5 = asList1.stream().collect(Collectors.summingInt(Integer::intValue));

		Integer reduce = asList1.stream().reduce(0, (a, b) -> a + b);

		int sum = asList1.stream().mapToInt(Integer::intValue).sum();

		Integer reduce2 = asList1.stream().reduce(0, Integer::sum);

		System.out.println("Sum of Each Elements::: " + sum); // Output : 15

		List<Integer> listVal = Arrays.asList(3, 2, 4, 1, 5, 8);

// To multiply the each element in the list and return the sum

		Integer multiplyEachElement = listVal.stream().reduce(1, (a, b) -> a * b);

		System.out.println("To multiply each element in the list and return the sum ::: " + multiplyEachElement); // Output ::: 960																								

		List<Integer> multipliedNumbers = listVal.stream().map(n -> n * 2) // Multiply each element by 2
				.collect(Collectors.toList());

		System.out.println("Multiplied elements: " + multipliedNumbers); // Output : [6, 4, 8, 2, 10, 16]

// TO find the Even Numbers in the List of Integer 

		List<Integer> listValues = Arrays.asList(1, 2, 3, 4, 5);

		IntStream evenNumbers = IntStream.range(1, 11).filter(n -> n % 2 == 0);

		// evenNumbers.forEach(System.out::println); // output was generated as
		// 2,4,6,8,10 in a vertical way

		List<Integer> evenEle = IntStream.range(1, 11).filter(n -> n % 2 == 0).boxed().collect(Collectors.toList());

		System.out.println("Even Elements ::: " + evenEle); // output was generated in the List format as [2,4,6,8,10]

		List<Integer> collect12 = listValues.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		System.out.println("By using the noraml streams ::: " + collect12); // Output : [2, 4]

// To find the odd numbers using the range

		IntStream oddNumbers = IntStream.range(0, 11).filter(n -> n % 2 != 0);

		// oddNumbers.forEach(System.out::println); // output was generated as 1,3,5,7,9
		// in a vertical way

		List<Integer> oddNumList = IntStream.range(1, 11).filter(n -> n % 2 != 0).boxed().collect(Collectors.toList());

		System.out.println("To find the even Numbers using IntStream ::: " + oddNumList); // output was generated in the
																							// List format as
																							// [1,3,5,7,9]

		List<Integer> oddNum = listVal.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());

		System.out.println("To find the Odd Numbers ::: " + oddNum); // Output : [3, 1, 5]

// to sort the even, odd numbers in integer list and output will be the same list

		List<Integer> intList = Arrays.asList(5, 6, 4, 6, 4, 6, 5, 7, 8, 6, 8, 7, 6, 45);

		List<Integer> evenOddSameList = intList.stream().sorted((a, b) -> {
			if (a % 2 == 0 && b % 2 != 0) {
				return -1;
			} else if (a % 2 != 0 && b % 2 == 0) {
				return 1;
			} else {
				return Integer.compare(a, b);
			}

		}).distinct().collect(Collectors.toList());

		System.out.println("To find the Even and Odd Values in the same List ::: " + evenOddSameList); // Output : [4, 6, 8, 5, 7,45]

// If we have the list of Integer values and multiply each values and skip the each value when we are multiplying with other values

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

		List<Integer> numList = numbers.stream()
				.map(n -> numbers.stream().filter(m -> m != n).mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b))
				.collect(Collectors.toList());

		System.out.println("Number List ::: " + numList); // Output : [24, 12, 8, 6]

// Sort HashMap By using Keys in Java 8

		HashMap<String, Integer> map = new HashMap<>();

		map.put("Xiangh", 91);
		map.put("Klusener", 82);
		map.put("Narayan", 95);
		map.put("Arunkumar", 86);
		map.put("Jyous", 87);
		map.put("Lisa", 89);

		LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getKey))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

		System.out.println("Sorting the HashMap by using keys ::: " + sortedMap); // Output : {Arunkumar=86, Jyous=87,
																					// Klusener=82, Lisa=89, Narayan=95,
																					// Xiangh=91}

// In a given array, write a program in readonly mode or unmodify 

		int[] numbe = { 1, 2, 3, 4, 5 };

		// we can use the following 3 approaches :

		// 1. Arrays.stream():

		Arrays.stream(numbe).forEach(System.out::println); // Output : 1 2 3 4 5

		// 2. Collections.unmodifiableList():

		List<Integer> unmodifiableList = Collections
				.unmodifiableList(Arrays.asList(Arrays.stream(numbe).boxed().toArray(Integer[]::new)));

		System.out.println("unmodifiableList ::: " + unmodifiableList); // Output : [1, 2, 3, 4, 5]

		// 3. java 8 List.of() :

		// List<Integer> javaImmutable =
		// List.of(Arrays.stream(numbe).boxed().toArray(Integer[]::new));

// Count the frequency of Integer values

		List<Integer> asList2 = Arrays.asList(1, 3, 4, 1, 6, 2, 2, 8, 4, 3, 1);

		Map<Integer, Long> collect8 = asList2.stream()
				.collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

		System.out.println("Count the frequency of Integer values ::: " + collect8); // Output : {1=3, 2=2, 3=2, 4=2, 6=1, 8=1}

		Map<Integer, Long> mapFunction = asList2.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("Count the frequency of Integer values ::: " + mapFunction); // Output : {1=3, 2=2, 3=2, 4=2, 6=1, 8=1}

// By using stream print the 1 to 100 number by using java 8 intstream()

		IntStream.rangeClosed(1, 10) // Generate numbers from 1 to 100
				.forEach(System.out::println); // Print each number

// In a two-dimensional array, find the sum of all non-zero elements 	

		int[][] numberss = { { 0, 0, 0, 0, 5 }, { 0, 1, 1, 1, 0 }, { 2, 0, 0, 0, 0 } };

		int summ = Arrays.stream(numberss).flatMapToInt(Arrays::stream).filter(n -> n != 0).sum();

		System.out.println("Calculate the sum of all non-zero elements in the 2D arrays : " + summ); // Output : 10

		List<Integer> asList5 = Arrays.asList(2, 4, 7, 1, 9, 5);

//	     Integer secondSmallestElement = ((Collectors) asList5.stream().sorted()).toList().get(1);  
//	     
//	     System.out.println("Find the second smallest element in the list ::: "+secondSmallestElement); // Output : 2

// To find the consecutive zeros in the list	     

		List<Integer> numLists = Arrays.asList(1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0);
		int count = 0;
		for (int i = 0; i < numLists.size(); i++) {
			if (numLists.get(i) == 0) {
				count++;
			} else
				count = 0;
		}
		System.out.println("To Find the consecutive zeros(end of the zeros) in the list ::: " + count); // 4

		int totalzerosCount = 0;
		for (int i = 0; i < numLists.size(); i++) {
			if (numLists.get(i) == 0) {
				totalzerosCount++;
			}
		}
		System.out.println("Find the Total Zero Count in the List:" + totalzerosCount); // 9
		
// Find max occurance of element from array using streams
		
		int[] ar = {3,5,1,8,2,7,3,3,8,8,8};
		
		Map<Integer, Long>maxFrequency = Arrays.stream(ar).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		Integer maxOccurance = maxFrequency.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
		
		System.out.println("Max occurance of element : " + maxOccurance); // 8
		
// To find odd numbers and double them using lambda 
		
		List<Integer> collect1 = asList.stream().filter(n -> n%2!=0).map(n -> n*2).collect(Collectors.toList());
				
		System.out.println("odd numbers and double it : " + collect1);  // [14, 2, 18, 10]
		
// Write Program to square each number in a list in java
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);

		// Method 1: Using a traditional for loop
	    List<Integer> squaredNumbersLoop = new ArrayList<>();
			for (int number :numbers1) {
			    squaredNumbersLoop.add(number * number);
			    }
			System.out.println("Squared numbers (using for loop): " + squaredNumbersLoop); // [1, 4, 9, 16, 25]

	    // Method 2: Using Java Streams (more concise for modern Java)
			List<Integer> squaredNumbersStream = numbers1.stream()
														.map(number -> number * number)
														.collect(Collectors.toList());
			System.out.println("Squared numbers (using Java Streams): " + squaredNumbersStream); // [1, 4, 9, 16, 25]
			
// In a given 2 arrays, concat and remove the duplicates using Java (int and Integer type)
			
			int[] array1 = {1, 2, 3, 4, 5};
			int[] array2 = {3, 5, 6, 7, 8};
			
			int[] array = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).distinct().sorted().toArray();
			
			System.out.println("Array elements : "+ Arrays.toString(array)); // [1, 2, 3, 4, 5, 6, 7, 8]
			
			
			Integer[] arr1 = {1, 2, 3, 4, 5};
			Integer[] arr2 = {3, 5, 6, 7, 8};
			
			List<Integer>arrElements = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).distinct().sorted().collect(Collectors.toList());
			
			System.out.println("Array elements : "+ arrElements); // [1, 2, 3, 4, 5, 6, 7, 8]			

	}
}
