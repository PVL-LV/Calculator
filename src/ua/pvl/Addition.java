package ua.pvl;

public class Addition extends Calculation {

    public Addition(Fraction fraction1, Fraction fraction2) {
        super(fraction1, fraction2, "Addition", '+');
    }

    public void calculate() {
        answer.setNumerator((fraction1.getNumerator() * fraction2.getDenominator())
                + (fraction2.getNumerator() * fraction1.getDenominator()));
        answer.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());
    }
}