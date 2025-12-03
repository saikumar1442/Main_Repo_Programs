package JavaProgramsEx;

public class FactorialEx {

	public static void main(String[] args) {
		int i, fact = 1;
		
		int n=5; // It is the number to calculate the factorial
		
		for(i=1; i<=n; i++) {
			fact = fact * i;
			
		}

		System.out.println("Factorial of "+n+" is : "+fact);
	}

}
