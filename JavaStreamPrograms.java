package com.ex;

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
import java.util.Stack;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamPrograms {

	public static void main(String[] args) {
		
		
		List<Integer> list = Arrays.asList(2,7,4,2,2,6,1,9,4);

		
		// To find the max number in a given List

		// Integer maxNumber = list.stream().max(Integer::compare).get();

		//Integer maxNumber = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		
		// Integer maxNumber = Collections.max(list);
		
		//int maxNumber = list.stream().mapToInt( n -> n).max().orElseThrow(NoSuchElementException::new);
		
		//Integer integer2 = list.stream().sorted((a,b) -> b-a).findFirst().get();
		
		//System.out.println("Maximum Number ::: " + integer2);
		
		Optional<Integer> max = list.stream().max(Integer::compareTo);
		
		max.ifPresent( val -> System.out.println("The Maximum Number is : "+val));  // Output : 9
		
		

		// TO find the minimum number in a given List
		
		// Integer integer = list.stream().min(Integer::compare).get();
		
		// Integer integer2 = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
		
		//  min = Collections.min(list);
		
		//int orElseThrow = list.stream().mapToInt(n -> n).min().orElseThrow(NoSuchElementException::new);
		
		//Integer min = list.stream().sorted(Comparator.comparingInt(Integer::valueOf)).findFirst().get();
		
		Integer min = list.stream().sorted().findFirst().get();
		
		System.out.println("Minimum Number ::: " + min);   // Output : 1
		
		
		
		
		// To find the 2nd highest number in the list of Integer
		
		// So here if we want to find the 3rd or 4th highest number, in the skip() we need to pass the values like n-1
				
		Integer integer = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

		System.out.println("Second highest number ::: " + integer);  // 7
		
		Optional<Integer> secondHighest = list.stream()
                .sorted((a, b) -> b - a) // Sort in descending order
                .skip(1) // Skip the first (highest) element
                .findFirst(); // Get the second element

		secondHighest.ifPresent(second -> System.out.println("The second highest number is: " + second));  // 7
		
		
		
		
		// To find the 2nd lowest number in the list of Integer 
		
		List<Integer> asList5 = Arrays.asList(2,4,7,1,9,5);
	     
	     Integer secondSmallestElement = asList5.stream().sorted().toList().get(1);  
	     
	     System.out.println("Find the second smallest element in the list ::: "+secondSmallestElement); // Output : 2
		
		
		
		
		
		// To sort the order in Ascending
		
		//List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
		
		List<Integer> collect = list.stream().sorted().toList();
		
		System.out.println("Sorting order in the given list::: " + collect); // [1, 2, 2, 2, 4, 4, 6, 7, 9]
		
		int arr[] = {2,5,7,9,10,23,18,82};

		List<Integer> arraySorted = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
		
		System.out.println("Sorting the elements in the given array : "+arraySorted);
		
		
		
		
		// To Unsort the order in descending
		
		//List<Integer> collect2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		List<Integer> collect2 = list.stream().sorted((a,b) -> b-a).toList();
		
		System.out.println("UnSorting order ::: " + collect2);  //  [9, 7, 6, 4, 4, 2, 2, 2, 1]
		
		
		
		// TO remove the duplicate using 2 ways 1. distinct() and 2. set

		List<Integer> collect3 = list.stream().distinct().collect(Collectors.toList());
		
		System.out.println("To Remove the duplicates ::: "+collect3);  // [2, 7, 4, 6, 1, 9]
		
		
		 Set<Integer> removeDuplicateElements = list.stream().collect(Collectors.toSet());
		 
		 System.out.println("To remove duplicates using toSet method :: "+removeDuplicateElements);
		 
		 
		 
		// Sort the elements and remove the duplicates 
	 
		List<Integer> removeDuplicateValues = list.stream().sorted().distinct().collect(Collectors.toList());

		System.out.println("To Sort and Remove Duplicate values ::: " + removeDuplicateValues); // [1, 2, 4, 6, 7, 9]
		
		 
		
		// Below code is print the duplicate elements in the given list of integer values
		
		HashSet<Integer> set = new HashSet<>();
		
		List<Integer> collect4 = list.stream().sorted().filter(n -> !set.add(n)).collect(Collectors.toList());
		
		System.out.println("To print the Duplicates elements :::: "+collect4); // [2, 2, 4]
		
        List<Integer> duplicates = list.stream()
                                          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                          .entrySet().stream()
                                          .filter(entry -> entry.getValue() > 1)
                                          .map(Map.Entry::getKey)
                                          .collect(Collectors.toList());

        System.out.println("Duplicate elements: " + duplicates);  // [2, 4]
		 
        
        
        
		// To find the sum of Each element in the list of integer
		
		List<Integer> asList = Arrays.asList(2,4,1,3,5);
		
		Integer collect5 = asList.stream().collect(Collectors.summingInt(Integer::intValue));
		
		Integer reduce = asList.stream().reduce(0, (a,b) -> a + b);
		
		int sum = asList.stream().mapToInt(Integer::intValue).sum();
		
		Integer reduce2 = asList.stream().reduce(0, Integer::sum);
		
		
		System.out.println("Sum of Each Elements::: " + sum);  // Output : 15
		
		
		
		
		
	    List<Integer> listVal = Arrays.asList(3,2,4,1,5,8);
		
		// To multiply the each element in the list and return the sum
		
		Integer multiplyEachElement = listVal.stream().reduce(1, (a,b) -> a * b);
		
		System.out.println("To multiply each element in the list and return the sum ::: "+multiplyEachElement); // Output : 960
		
		
		List<Integer> multipliedNumbers = listVal.stream()
								.map(n -> n * 2) // Multiply each element by 2
								.collect(Collectors.toList());

		System.out.println("Multiplied elements: " + multipliedNumbers); // Output : [6, 4, 8, 2, 10, 16]
		
		
		
		
		
		// TO find the Even Numbers in the List of Integer 
		
		List<Integer> listValues = Arrays.asList(1,2,3,4,5);
		
        IntStream evenNumbers = IntStream.range(1, 11).filter(n -> n%2 == 0);
		
		//evenNumbers.forEach(System.out::println);  // output was generated as 2,4,6,8,10 in a vertical way
		
	   
	    List<Integer> evenEle = IntStream.range(1, 11).filter(n -> n%2 == 0).boxed().collect(Collectors.toList());
	   
	    System.out.println("Even Elements ::: "+evenEle);    // output was generated in the List format as [2,4,6,8,10] 
		
	    
        List<Integer> collect12 = listValues.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
	    
	    System.out.println("By using the noraml streams ::: "+ collect12);     // Output : [2, 4]
		
		
	    
	    
	    
	    
	    // To find the odd numbers using the range
		
	 		IntStream oddNumbers = IntStream.range(0, 11).filter(n -> n % 2 != 0);
	 		
	 		//oddNumbers.forEach(System.out::println);   // output was generated as 1,3,5,7,9 in a vertical way
	 		
	 		
	 		List<Integer> oddNumList = IntStream.range(1, 11).filter(n -> n%2 != 0).boxed().collect(Collectors.toList());
	 		
	 		System.out.println("To find the Odd Numbers using IntStream ::: "+oddNumList);    // output was generated in the List format as [1,3,5,7,9] 
	 		
	 		
	 		List<Integer> oddNum = listVal.stream().filter(n -> n%2 != 0).collect(Collectors.toList());
	 		
	 		System.out.println("To find the Odd Numbers ::: "+oddNum); // Output : [3, 1, 5]
	 		
	 		
	 		
	 		
	 		// to sort the even, odd numbers in integer list and output will be the same list
			
			
			List<Integer> intList = Arrays.asList(5,6,4,6,4,6,5,7,8,6,8,7,6,45);
			
			
			List<Integer> evenOddSameList = intList.stream().sorted((a,b)-> {if (a % 2 == 0 && b % 2 != 0) {
															return -1;
														} else if (a % 2 != 0 && b % 2 == 0) {
															return 1;
														} else {
															return Integer.compare(a, b);
														}
														
														}).distinct().collect(Collectors.toList());
			
			
			System.out.println("To find the Even and Odd Values in the same List ::: "+evenOddSameList); //Output : [4, 6, 8, 5, 7, 45]
			
			
	
			
			// If we have the list of Integer values and multiply each values and skip the same value when we are multiplying with other values
			
			List<Integer> numbers = Arrays.asList(1,2,3,4);
			
			List<Integer> numList = numbers.stream()
					.map(n -> numbers.stream().filter( m -> m != n).mapToInt(Integer::intValue).reduce(1, (a,b)-> a * b))
					.collect(Collectors.toList());
			
			System.out.println("Number List ::: "+numList);   // Output :  [24, 12, 8, 6]
			
			
			
			// Sort HashMap By using Keys in Java 8
			
			HashMap<String, Integer> map = new HashMap<>();
			
			map.put("Xiangh", 91);
			map.put("Klusener", 82);
			map.put("Narayan", 95);
			map.put("Arunkumar", 86);
			map.put("Jyous", 87);
			map.put("Lisa", 89);
			
			LinkedHashMap<String,Integer> sortedMap = map.entrySet().stream()
											  .sorted(Comparator.comparing(Map.Entry::getKey))
											  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, LinkedHashMap::new));
			
			System.out.println("Sorting the HashMap by using keys ::: "+sortedMap);  //Output : {Arunkumar=86, Jyous=87, Klusener=82, Lisa=89, Narayan=95, Xiangh=91}
	    
	    
			
			
			
			// In a given array, write a program in readonly mode or unmodify 
			
			int [] numbe = {1,2,3,4,5};
			
		  //  we can use the following 3 approaches :
			
		  //   1. Arrays.stream():
			 
			Arrays.stream(numbe).forEach(System.out::println); //Output : 1 2 3 4 5 
			
		  // 2. Collections.unmodifiableList(): 	
			
			List<Integer> unmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.stream(numbe).boxed().toArray(Integer[]::new)));
			
			System.out.println("unmodifiableList ::: "+unmodifiableList); //Output : [1, 2, 3, 4, 5]
			
		  // 3. java 8 List.of() :
			
			List<Integer> javaImmutable = List.of(Arrays.stream(numbe).boxed().toArray(Integer[]::new));
			
			
			
			
		//  Find Count the frequency of Integer values	
			
			List<Integer> asList2 = Arrays.asList(1,3,4,1,6,2,2,8,4,3,1);

			Map<Integer,Long> collect8 = asList2.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

			System.out.println("Count the frequency of Integer values ::: "+collect8);  //Output : {1=3, 2=2, 3=2, 4=2, 6=1, 8=1}


			Map<Integer,Long> mapFunction = asList2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			System.out.println("Count the frequency of Integer values ::: "+mapFunction);  //Output : {1=3, 2=2, 3=2, 4=2, 6=1, 8=1}

			
			// Find the frequency of each char in a string
			
			String str = "JavaGuides";

			Map<Character,Long> collect11 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

			collect11.forEach((con,funn) -> System.out.println(con+"::"+funn)); 

			// Output :
			// a::2
			//s::1
			//d::1
			//e::1
			//u::1
			//v::1
			//G::1
			//i::1
			//J::1

			str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting())).forEach((chara, fre) -> System.out.println(chara + ":"+fre));

			//Output :

			//a:2
			//s:1
			//d:1
			//e:1
			//u:1
			//v:1
			//G:1
			//i:1
			//J:1

			Map<Character,Long> collect10 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

			System.out.println("Find the frequency of each char in a string ::: "+collect10); //Output : {a=2, s=1, d=1, e=1, u=1, v=1, G=1, i=1, J=1}


			Map<Character,Long> useMapFunction = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			System.out.println("Find the frequency of each char in a string ::: "+useMapFunction); //Output : {a=2, s=1, d=1, e=1, u=1, v=1, G=1, i=1, J=1}


			//System.out.println("Find the frequency of each character in a string ::: "+collect9);
			
			
			// Find the Word Frequency Count in a given list
			
			List<String> asList3 = Arrays.asList("the", "pav", "good", "the", "sar", "good", "the");

			Map<String,Long> collect9 = asList3.stream().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			System.out.println("Word Frequency Count in a given list ::: "+collect9);  //Output : {the=3, pav=1, sar=1, good=2}
			
			
			List<String> wordFrequency = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");
			
			Map<String,Long> collect14 = wordFrequency.stream().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			
			collect14.forEach((word, counting) -> System.out.println(word+" : "+counting));
			
			
			//Count occurrences of words  - i/p : "Today it may rain or it may not rain"

			String sentense = "Today it may rain or it may not rain";
			
			String[] split = sentense.trim().split("\\s+");
			
			System.out.println("SPLIT OF ARRAYS ::: "+Arrays.toString(split)); // Output : [Today, it, may, rain, or, it, may, not, rain]
			
			// #1
			Arrays.asList(split).stream().forEach(strt -> System.out.println(strt));

			// #2
			Stream.of(split).forEach(System.out::println);

			// #3
			Arrays.stream(split).forEach(System.out::println);
			
