package ua.pvl;

public class Parser {

	public static void parse(String[] args) {

		String str = args[0];

		recursion(str);
	}

	private static String recursion(String str) {

        Fraction fraction1 = new Fraction(); // first fraction
        Fraction fraction2 = new Fraction(); // second fraction

        // TODO create method to avoid duplication of code
        int firstElement = getElement(str, 0);
		fraction1.setNumerator(firstElement);

		int operandPosition = findOperand(str);
		String operand = getOperand(operandPosition, str);

		if (operand.equals("|")) {
            int secondElement = getElement(str, operandPosition + 1);
            fraction1.setDenominator(secondElement);
            str = str.replace(firstElement + operand + secondElement, "");
        } else {
		    fraction1.setDenominator(1);
            str = str.replace(firstElement + operand, "");
        }

        int firstElement2 = getElement(str, 0);
		fraction2.setNumerator(firstElement);

		int operandPosition2 = findOperand(str);
		String operand2 = getOperand(operandPosition, str);

		if (operand2.equals("|")) {
            int secondElement2 = getElement(str, operandPosition2 + 1);
            fraction2.setDenominator(secondElement2);
            str = str.replace(firstElement2 + operand2 + secondElement2, "");
        } else {
		    fraction2.setDenominator(1);
            str = str.replace(firstElement2 + operand2, "");
        }


		if (findOperand(str) == -1) {
			//System.out.println("Result is: " + result);
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
		String op = "";
		Character s = str.charAt(operandPosition);
		if (s.equals("+")) {
			op = "+";
		} else if (s.equals("-")) {
		    op = "-";
		} else if (s.equals("*")) {
		    op = "*";
        } else if (s.equals("/")) {
		    op = "/";
        } else if (s.equals("|")) {
		    op = "|";
        }
		return op;
	}

	private static int getElement(String str, int startPosition){
		for (int i = 0; i <= str.length(); i++) {
			Character s = str.charAt(i);
			String st = s.toString();
			if (!st.equals("+") || !st.equals("-") || !st.equals("*") || !st.equals("/") || !st.equals("|")) {
				Character s2 = str.charAt(i+1);
					if (!s2.equals("+") || !s2.equals("-") || !s2.equals("*") || !s2.equals("/") || !s2.equals("|")) {
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
