package lab9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerInput {
    private Scanner scanner;

    // Конструктор для ініціалізації сканера
    public IntegerInput() {
        this.scanner = new Scanner(System.in);
    }

    // Метод для введення цілого числа з обробкою помилок
    public int getIntFromConsole() {
        while (true) {
            System.out.print("Enter an integer: ");
            try {
                return scanner.nextInt();  // Спроба зчитати ціле число
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Очищення некоректного введення з буфера
            }
        }
    }

    // Метод для закриття сканера
    public void close() {
        scanner.close();
    }

    public static void main(String[] args) {
        IntegerInput integerInput = new IntegerInput();

        // Виклик методу для введення цілого числа
        int number = integerInput.getIntFromConsole();
        System.out.println("You entered: " + number);

        // Закриття сканера
        integerInput.close();
    }
}

