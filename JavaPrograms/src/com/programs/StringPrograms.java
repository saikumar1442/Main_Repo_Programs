package com.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringPrograms {

	public static void main(java.lang.String[] args) {
	
		
// Convert List of Strings into String array
		
		List<String> stringList = Arrays.asList("Apple", "Banana", "Cherry");

		// Convert List<String> to String[]
				
		String[] stringArray = stringList.stream().toArray(String[]::new);

		System.out.println("String Array: " + Arrays.toString(stringArray));

		
		
// 
		String str = "JavaGuides";

		Map<Character,Long> collect11 = str.chars().mapToObj(c -> (char) c)
												   .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

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


			Map<Character,Long> collect10 = str.chars().mapToObj(c -> (char) c)
														.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

			System.out.println("Find the frequency of each chatr in a string ::: "+collect10); //Output : {a=2, s=1, d=1, e=1, u=1, v=1, G=1, i=1, J=1}


			Map<Character,Long> useMapFunction = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			System.out.println("Find the frequency of each chatr in a string ::: "+useMapFunction); //Output : {a=2, s=1, d=1, e=1, u=1, v=1, G=1, i=1, J=1}


			//System.out.println("Find the frequency of each char in a string ::: "+collect9);

// To find the word frequency count in the List of String

			List<String> asList3 = Arrays.asList("the", "pav", "good", "the", "sar", "good", "the");

			Map<String,Long> collect9 = asList3.stream().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			System.out.println("Word Frequency Count ::: "+collect9);  //Output : {the=3, pav=1, sar=1, good=2}

		
// Find the Duplicate words in the given string array: use distict() and hashset

		List<String> asList4 = Arrays.asList("Hello", "pavan", "Hello", "Namak", "Shankar", "pavan", "Hello");  


		// Map<String,Long> collect14 = asList4.stream().distinct().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		//System.out.println("Find the duplicate words in the given string :: "+collect14);
		
		//Set<String> collect15 = asList4.stream().distinct().collect(Collectors.toSet());
		
		//System.out.println("Duplicate Elements : "+collect15);
			
			Set<Object> hashSet = new HashSet<>();
			
		// Set<String> collect16 = asList4.stream().filter(n -> hashSet.add(n)).collect(Collectors.toSet());
			
		// System.out.println("Remove Duplicate Elements in the filter :: "+collect16);
			
		// Set<String> collect17 = asList4.stream().filter(n -> !hashSet.add(n)).collect(Collectors.toSet());
			
		// System.out.println("To print the duplciate words in the string array :: "+collect17);
			
			Map<String,Long> collect18 = asList4.stream().filter(n -> !hashSet.add(n)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			
			System.out.println("Printing the duplicate words in the list with counting :: "+collect18); // Output :{Hello=2, pavan=1}
			
// To sort, upper case each word and remove the duplicate words in the list			
			
			Set<String> collect141 = asList4.stream().sorted().map(a -> a.toUpperCase()).filter(n -> !hashSet.add(n)).collect(Collectors.toSet());
			
			System.out.println("TO Upper Case :: "+collect141); //Output : TO Upper Case :: [PAVAN, HELLO]
		
		
		
		String s = "barfoothebarfoofoobarman";
		String[] str1 = {"barfoo","foobar"};

		List<Integer> list11 = new ArrayList<>();

		for(String word : str1) {
			int value = s.indexOf(word);
			if(value != -1) {
				list11.add(value);
				s.indexOf(word, value+1);
			}
		}

		System.out.println("Output "+list11);  // Output [0, 9]
		
		
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
		
//		for(String sr : split) {
//			System.out.println("SPLIT OF ARRAYS ::: "+sr);
//		}
		
		
//		List<String> words = Arrays.asList("Today it may rain or it may not rain");
		
		Map<String,Long> frequency = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("Each Word Count in the given String ::: "+frequency); //Output : {rain=2, not=1, Today=1, or=1, may=2, it=2}

		
// Using streams to count character frequency and remove the whitespace
		
		 String input = "hello world";
		
        Map<Character, Long>charFrequency = input.chars()
												.mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
												.filter(c -> !Character.isWhitespace(c)) // Filter out whitespace characters
												.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Print the character frequencies
        					charFrequency.forEach((character, count) ->
        								System.out.println("Character: '" + character + "', Frequency: " + count));
//        					Character: 'r', Frequency: 1
//        					Character: 'd', Frequency: 1
//        					Character: 'e', Frequency: 1
//        					Character: 'w', Frequency: 1
//        					Character: 'h', Frequency: 1
//        					Character: 'l', Frequency: 3
//        					Character: 'o', Frequency: 2
        				
// To remove duplicate character in a string

	        String originalString = "programming";

	        String collect = originalString.chars() // Get an IntStream of character codes
									.mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
									.distinct() // Remove duplicate characters
									.map(String::valueOf) // Convert Character to String
									.collect(Collectors.joining()); // Join the characters back into a string

	        System.out.println("To remove duplicate character in a string ' "+ collect );  // To remove duplicate character in a string ' progamin
	        
// To remove duplicate words from Strings
			
			String str11 = "Java is a programming language. Java is also an island. Java is popular.";
			
			String[] split1 = str11.split("\\s+");
			
			String collect1 = Arrays.stream(split1).distinct().collect(Collectors.joining(" "));
			
			System.out.println("remove the duplicate words : " +collect1); // remove the duplicate words : Java is a programming language. also an island. popular.
        					
// Sorted by keys in ascending and descending order using hashmap
	        
	        Map<Integer, String>unsortedMap = new HashMap<>();
	        unsortedMap.put(5, "Apple");
	        unsortedMap.put(2, "Banana");
	        unsortedMap.put(8, "Cherry");
	        unsortedMap.put(1, "Date");

	        System.out.println("Unsorted Map: " + unsortedMap); // Unsorted Map: {1=Date, 2=Banana, 5=Apple, 8=Cherry}

	                // Sort the HashMap by keys using Streams
	              Map<Integer, String>sortedMap = unsortedMap.entrySet().stream()
	            		  						.sorted(Comparator.comparing(Map.Entry::getKey))
	            		  						//.sorted(Map.Entry.comparingByKey())
	            		  						.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
	                                (oldValue, newValue) ->oldValue, // Merge function for duplicate keys (not relevant for sorting distinct keys)
	                                	LinkedHashMap::new // Use LinkedHashMap to preserve insertion order
	            		  				));

	        System.out.println("Sorted Map by Key: " + sortedMap); // Sorted Map by Key: {1=Date, 2=Banana, 5=Apple, 8=Cherry}

	                // To sort in descending order of keys
	                Map<Integer, String>sortedMapDescending = unsortedMap.entrySet().stream()
														        .sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
														        .collect(Collectors.toMap(
														        Map.Entry::getKey,
														        Map.Entry::getValue,
	                                (oldValue, newValue) ->oldValue,LinkedHashMap::new));

	        System.out.println("Sorted Map by Key (Descending): " + sortedMapDescending); // Sorted Map by Key (Descending): {8=Cherry, 5=Apple, 2=Banana, 1=Date}

// Reverse a String
	        
	        String str111 = "Pavan";
			String reverse = "";
			
			// using a for loop
			
			for (int i = str111.length()-1; i>=0 ;i--) {
				
				reverse = reverse + str111.charAt(i);
			}
			System.out.println("Reverse a String : "+reverse); // Reverse a String : navaP
			
			// using StringBuilder.reverse()
			
			String string = new StringBuilder(str111).reverse().toString();

// max occurance of elements from string array
			
			String[] arr = {"apple", "banana", "apple", "orange", "banana", "apple"};
			
			List<String> list = Arrays.asList(arr);
			
			Map<String, Long>wordFrequency = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			
			String orElse = wordFrequency.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
			
			System.out.println("max occurance of elements from string array : " + orElse);	 //max occurance of elements from string array : apple
			
// Write program to filter Palindromes in a string
			
			String s1 = "level";
			
			// Convert string to lowercase for 
	        // case-insensitive comparison
	        s1 = s1.toLowerCase();

	        // Reverse the string
	        String rev = "";
	        for (int i = s1.length() - 1; i>= 0; i--) {
	            rev = rev + s1.charAt(i);
	        }

	        // Compare the original string with 
	        // the reversed string
	boolean res = s1.equals(rev);

	     // Print the result with enhanced output
	        if (res) {
	System.out.println('"' + s1 + '"' + " is a palindrome."); // "level" is a palindrome.
	        } else {
	System.out.println('"' + s1 + '"' + " is not a palindrome.");
	        }
	        
// Write Program to filter strings containing a specific character for e.g ‘E’ using java   

	        List<String> words = new ArrayList<>();
						words.add("Apple");
						words.add("Banana");
						words.add("Cherry");
						words.add("Elderberry");
						words.add("Grape");

	        char charToFilter = 'E'; // The character to filter by

	        // Using Java Streams for a concise and functional approach
	         List<String>filteredWords = words.stream()
	        		 			.filter(st ->st.contains(String.valueOf(charToFilter))) // Check if string contains the character
	        		 			.collect(Collectors.toList()); // Collect the filtered strings into a new list

	System.out.println("Original words: " + words);  // Original words: [Apple, Banana, Cherry, Elderberry, Grape]
	System.out.println("Strings containing '" + charToFilter + "': " + filteredWords);  // Strings containing 'E': [Elderberry]
	
//  Write Program to convert list of strings to their lengths

    // Create a list of strings
       List<String> stringList1 = new ArrayList<>();
				 stringList1.add("apple");
				 stringList1.add("banana");
				 stringList1.add("cherry");
				 stringList1.add(""); // An empty string
				 stringList1.add("grapefruit");

       List<Integer> lengths = new ArrayList<>();

       for (String stri : stringList1) {
    	   		lengths.add(stri.length());
       }

       	System.out.println("Original String List: " +  stringList1);  // Original String List: [apple, banana, cherry, , grapefruit]
       		System.out.println("Lengths List: " + lengths);	  // Lengths List: [5, 6, 6, 0, 10]     
	
// From the list of string find the count of the occurrence using stream api

          List<String> strings = Arrays.asList("a", "b", "c", "a", "a", "d", "e", "e");
 
          //Map<String, Long> occurrences = strings.stream()
          //        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
 
          //occurrences.forEach((key, value) ->System.out.println(key + "," + value));

          Map<String, Long>occurrenceCounts = strings.stream()
        		  					.collect(Collectors.groupingBy(stri ->stri, Collectors.counting()));

          	System.out.println(occurrenceCounts);  // {a=3, b=1, c=1, d=1, e=2}

 // String Immutable class example
          	
        // public final class ImmutaClass{
    		
//    		 private final String name;
//    		 private final int age;
//    		
//    		 public ImmutaClass(String name, int age){
//    		 this.name = name;
//    		 this.age = age;
//    		 }
//    		
//    		 public String getName(){
//    		 return name;
//    		 }
//    		
//    		 public int getAge(){
//    		 return age;
//    		 }
//    		
//    		 }
          	
// group all characters and count them         
          	
          String str2 = "aaaabbbccc";
  	        // This counts total occurrences, not consecutive ones, and order isn't strictly guaranteed
  	        Map<Character, Long> counts = str2.chars()
  	            .mapToObj(c -> (char) c)
  	            .collect(Collectors.groupingBy(
  	                Function.identity(),
  	                LinkedHashMap::new, // Attempts to maintain insertion order of first occurrence
  	                Collectors.counting()
  	            ));

  	        StringBuilder result = new StringBuilder();
  	        for (Map.Entry<Character, Long> entry : counts.entrySet()) {
  	            result.append(entry.getKey()).append(entry.getValue());
  	        }

  	        System.out.println("Input: " + str2);  // Input: aaaabbbccc
  	        System.out.println("Stream Output (Total Counts): " + result.toString()); // Stream Output (Total Counts): a4b3c3
  	    }
  

	
	}


