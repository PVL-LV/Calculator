package ua.pvl;

public class Parser {

	Calculation calc = null;
	Fraction res;

	public void parse(String[] args) {

		String str = args[0];

		recursion(str);
	}

	private String recursion(String str) {

        Fraction fraction1 = new Fraction(); // first fraction
        Fraction fraction2 = new Fraction(); // second fraction

        // TODO create method to avoid duplication of code
		int operandPosition;
		String operation = "";

		if (res == null ) {
			int firstElement = getElement(str, 0);
			fraction1.setNumerator(firstElement);

			operandPosition = findOperand(str, 0);
			String operand = getOperand(operandPosition, str);

			operation = "";
			if (operand.equals("|")) {
				operation = getOperand(findOperand(str, operandPosition + 1), str);
			}


			if (operand.equals("|")) {
				int secondElement = getElement(str, operandPosition + 1);
				fraction1.setDenominator(secondElement);
				str = str.replace(firstElement + operand + secondElement + operation, "");
			} else {
				fraction1.setDenominator(1);
				str = str.replace(firstElement + operand, "");
				operation = operand;
			}
		} else {
			operandPosition = findOperand(str, 0);
			String operand = getOperand(operandPosition, str);
			if (operand.equals("|")) {
				operation = getOperand(findOperand(str, operandPosition + 1), str);
				fraction1.setNumerator(res.getNumerator());
				fraction1.setDenominator(res.getDenominator());
			}
		}



        int firstElement2 = getElement(str, 0);
		fraction2.setNumerator(firstElement2);

		int operandPosition2 = findOperand(str, 0);
		String operand2 = getOperand(operandPosition, str);

		if (operand2.equals("|")) {
            int secondElement2 = getElement(str, operandPosition2 + 1);
            fraction2.setDenominator(secondElement2);
            str = str.replace(firstElement2 + operand2 + secondElement2, "");
        } else {
		    fraction2.setDenominator(1);
            str = str.replace(firstElement2 + operand2, "");
        }

		Calculation calc = null;
		Fraction res;
        if (operation == "+") {
			calc = new Addition(fraction1, fraction2);
		} else if (operation == "-") {
			calc = new Subtraction(fraction1, fraction2);
		} else if (operation == "*") {
			calc = new Multiplication(fraction1, fraction2);
		} else if (operation == "/") {
			calc = new Division(fraction1, fraction2);
		}

		calc.calculate();
		res = calc.getAnswer();





		if (findOperand(str, 0) == -1) {
			//System.out.println("Result is: " + result);
			System.exit(0);
		}


		return recursion(str);
	}



    // rewrite this method
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
		if (s == '+') {
			op = "+";
		} else if (s == '-') {
		    op = "-";
		} else if (s == '*') {
		    op = "*";
        } else if (s == '/') {
		    op = "/";
        } else if (s == '|') {
		    op = "|";
        }
		return op;
	}

	private static int getElement(String str, int startPosition){
		for (int i = startPosition; i <= str.length(); i++) {

			Character s = str.charAt(i);

			if (s != '+' && s != '-' && s != '*' && s != '/' && s != '|') {
				Character s2 = str.charAt(i+1);
					if (s2 != '+' && s2 != '-' && s2 != '*' && s2 != '/' && s2 != '|') {
						String st2 = s + s2.toString();
						String res = st2;
						return Integer.parseInt(res);
					} else if (Character.isDigit(s)){
						return Integer.parseInt(s.toString());
					} else {
						i++;
					}
			} else if (Character.isDigit(s)) {
				return Integer.parseInt(s.toString());
			}else {
				i++;
			}
		}
		return -1; // not sure
	}

	public static int findOperand(String str, int startPosition) {

		for (int i = startPosition; i <= str.length(); i++) {
			Character s = str.charAt(i);
			//String st = s.toString();
			if (s == '+' || s == '-' || s == '*' || s == '/' || s == '|'){
				return i;
			}
		}
		return -1;
	}
}