//			for(String sr : split) {
//				System.out.println("SPLIT OF ARRAYS ::: "+sr);
//			}
			
//			List<String> words = Arrays.asList("Today it may rain or it may not rain");
			
			Map<String,Long> frequency = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			
			System.out.println("Each Word Count in the given String ::: "+frequency); //Output : {rain=2, not=1, Today=1, or=1, may=2, it=2}

			
			

			// Find the Duplicate word count in the given string List

			List<String> asList4 = Arrays.asList("Hello", "pavan", "Hello", "Namak", "Shankar", "pavan", "Hello");  

			// Map<String,Long> collect14 = asList4.stream().distinct().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			//
			//System.out.println("Find the duplicate words in the given string :: "+collect14);
			//
			//Set<String> collect15 = asList4.stream().distinct().collect(Collectors.toSet());
			//
//				System.out.println("Duplicate Elements : "+collect15);
				
				Set<Object> hashSet = new HashSet<>();
				
//				Set<String> collect16 = asList4.stream().filter(n -> hashSet.add(n)).collect(Collectors.toSet());
			//	
//				System.out.println("Remove Duplicate Elements in the filter :: "+collect16);
			//	
//				Set<String> collect17 = asList4.stream().filter(n -> !hashSet.add(n)).collect(Collectors.toSet());
			//	
