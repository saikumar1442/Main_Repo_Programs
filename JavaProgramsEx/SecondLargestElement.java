package BalancedParentheses;

public class SecondLargestElement {

	public static void main(String[] args) {
		
		int [] arr = {2,3,6,1,3,8,9,28,21,18,27};
		
		int largest = arr[0];
		int second = Integer.MIN_VALUE;
		
		
		for(int i =1; i<arr.length; i ++) {
			
			if(arr[i]>largest) {
				second = largest; //2
				largest = arr[i]; //3
			}
			else if(arr[i]>second) {
				second = arr[i];
			}
		}
		
		System.out.println("Largest element :: "+largest);
		System.out.println("Second largest element :: "+second);

	}

}
