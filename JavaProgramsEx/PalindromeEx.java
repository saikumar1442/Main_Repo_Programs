package JavaProgramsEx;

import java.util.Scanner;

public class PalindromeEx {

	
	public static void main(String[] args) {
//		String original, reverse = "";
//		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the number");
//		original = scanner.nextLine();
		
		String original = "12323";   // either we can initialize the Number/String
		String reverse = "";
	
	int length = original.length();
	
//	char charAt = original.charAt(length);
//	
//	System.out.println(charAt);
	
	for (int i = (length - 1); i >= 0; --i) {
		reverse = reverse + original.charAt(i);
	}
		if (original.equals(reverse)) {
			System.out.println("Entered string/number is a palindrome.");
		}else {
			System.out.println("Entered string/number isn't a palindrome.");
		}
	}

}