//				System.out.println("To print the duplciate words in the string array :: "+collect17);
				
				Map<String,Long> collect18 = asList4.stream().filter(n -> !hashSet.add(n)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				
				
				System.out.println("Printing the duplicate words in the list with counting :: "+collect18); // Output :{Hello=2, pavan=1}
				
				
				
				
				Set<String> collect141 = asList4.stream().sorted().map(a -> a.toUpperCase()).filter(n -> !hashSet.add(n)).collect(Collectors.toSet());
				
				System.out.println("To upper Case :: "+collect141); //Output : TO Upper Case :: [PAVAN, HELLO]
				
			
				
				
				
				// Remove the duplicate Characters 
				
				String input1 = "programming";  
				
				String collect211 = input1.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
				
				System.out.println("Remove the duplicate Characters :: "+collect211); // Output : progamin
				
				
				
				// Remove the duplicate characters in given String
				
				String input = "geeks for geeks ";
				
				String collect1 = input.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
				
				System.out.println("To remove the duplicates in given String :: "+collect1);
				
				String collect21 = Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
				
				System.out.println("To remove the duplicates in given String :: "+collect21);
				
				
				
				
				// print the duplicate char count in a given String
				
				LinkedHashMap<Character, Long> charCount =  input1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
				
				List<Entry<Character, Long>> collect1111 = charCount.entrySet().stream().filter(n -> n.getValue() > 1).collect(Collectors.toList());
				
				Map<Character,Long> collectUsingMap = charCount.entrySet().stream().filter(n -> n.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
				 
				System.out.println("Print the duplicate Character count in a given String Using List :: "+collect1111); // Output : [r=2, g=2, m=2]
			
				System.out.println("Print the duplicate Character count in a given String Using Map :: "+collectUsingMap); // Output : {r=2, g=2, m=2}
				
				
				
			
				
				
				
				// Find the fist non repeated character in a given String

				String stri = "helloThere";

				LinkedHashMap<Character, Long> mapp = stri.chars().mapToObj(c -> (char) c)
						.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

				System.out.println("Map : " + map);

				Character nonRepeatedChar = mapp.entrySet().stream().filter(n -> n.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);

				System.out.println("First Non repeated char :: " + nonRepeatedChar);
				
			
				
				
				// Reverse a String without using in built methods
				
				String str11 = "simran";
				
				String reverseString = "";
				
				System.out.println("TESTING ::: "+str11.length()); // length starts from the 1 and index starts from 0
				
				System.out.println("TEST ::: "+(str11.length()-1));  // 5
				
				for(int i = str11.length()-1; i >= 0; --i) {
					reverseString = reverseString + str11.charAt(i);
				}
				
				System.out.println("Reverse String without using in built methods :: "+reverseString);
				
				
				
				
				// Reverse Each Word in a given String
				
				String str111 = "Hello World";

				String reverseWord = Arrays.stream(str111.split(" ")).map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));

				System.out.println("Reverse Each Word in a String :: " + reverseWord); // Output : olleHdlroW

				
				
				// Reverse a String with using in built methods
				
				StringBuilder stringBuilder = new StringBuilder(str11);
				
				String s1 = stringBuilder.reverse().toString();
				
				System.out.println("Reverse a String with using in built methods :: "+s1);
				
				
				
				// SWAP the 2 variables without using 3rd variable
				
				int x = 5; 
				int y = 7;
				
				 x = x + y; // 12
				 y = x - y; // 5
				 x = x - y; // 7
				 
				 System.out.println("x = " + x +" ; "+ "y = "+ y);
				 
				 
				// SWAP the 2 variables with using 3rd variable
				 
				 int a = 10;
				 int b = 20;
				 
				 int temp = a;
				 a = b;
				 b = temp;
				 
				 System.out.println("SWAP the numbers :: "+a+" ; "+b);
				
				
				 
			// Capitalize the First character in each word in given String
				 
				  String input11 = "welcome to geeksforgeeks";
			      
			        // split the input string into an array of words, stream the array
			        // apply the capitalization transformation and join the words back
			        
			         String capitalizeEachWord = Arrays.stream(input11.split("\\s"))
								                       .map(word -> Character.toTitleCase(word.charAt(0)) + word.substring(1))
								                       .collect(Collectors.joining(" "));
			         
			         System.out.println("Capitalize the each word :: "+capitalizeEachWord);
					
			      // below code is to write Capitalize the First Char in each word using foreach loops
			         
			         String[] splitting = input1.split(" ");
			         
			         for(String arrr : splitting) {
			     
			        	 String replace = arrr.replace(arrr.charAt(0), arrr.toUpperCase().charAt(0));
			       
			        	 System.out.println("Replacing the first char in a given String ::: "+replace);
			         }
			         
			         // below code is to write Capitalize the First Char in each word using Java 8 Streams 
			         
			         Arrays.stream(input1.split(" ")).map(m -> m.replace(m.charAt(0), m.toUpperCase().charAt(0))).forEach(System.out::println);
			         
			         
			         
			         
			         String strin = "I Love My India Army";
					
					System.out.println("remove the white spaces ::: "+strin.replaceAll("\\s", ""));  // Output : ILoveMyIndiaArmy
					
					// Character Space count in a given String
					
					int counting = 0;
					
					for(int i = 0; i < strin.length(); i ++) {
						if(strin.charAt(i) == ' ') {
							counting ++;
						}
					}
					System.out.println("Character Space count in a given String :: "+counting);
					
					
					
					
					List<Integer> list1111 = Arrays.asList(3,4,6,8,2);
					
					List<Integer> divisable = list1111.stream().filter(p -> p % 4 == 0).collect(Collectors.toList());
					
					System.out.println("Find the numbers which are divisable by 4 in the given List ::: " + divisable);
					
					
					
					 int[][] numberss = {{0,0,0,0,5},{0,1,1,1,0}, {2,0,0,0,0}};
				     
				     int summ = Arrays.stream(numberss).flatMapToInt(Arrays::stream).filter(n -> n != 0).sum();
				     
				     System.out.println("Calculate the sum of all non-zero elements in the 2D arrays : "+summ); // Output : 10
				     
				     
				     
				    // Finf the consecutive zeros in the given List (Calculate the Continuous zeros) 
				     
				     List<Integer> numLists = Arrays.asList(1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0); // If all the 0's are in the end of list then the below code should work otherwise it will not work 
						int count = 0;
						for (int i = 0; i < numLists.size(); i++) {
							if (numLists.get(i) == 0) {
								count++;
							} else
								count = 0;
						}
						System.out.println("To Find the consecutive zeros in the list ::: "+count);
				
					
						int totalzerosCount = 0;

						for(int i = 0; i<numLists.size();i++) {
							if(numLists.get(i) == 0) {
								totalzerosCount ++;
							}
							
						}
						System.out.println("Find the Total Zero Count in the List:"+totalzerosCount);

						
						List<Integer> numListss = Arrays.asList(1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0); // If all the 0's are in the end of list then the below code should work otherwise it will not work 
						int currentCount = 0;
						int maxCount = 0;
						for (int i = 0; i < numListss.size(); i++) {
							if (numListss.get(i) == 1) {
								
								currentCount++;
								
								if(currentCount > maxCount) {
									
									maxCount = currentCount;
								}
							} 
							else
								currentCount = 0;
						}
						System.out.println("To Find the consecutive zeros in the list ::: "+maxCount);
						
						
						
						
						// By using stream print the 1 to 100 number by using java 8 intstream()

						IntStream.rangeClosed(1, 10) // Generate numbers from 1 to 100 
						.forEach(System.out::println); // Print each number


						String[] words = {"ab","cd","ef"};
						String res = String.join("", words);
						System.out.println("Concatination of String output :::: "+res);


						// Find the index the barfoo and foobar in the given input String
						
						String s = "barfoothebarfoofoobarman";
						String[] str1 = {"barfoo","foobar"};

						List<Integer> list1 = new ArrayList<>();

						for(String word : str1) {
							int value = s.indexOf(word);
							if(value != -1) {
								list1.add(value);
								s.indexOf(word, value+1);
							}
						}

						System.out.println("Find the index the barfoo and foobar "+list1);  // Output [0, 9]


						

						String myStr = "Hello planet earth, you are a great planet.";

						// Find the index of the first occurrence of "planet"
						int index1 = myStr.indexOf("planet");
						System.out.println("Index of 'planet': " + index1); // Output: 6

						// Find the index of the first occurrence of 'e'
						int index2 = myStr.indexOf('e');
						System.out.println("Index of 'e': " + index2); // Output: 1

						// Find the index of 'e' starting from index 5
						int index3 = myStr.indexOf('e', 5);
						System.out.println("Index of 'e' from index 5: " + index3); // Output: 10
						
						
						
						
						// Below code is to check whether the two Array elements are equal or not
						
						int[] arr1 = { 1, 2, 3, 4, 5 };
						int[] arr2 = { 1, 3, 5, 4 };
						
