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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrograms {

	public static void main(String[] args) {
		
		
		List<Integer> list = Arrays.asList(2,7,4,2,2,6,1,9,4);

		
		// To find the max number

		// Integer maxNumber = list.stream().max(Integer::compare).get();

		//Integer maxNumber = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		
		// Integer maxNumber = Collections.max(list);
		
		//int maxNumber = list.stream().mapToInt( n -> n).max().orElseThrow(NoSuchElementException::new);
		
		//Integer integer2 = list.stream().sorted((a,b) -> b-a).findFirst().get();
		
		//System.out.println("Maximum Number ::: " + integer2);
		
		Optional<Integer> max = list.stream().max(Integer::compareTo);
		
		max.ifPresent( val -> System.out.println("The Maximum Number is : "+val));  // Output : 9
		
		
		
		
		
		
		
		
		// TO find the minimum number
		
		// Integer integer = list.stream().min(Integer::compare).get();
		
		// Integer integer2 = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
		
		//  min = Collections.min(list);
		
		//int orElseThrow = list.stream().mapToInt(n -> n).min().orElseThrow(NoSuchElementException::new);
		
		//Integer min = list.stream().sorted(Comparator.comparingInt(Integer::valueOf)).findFirst().get();
		
		Integer min = list.stream().sorted().findFirst().get();
		
		System.out.println("Minimum Number ::: " + min);   // Output : 1
		
		
		
		
		
		
		
		// To sort the order in Ascending
		
		//List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
		
		List<Integer> collect = list.stream().sorted().toList();
		
		System.out.println("Sorting order ::: " + collect); // [1, 2, 2, 2, 4, 4, 6, 7, 9]
		
		
		
		
		
		// To Unsort the order in descending
		
		//List<Integer> collect2 = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		List<Integer> collect2 = list.stream().sorted((a,b) -> b-a).toList();
		
		System.out.println("UnSorting order ::: " + collect2);  //  [9, 7, 6, 4, 4, 2, 2, 2, 1]
		
		
		
		// By using the distinct()

		List<Integer> removeDuplicateValues = list.stream().sorted().distinct().collect(Collectors.toList());

		System.out.println("To Sort and Remove Duplicate values ::: " + removeDuplicateValues); // [1, 2, 4, 6, 7, 9]
		
		
		
		
		// TO remove the duplicate using 2 ways 1. distinct() and 2. set
		
		List<Integer> collect3 = list.stream().distinct().collect(Collectors.toList());
		
		System.out.println("To Remove the duplicates ::: "+collect3);  // [2, 7, 4, 6, 1, 9]
		
		
		
		
		
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
		
		
		
		
	// To find the 2nd highest number in the list of Integer
		
		// So here if we want to find the 3rd or 4th highest number, in the skip() we need to pass the values like n-1
		
		Integer integer = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();

		System.out.println("Second highest number ::: " + integer);  // 7
		
		Optional<Integer> secondHighest = list.stream()
                .sorted((a, b) -> b - a) // Sort in descending order
                .skip(1) // Skip the first (highest) element
                .findFirst(); // Get the second element

		secondHighest.ifPresent(second -> System.out.println("The second highest number is: " + second));  // 7
		
		
		
		
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
	 		
	 		System.out.println("To find the even Numbers using IntStream ::: "+oddNumList);    // output was generated in the List format as [1,3,5,7,9] 
	 		
	 		
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
			
			
	
			
			// If we have the list of Integer values and multiply each values and skip the each value when we are multiplying with other values
			
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
			
			
	
			
			// Emp is the POJO Class
			
			
			   List<Emp> emp = Arrays.asList(new Emp(1,"Ashok", "CSC", 98.0),
						new Emp(2, "Pavan", "EEE", 70.0),
						new Emp(3, "Hari", "MECH", 60.0),
						new Emp(4, "Varun", "CIVIL", 99.0),
						new Emp(5, "Pandu", "ECE", 85.0));


Map<String,Double> HighestPercen = emp.stream()
								.collect(Collectors.groupingBy(Emp::getDept, Collectors.mapping(Emp::getsalary, Collectors.maxBy(Comparator.naturalOrder()))))
								.entrySet()
								.stream()
								.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()));



