package lab9;

class Methods {
    public static double add(double a, double b) throws IllegalArgumentException, ArithmeticException, IllegalAccessException, MyException {
        validate(a, b);
        return a + b;
    }

    public static double subtract(double a, double b) throws IllegalArgumentException, ArithmeticException, IllegalAccessException, MyException {
        validate(a, b);
        return a - b;
    }

    public static double multiply(double a, double b) throws IllegalArgumentException, ArithmeticException, IllegalAccessException, MyException {
        validate(a, b);
        return a * b;
    }

    public static double divide(double a, double b) throws IllegalArgumentException, ArithmeticException, IllegalAccessException, MyException {
        validate(a, b);
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    private static void validate(double a, double b) throws IllegalArgumentException, ArithmeticException, IllegalAccessException, MyException {
        if (a < 0 && b < 0) {
            throw new IllegalArgumentException("Both numbers are negative.");
        } else if ((a == 0 && b != 0) || (a != 0 && b == 0)) {
            throw new ArithmeticException("One of the numbers is zero while the other is non-zero.");
        } else if (a == 0 && b == 0) {
            throw new IllegalAccessException("Both numbers are zero.");
        } else if (a > 0 && b > 0) {
            throw new MyException("Both numbers are positive.");
        }
    }
}