//						int length1 = arr1.length;
//						int length2 = arr2.length;
					
						if(arr1.length==arr2.length)
							System.out.println("Array lengths are equal");
						else
							System.out.println("Array lengths are not equal");
						
						
						
						// Below code is to check whether the two arrays are contains same elements or not	
						// and it is calling the areEqual method		
								int[] arr11 = { 1, 2, 3, 4, 5 };
								int[] arr22 = { 1, 3, 5, 4, 2 };

								if (areEqual(arr11, arr22))   // areEqual() is calling to the outside of the main method
									System.out.println("Array contains the same elements");
								else
									System.out.println("Array does not contains the same elements");

							
						
							
							// The below code is to check whether the Given String paranthesis are balanced or not
							// and it is calling the isBalanced method
							
							String stri1 = "{()[]}";

							if (isBalanced(stri1))   // isBalanced() is calling to the outside of the main method
								System.out.println("The parentheses are balanced ");
							 else 
								System.out.println("The parentheses are not balanced ");
				 
	}
	
	
	// Below code is called by the areEqual method
	
	public static boolean areEqual(int[] arr1, int[] arr2) {

		int m1 = arr1.length;
		int m2 = arr2.length;

		if (m1 != m2)
			return false;

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		for (int i = 0; i < m1; i++)
			if (arr1[i] != arr2[i])
				return false;

		return true;

	}
	
	// Below code is called by the isBalaced method
	
	public static Boolean isBalanced(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			
			char ch = s.charAt(i);
		
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (!stack.empty() && (stack.peek() == '(' && ch == ')'
									   || stack.peek() == '{' && ch == '}' || stack.peek() == '[' && ch == ']')) {
					stack.pop();

				} else {
					return false;
				}

			}

		}

		return stack.empty();
	}
	

}