System.out.println("Highest Percentage based on dept ::: "+HighestPercen); //Output : {CIVIL=99.0, CSC=98.0, EEE=70.0, ECE=85.0, MECH=60.0}



Map<String,Emp> highest = emp.stream()
.collect(Collectors.groupingBy(Emp::getDept, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Emp::getsalary)), em -> em.get())));


highest.entrySet().forEach(System.out::println);

// Output : CIVIL=Emp [id=4, name=Varun, dept=CIVIL, salary=99.0]
//CSC=Emp [id=1, name=Ashok, dept=CSC, salary=98.0]
//EEE=Emp [id=2, name=Pavan, dept=EEE, salary=70.0]
//ECE=Emp [id=5, name=Pandu, dept=ECE, salary=85.0]
//MECH=Emp [id=3, name=Hari, dept=MECH, salary=60.0]

System.out.println("To find the highest Salary based on department in employee class ::: "+highest);

// Output : {CIVIL=Emp [id=4, name=Varun, dept=CIVIL, salary=99.0], 
//				CSC=Emp [id=1, name=Ashok, dept=CSC, salary=98.0], 
//						EEE=Emp [id=2, name=Pavan, dept=EEE, salary=70.0], 
//						ECE=Emp [id=5, name=Pandu, dept=ECE, salary=85.0], 
//						MECH=Emp [id=3, name=Hari, dept=MECH, salary=60.0]}







Emp maxPercentage = emp.stream().max(Comparator.comparingDouble(Emp::getsalary)).get();

System.out.println("To find the Highest percentage ::: "+maxPercentage); //Output : Emp [id=4, name=Varun, dept=CIVIL, salary=99.0]

Emp minPercentage = emp.stream().min(Comparator.comparingDouble(Emp::getsalary)).get();

System.out.println("To find the Lowest percentage ::: "+minPercentage);	 //Output : Emp [id=3, name=Hari, dept=MECH, salary=60.0]

Emp findFirst = emp.stream().sorted(Comparator.comparingDouble(Emp::getsalary).reversed()).skip(2).findFirst().get();

System.out.println("To find the 2nd highest percentage ::: "+findFirst);  //Output : Emp [id=5, name=Pandu, dept=ECE, salary=85.0]
	    


List<Integer> collect6 = emp.stream().filter(a -> a.getsalary()>70).map(Emp::getId).collect(Collectors.toList());

System.out.println("To find the Employee Percentage/salary > 70 and based on the ID ::: "+collect6);  //Output : [1, 4, 5]



 List<Emp> collect13 = emp.stream().filter(a -> a.getsalary()==70).collect(Collectors.toList());
 
 collect13.forEach(ee -> System.out.println(ee.getName()));  //Output : Pavan
 
 System.out.println("TO find the salary is equal to 70 in a employee class using streams :: "+collect13);  //Output : [Emp [id=2, name=Pavan, dept=EEE, salary=70.0]]




List<Emp> collect7 = emp.stream().sorted(Comparator.comparing(Emp::getName).thenComparing(Emp::getDept).thenComparingDouble(Emp::getsalary)).collect(Collectors.toList());

System.out.println("Sorted employes based on name, age and salary :::: "+collect7);  //Output : [Emp [id=1, name=Ashok, dept=CSC, salary=98.0], Emp [id=3, name=Hari, dept=MECH, salary=60.0], Emp [id=5, name=Pandu, dept=ECE, salary=85.0], Emp [id=2, name=Pavan, dept=EEE, salary=70.0], Emp [id=4, name=Varun, dept=CIVIL, salary=99.0]]

//collect7.forEach(System.out::println);




List<Integer> asList2 = Arrays.asList(1,3,4,1,6,2,2,8,4,3,1);

Map<Integer,Long> collect8 = asList2.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

System.out.println("Count the frequency of Integer values ::: "+collect8);  //Output : {1=3, 2=2, 3=2, 4=2, 6=1, 8=1}


