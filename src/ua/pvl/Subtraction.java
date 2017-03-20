package ua.pvl;

public class Subtraction extends Calculation {

    public Subtraction(Fraction fraction1, Fraction fraction2) {
        super(fraction1, fraction2, "-");
    }

    // perform the calculation
    public void calculate() {
        answer.setNumerator((fraction1.getNumerator() * fraction2.getDenominator()) - (fraction2.getNumerator() * fraction1.getDenominator()));
        answer.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());
    }
}