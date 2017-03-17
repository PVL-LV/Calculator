package ua.pvl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parser {

	public static void parse(String[] args) {

		String[] ar = args;
		String str = "";

		for (String s : args) {
			str += str + s;
		}

		recursion(str);
	}

	private static String recursion(String str) {
		int firstElement = getElement(str, 0);
		int operandPosition = findOperand(str);
		int secondElement = getElement(str, operandPosition + 1);

		String operand = getOperand(operandPosition, str);
		int result = getResult(firstElement, secondElement, operand);
		String res = Integer.toString(result);
		str = str.replace(firstElement + operand + secondElement, res);

		if (findOperand(str) == -1) {
			System.out.println("Result is: " + result);
			System.exit(0);
		}

		return recursion(str);
	}


	private static int getResult(int firstElement, int secondElement, String operand) {
		int sum;
		if (operand.equals("+")) {
			sum = firstElement + secondElement;
		} else {
			sum = firstElement - secondElement;
		}
		return sum;
	}


	private static String getOperand(int operandPosition, String str) {
		String op;
		Character s = str.charAt(operandPosition);
		if (s.equals("+")) {
			op = "+";
		} else {
			op = "-";
		}
		return op;
	}

	private static int getElement(String str, int startPosition){
		for (int i = 0; i <= str.length(); i++) {
			Character s = str.charAt(i);
			String st = s.toString();
			if (!st.equals("+") || !st.equals("-")) {
				Character s2 = str.charAt(i+1);
					if (!s2.equals("+") || !s2.equals("-")) {
						String st2 = s + s2.toString();
						String res = st2;
						return Integer.parseInt(res);
					}
			} else {
				return Integer.parseInt(st);
			}
		}
		return -1; // not sure
	}

	public static int findOperand(String str) {

		for (int i = 0; i <= str.length(); i++) {
			Character s = str.charAt(i);
			String st = s.toString();
			if (st.equals("+") || st.equals("-")){
				return i;
			}
		}
		return -1;
	}

}
