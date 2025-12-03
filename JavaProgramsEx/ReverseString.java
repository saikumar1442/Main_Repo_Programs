package Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReverseString {

	public static void main(String[] args) {
		

String input = "smawaissa";

String collect = input.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());

System.out.println("Remove the duplicate char ::: "+collect);
		
		
		
		
	}

}
