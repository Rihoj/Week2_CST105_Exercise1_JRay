
/**
 * Program: ConvertTemperature
 * File: ConvertTemperature.java
 * Summary: Asks for a Fahrenheit temperature and converts to Celsius.
 * Then asks for a Celsius temperature and converts to Fahrenheit.
 * Author: James Ray
 * Date: October 22, 2017
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConvertTemperature {

    //Scanner variable
    private static Scanner input;
    //Allow only so many error before closing application
    private static int maxErrors = 5;
    //Current error count
    private static int errorCount = 0;

    private static final String F = "Fahrenheit";
    private static final String C = "Celsius";

    private static String currentType = F;

    /**
     * Start of the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create Scanner using system input
        input = new Scanner(System.in);
        askForTemperature();
        currentType = C;
        askForTemperature();
        System.exit(0);
    }

    //Prompt in console for a temperature specfied by type.
    private static void askForTemperature() {
        //Print question to system out
        System.out.print("Please enter a " + currentType + " temperature: ");

        //Fill digits integer with input from console.
        try {
            Double temperature = input.nextDouble();
            performMath(temperature);
        } catch (InputMismatchException e) {
            input.next();
            error();
        }
    }

    //Perform the math required to seperate values and output the sum.
    private static void performMath(double temperature) {
        if (currentType.equals(F)) {
            convertFahrenheitToCelsius(temperature);
        } else {
            convertCelsiusToFahrenheit(temperature);
        }
    }

    private static void convertFahrenheitToCelsius(double temperature) {
        double celsius = (temperature - 32D) * (5D / 9D);
        System.out.println(temperature + "F is equivalent to " + celsius + "C");
    }

    private static void convertCelsiusToFahrenheit(double temperature) {
        double fahrenheit = (temperature * (9D / 5D)) + 32D;
        System.out.println(temperature + "C is equivalent to " + fahrenheit + "F");
    }

    //Count and output error. If max errors is reached close application to avoid looping.
    private static void error() {
        errorCount++;
        System.err.println("The value submitted is not a valid temperature.");
        if (errorCount < maxErrors) {
            askForTemperature();
        } else {
            System.err.println("Too many errors have occured. The program is now closing.");
            System.exit(0);
        }
    }

}
