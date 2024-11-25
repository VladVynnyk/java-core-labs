package lab1;
import java.util.Scanner;

//public class DecimalToBinary {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.print("Enter decimal number: ");
//        // Create validation of input
//        int decimalNumber = scanner.nextInt();
//        
//        // Create implementation of logic to convert decimal to binary
//        String binaryNumber = Integer.toBinaryString(decimalNumber);
//        
//        System.out.println("Binary number: " + binaryNumber);
//        
//        scanner.close();
//    }
//}


public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = 0;

        while (true) {
            System.out.print("Enter a positive decimal number: ");
            if (scanner.hasNextInt()) {
                decimalNumber = scanner.nextInt();
                if (decimalNumber >= 0) {
                    break;
                } else {
                    System.out.println("Please enter a non-negative number.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); 
            }
        }

        String binaryNumber = convertToBinary(decimalNumber);

        System.out.println("Binary number: " + binaryNumber);

        scanner.close();
    }

    public static String convertToBinary(int decimal) {
        if (decimal == 0) return "0";

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.insert(0, remainder);
            decimal = decimal / 2;
        }
        return binary.toString();
    }
}