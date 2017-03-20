package ua.pvl;

public abstract class Calculation {

    protected final Fraction fraction1;
    protected final Fraction fraction2;
    protected final String operation;
    protected Fraction answer;

    public Calculation(Fraction fraction1, Fraction fraction2, String operation) {
        this.fraction1 = fraction1;
        this.fraction2 = fraction2;
        this.operation = operation;
        this.answer = new Fraction();
        calculate();
    }

    public abstract void calculate();
}