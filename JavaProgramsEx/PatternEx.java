package Practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PatternEx {

	public static void main(String[] args) {
		
		
		// Below code is to write the pattern
	/*
		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= 5; j++) {

				System.out.println(i);
			}

			System.out.println("*");
		}   */

		List<String> asList = Arrays.asList("Java", "Python", "Net", "Hadoop");
		
		 List<String> collect = asList.stream().sorted().collect(Collectors.toList());
		
		System.out.println("SORTED ORDER : "+collect);
		
		
		
		String[] str = {"Boss", "Charminar", "Hyd","Ruby", "City"};
		
		Arrays.sort(str);
		
//		for(String temp : str) {
//			System.out.println("using the foreach method to print the values :"+temp);
//			
//		}
		
		
		for(int i=0; i<str.length;i++) {
			System.out.println("String values : "+str[i]);
			
		}
		
		
		
		int x =10;  //  1010
		int y =6;   //  0110
		
		System.out.println(x&y);  // 2  (0010)   : & is a Logical Bitwise operator so a and b values convert into the binary numbers.
		
		System.out.println(x|y);  // 14 (1110)
		
		System.out.println(x<y?x:y);
		
	int a = 12;       //   1 1 0 0
	int b = a<<3;     // 1 1 0 0 0   (12*9)
	
	System.out.println("B value : "+b);
		
		
		String string = "KingKohli";
		
		System.out.println(string.substring(3, 7));  // substring(1,5) Endindex of the substring starts from 1 and not from 0.
		
		
		
		String s = "Java";
		
		System.out.println(s.toUpperCase());
		
		System.out.println(s.concat("world"));
		
		System.out.println(s.replace("J", "L"));
		
		
		
		
	}

}