Map<Integer,Long> mapFunction = asList2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

System.out.println("Count the frequency of Integer values ::: "+mapFunction);  //Output : {1=3, 2=2, 3=2, 4=2, 6=1, 8=1}





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


str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting())).forEach((chara, fre) -> System.out.println(chara + ":"+fre));

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

System.out.println("Find the frequency of each chatr in a string ::: "+collect10); //Output : {a=2, s=1, d=1, e=1, u=1, v=1, G=1, i=1, J=1}


Map<Character,Long> useMapFunction = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

System.out.println("Find the frequency of each chatr in a string ::: "+useMapFunction); //Output : {a=2, s=1, d=1, e=1, u=1, v=1, G=1, i=1, J=1}


//System.out.println("Find the frequency of each chatr in a string ::: "+collect9);




List<String> asList3 = Arrays.asList("the", "pav", "good", "the", "sar", "good", "the");

Map<String,Long> collect9 = asList3.stream().sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

System.out.println("Word Frequency Count ::: "+collect9);  //Output : {the=3, pav=1, sar=1, good=2}


// Find the Duplicate words in the given string array

List<String> asList4 = Arrays.asList("Hello", "pavan", "Hello", "Namak", "Shankar", "pavan", "Hello");  


// Map<String,Long> collect14 = asList4.stream().distinct().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//System.out.println("Find the duplicate words in the given string :: "+collect14);
//
//Set<String> collect15 = asList4.stream().distinct().collect(Collectors.toSet());
//
//	System.out.println("Duplicate Elements : "+collect15);
	
	Set<Object> hashSet = new HashSet<>();
	
//	Set<String> collect16 = asList4.stream().filter(n -> hashSet.add(n)).collect(Collectors.toSet());
//	
//	System.out.println("Remove Duplicate Elements in the filter :: "+collect16);
//	
//	Set<String> collect17 = asList4.stream().filter(n -> !hashSet.add(n)).collect(Collectors.toSet());
//	
//	System.out.println("To print the duplciate words in the string array :: "+collect17);
	
	Map<String,Long> collect18 = asList4.stream().filter(n -> !hashSet.add(n)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	
	
	System.out.println("Printing the duplicate words in the list with counting :: "+collect18); // Output :{Hello=2, pavan=1}
	
	Set<String> collect141 = asList4.stream().sorted().map(a -> a.toUpperCase()).filter(n -> !hashSet.add(n)).collect(Collectors.toSet());
	
	System.out.println("TO Upper Case :: "+collect141); //Output : TO Upper Case :: [PAVAN, HELLO]







// By using stream print the 1 to 100 number by using java 8 intstream()

IntStream.rangeClosed(1, 10) // Generate numbers from 1 to 100
.forEach(System.out::println); // Print each number



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

System.out.println("Output "+list1);  // Output [0, 9]





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
	
//	for(String sr : split) {
//		System.out.println("SPLIT OF ARRAYS ::: "+sr);
//	}
	
//	List<String> words = Arrays.asList("Today it may rain or it may not rain");
	
	Map<String,Long> frequency = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	
	System.out.println("Each Word Count in the given String ::: "+frequency); //Output : {rain=2, not=1, Today=1, or=1, may=2, it=2}


	
	
	  int[][] numberss = {{0,0,0,0,5},{0,1,1,1,0}, {2,0,0,0,0}};
	     
	     int summ = Arrays.stream(numberss).flatMapToInt(Arrays::stream).filter(n -> n != 0).sum();
	     
	     System.out.println("Calculate the sum of all non-zero elements in the 2D arrays : "+summ); // Output : 10
	     


	 List<Integer> asList5 = Arrays.asList(2,4,7,1,9,5);
	     
	     Integer secondSmallestElement = asList5.stream().sorted().toList().get(1);  
	     
	     System.out.println("Find the second smallest element in the list ::: "+secondSmallestElement); // Output : 2
	
	     
	     
	     
			List<Integer> numLists = Arrays.asList(1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0);
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
	
	


	}

}
