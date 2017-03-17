package ua.pvl;

public abstract class Calculation {

    protected final Fraction fraction1;
    protected final Fraction fraction2;
    protected final String operation;
    protected final char operator;
    protected Fraction answer;

    public Calculation(Fraction fraction1, Fraction fraction2, String operation, char operator) {
        this.fraction1 = fraction1;
        this.fraction2 = fraction2;
        this.operation = operation;
        this.operator = operator;
        this.answer = new Fraction();
        calculate();
    }

    public abstract void calculate();

    public void displayAnswer() {
        System.out.print(operation + "  : ");
        fraction1.display();
        System.out.print(" " + operator + " ");
        fraction2.display();
        System.out.print(" = ");
        answer.display();
        System.out.println("");
        System.out.println("");
    }
}