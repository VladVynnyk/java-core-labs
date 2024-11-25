package lab9;
import java.util.Scanner;

public class ExpressionCalculator {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        // Введення значень a і b для арифметичних операцій
        double a = getInput(scanner, "Enter the value of a: ");
        double b = getInput(scanner, "Enter the value of b: ");
        
        
        // Виконання арифметичних операцій з обробкою винятків
        System.out.println("Operations with exceptions: ");
        testOperation("Addition", () -> Methods.add(a, b));
        testOperation("Subtraction", () -> Methods.subtract(a, b));
        testOperation("Multiplication", () -> Methods.multiply(a, b));
        testOperation("Division", () -> Methods.divide(a, b));

        // Обчислення виразу a * sqrt(b) з обробкою винятків
        System.out.println("Calculating expression... ");
        calculateExpression(a, b);

        scanner.close();
        System.out.println("Program finished.");
        
    }
    
    // Метод для обчислення виразу a * sqrt(b) з обробкою винятків
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
    
    // Метод для введення чисел з обробкою помилок формату
    private static double getInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    // Метод для тестування операцій з виведенням результату або винятку
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

    // Функціональний інтерфейс для операцій
    @FunctionalInterface
    interface Operation {
        double execute() throws IllegalArgumentException, ArithmeticException, IllegalAccessException, MyException;
    }
}

