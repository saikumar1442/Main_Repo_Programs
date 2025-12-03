package JavaProgramsEx;

public class StringComparisionEx {

	public static void main(String[] args) {
		

		        String s1 = "Java";  
		        String s2 = "Java";  
		        
		        String s3 = new String("Java");  
		        String s4 = new String("Java");
		        
		  
		        System.out.println(s1 == s2);       // Output: true  
		        System.out.println(s1 == s3);       // Output: false  
		  
		        System.out.println(s1.equals(s2));  // Output: true  
		        System.out.println(s1.equals(s3));  // Output: true 
		        
		        
		        System.out.println(s3 == s4);       // output: false
		        System.out.println(s3.equals(s4));  // output: true
		        
		        
		        
		  
		        
/*		        
1. The distinction between the .equals() method and the == operator lies in 
   their nature: one is a method while the other is an operator.
2. We generally use the == operator for reference comparison, whereas 
   the .equals() method is for content comparison.
*/
		        
		

	}

}
