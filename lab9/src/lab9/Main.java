package lab9;
import java.util.Scanner;
import java.util.InputMismatchException;
import lab9.MyException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter some text: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                throw new Exception("Input cannot be empty.");
            }
            System.out.println("You entered: " + input);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Empty input check completed.");
        }

        try {
        	MyException(null);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }

        System.out.print("Enter an integer to calculate its factorial: ");
        try {
            int n = scanner.nextInt();
            System.out.println("Factorial of " + n + " is " + factorial(n));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.nextLine();
        }

        int number = getIntFromConsole(scanner);

        double a = getDoubleFromConsole(scanner, "Enter value for a: ");
        double b = getDoubleFromConsole(scanner, "Enter value for b: ");
        
        testOperation("Addition", () -> Methods.add(a, b));
        testOperation("Subtraction", () -> Methods.subtract(a, b));
        testOperation("Multiplication", () -> Methods.multiply(a, b));
        testOperation("Division", () -> Methods.divide(a, b));
        
        calculateExpression(a, b);
        
        scanner.close();
        System.out.println("Program finished.");
        
    }
    
    public static void MyException(String str) throws NullPointerException {
        if (str == null) {
            throw new NullPointerException("The parameter cannot be null.");
        }
        System.out.println("Parameter value: " + str);
    }
    
    private static void calculateExpression(double a, double b) {
        System.out.println("\nCalculation for expression a * sqrt(b):");
        try {
            if (b < 0) {
                throw new ArithmeticException("The value of b cannot be negative for square root calculation.");
            }
            double result = a * Math.sqrt(b);
            System.out.println("The result of a * sqrt(b) is: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Math error: " + e.getMessage());
        }
    }

    private static void checkNull(String str) throws NullPointerException {
        if (str == null) {
            throw new NullPointerException("Input parameter is null.");
        }
    }
    
    private static double getDoubleFromConsole(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static int getIntFromConsole(Scanner scanner) {
        while (true) {
            System.out.print("Enter an integer: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    private static void testOperation(String operationName, Operation operation) {
        try {
            double result = operation.execute();
            System.out.println(operationName + " result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(operationName + " error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(operationName + " error: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(operationName + " error: " + e.getMessage());
        } catch (MyException e) {
            System.out.println(operationName + " error: " + e.getMessage());
        }
    }

    @FunctionalInterface
    interface Operation {
        double execute() throws IllegalArgumentException, ArithmeticException, IllegalAccessException, MyException;
    }
}