/*
 * Question → 1)  

 	Write a program of Balancing Brackets, use a suitable data structure to print 
 	whether the string entered is a Balanced Brackets or Unbalanced String
 
 */

package com.greatlearning.dsalab3.q1matbra;

import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets {

	public static boolean checkBrackets(String input) {
		Stack<Integer> stack = new Stack<>();
		String openingBrackets = "([{<";
		String closingBrackets = ")]}>";
		String brackets = openingBrackets + closingBrackets;

		for (char ch : input.toCharArray()) {
			if (!brackets.contains(ch + "")) {
				continue;
			}
			int index = -1;
			if ((index = openingBrackets.indexOf(ch)) != -1) {
				stack.push(index);
				continue;

			}
			index = stack.pop();
			if (ch != closingBrackets.charAt(index)) {
				return false;

			}

		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("Enter a String with brackets for testing");
			String input = sc.next();
			boolean check = checkBrackets(input);
			if (check) {
				System.out.println("Entered String has balanced brackets.");
			} else {
				System.out.println("Entered String do not contain balanced brackets.");
			}
		}
	}
}