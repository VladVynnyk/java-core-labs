import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Запитуємо у користувача введення числа
        System.out.print("Введіть десяткове число: ");
        int decimalNumber = scanner.nextInt();
        
        // Перетворення числа з десяткової у двійкову систему числення
        String binaryNumber = Integer.toBinaryString(decimalNumber);
        
        // Виводимо результат
        System.out.println("Двійковий еквівалент: " + binaryNumber);
        
        scanner.close();
    }
}
