package BalancedParentheses;

import java.util.Stack;

public class CheckBalancedParentheses {

	public static void main(String[] args) {

		String str = "{()[]}";

		if (isBalanced(str)) {

			System.out.println("The parentheses are balanced ");
		} else {
			System.out.println("The parentheses are not balanced ");

		}

	}

	public static Boolean isBalanced(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.push(s.charAt(i));
			} else {
				if (!stack.empty() && (stack.peek() == '(' && s.charAt(i) == ')'
						|| stack.peek() == '{' && s.charAt(i) == '}' || stack.peek() == '[' && s.charAt(i) == ']')) {
					stack.pop();

				} else {
					return false;
				}

			}

		}

		return stack.empty();
	}

}
