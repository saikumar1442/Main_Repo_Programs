 package JavaProgramsEx;

import java.util.Arrays;

public class AnagramEx {

	public static void main(String[] args) {
		
		char[] str1 = {'g','r','a','m'};
		
		char[] str2 = {'g','r','a'};
		
		
		if(areAnagram(str1,str2)) 
			System.out.println("Two strings are equal to anagram ");
		else 
			System.out.println("Two strings are not equal to anagram ");
	
	}
	
	static boolean areAnagram(char[] str1, char[] str2) {
		
		int n1 = str1.length;
		int n2 = str2.length;
		
		if(n1 != n2)
			return false;
		
		Arrays.sort(str1);
		Arrays.sort(str2);
		
		for(int i=0; i<=n1; i++) {
			if(str1[i] != str2[i]) 
				return false;	
		}
		
		return true;
	}

}
