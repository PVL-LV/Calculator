package ua.pvl;

public class Division extends Calculation {

    // Constructor
    public Division(Fraction fraction1, Fraction fraction2) {
        super(fraction1, fraction2, "Division", '/');
    }

    // perform the calculation
    public void calculate() {
        answer.setNumerator(fraction1.getNumerator() * fraction2.getDenominator());
        answer.setDenominator(fraction1.getDenominator() * fraction2.getNumerator());
    }

    public void display() {
        // Check for the divide by zero error
        if (fraction2.getNumerator() == 0) {
            System.out.println("Division : Cannot divide by zero!");
            return;
        } else {
            // display the answer
            super.displayAnswer();
        }
    }

}