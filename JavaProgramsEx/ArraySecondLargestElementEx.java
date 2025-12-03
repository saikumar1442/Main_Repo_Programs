package JavaProgramsEx;

import java.util.Arrays;

public class ArraySecondLargestElementEx {

	public static void main(String[] args) {
		
		int arr[] = new int[] {10,43,27,98,75,59,191};
		
		Arrays.sort(arr);  //arranging the elements in ascending order
		
		for (int i = 0; i <= arr.length; i++) {

			if (i == arr.length - 2)

				System.out.println(arr[i]);
		}

	}

}
