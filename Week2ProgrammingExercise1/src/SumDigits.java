
/**
 * Program: SumDigits
 * File: SumDigits.java
 * Summary: Takes a five digit positive integer and sums the individual digits.
 * Author: James Ray
 * Date: October 22, 2017
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class SumDigits {

    //Scanner variable
    private static Scanner input;
    //Allow only so many error before closing application
    private static int maxErrors = 5;
    //Current error count
    private static int errorCount = 0;

    /**
     * Start of the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create Scanner using system input
        input = new Scanner(System.in);
        askForFiveDigitInteger();
    }

    //Prompt in console for 5 digits. Validate and perform math or send error message.
    private static void askForFiveDigitInteger() {
        //Print question to system out
        System.out.print("Please enter a 5 digit positive integer: ");

        //Fill digits integer with input from console.
        try {
            int digits = input.nextInt();
            if (validateDigits(digits)) {
                performMath(digits);
            } else {
                error();
            }
        } catch (InputMismatchException e) {
            input.next();
            error();
        }
    }

    //Perform the math required to seperate values and output the sum.
    private static void performMath(int digits) {
        int sum = 0;
        int firstNumber = digits / 10000;
        int secondNumber = (digits % 10000) / 1000;
        int thirdNumber = (digits % 1000) / 100;
        int fourthNumber = (digits % 100) / 10;
        int fifthNumber = (digits % 10);
        sum = firstNumber + secondNumber + thirdNumber + fourthNumber + fifthNumber;
        System.out.println("The sum of the digits (" + firstNumber + ", " + secondNumber + ", " + thirdNumber + ", " + fourthNumber + ", " + fifthNumber + ") is: " + sum);
        System.exit(0);
    }

    //Count and output error. If max errors is reached close application to avoid looping.
    private static void error() {
        errorCount++;
        System.err.println("The value submitted is not a valid 5 digit positive integer.");
        if (errorCount < maxErrors) {
            askForFiveDigitInteger();
        } else {
            System.err.println("Too many errors have occured. The program is now closing.");
            System.exit(0);
        }
    }

    //validate that the digits are as expected.
    private static boolean validateDigits(int digits) {
        if (Integer.signum(digits) > 0 && (int) (Math.log10(digits) + 1) == 5) {
            return true;
        }
        return false;
    }

}
