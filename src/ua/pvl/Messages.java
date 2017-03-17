package ua.pvl;

/*
 * This class is used to give meaningful messages to user
 * So whenever we want to change a message we don't want to check whole app but this class
 */

public class Messages {

    // This message is use to display the program header
    public static void displayHeader() {
        System.out.println("_________________________________________________________");
        System.out.println("         Fraction App");
        System.out.println("_________________________________________________________");
        newLine();
    }

    // This message is use to display the program footer
    public static void displayFooter() {
        newLine();
        System.out.println(" ----------- Thank you for using Fraction App -----------");
        System.out.println("_________________________________________________________");
        newLine();
    }

    // This message is use to tell user to input value for Numerator in a fraction
    public static void insertNumerator() {
        System.out.print("Numerator	: ");
    }

    // This message is use to tell user to input a value for denominator
    public static void inputDenominator() {
        System.out.print("Denominator	: ");
    }

    // This method is used to get line of space
    public static void newLine() {
        System.out.println("\n");
    }

    // This message is used when user input something miss match
    public static void inputError(Exception e) {
        newLine();
        System.out.println("Input Error: " + e.toString());
        System.out.println("Closing application ...");
        System.out.println("Fraction app is closed.");
        displayFooter();
    }

    // This message is used when user input 0 for Denominator in a fraction
    public static void DenominatorCannotBeZero() {
        System.out.println("Input Error: Denominator Cannot be zero");
        newLine();
    }
}
