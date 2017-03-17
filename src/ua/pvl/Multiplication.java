package ua.pvl;


public class Multiplication extends Calculation {

    // Constructor
    public Multiplication(Fraction fraction1, Fraction fraction2) {
        super(fraction1, fraction2, "Multiplication", '*');
    }

    // perform the calculation
    public void calculate() {
        answer.setNumerator(fraction1.getNumerator() * fraction2.getNumerator());
        answer.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());
    }

    // display the answer
    public void display() {
        super.displayAnswer();
    }

}