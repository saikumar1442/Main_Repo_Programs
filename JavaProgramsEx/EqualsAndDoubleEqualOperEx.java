package Practice;

public class EqualsAndDoubleEqualOperEx {

	public static void main(String[] args) {
		
		
		String str1 = "World" ;
		String str2 = "World" ;
		
		String str3 = new String("World");
		String str4 = new String("World");
		
		
		System.out.println(str1 == str2);     // true
		
		System.out.println(str3 == str4);     //  false
		
		System.out.println(str1.equals(str2));  // true
		
		System.out.println(str3.equals(str4));    // true
		
		System.out.println(str1.equals(str3));    // true
		
		System.out.println(str1 == str3);      // false
		

	}

}
