import java.util.Scanner;

public class Main {

    public static void methodOne() {
        methodTwo();

    }

    public static void methodTwo() {
        methodThree();
    }

    public static void methodThree() {
        System.out.println(7/0);
    }

    public static ErrorCode validateFirstNumber(int number) {
        if(number < 0) {
            return ErrorCode.NUMBER_IS_NEGATIVE;
        }
        return null;
    }

    private static ErrorCode validateSecondNumber(int b) {
        if (b < 0) {
            return ErrorCode.NUMBER_IS_NEGATIVE;
        } else if (b == 0) {
            return ErrorCode.DIVIDE_BY_ZERO;
        }
        return null;
    }

    private static int divide (int a, int b) throws NumberException {
        ErrorCode codeFirstNumber = validateFirstNumber(a);
        if (codeFirstNumber != null) {
            throw new NumberException("Den första siffran är mindre än 0...", codeFirstNumber);
        }

        ErrorCode codeSecondNumber = validateSecondNumber(b);
        if(codeSecondNumber != null) {
            switch (codeSecondNumber) {
                case DIVIDE_BY_ZERO:
                    throw new NumberException("Siffran är 0 och det går inte att dividera med det", codeSecondNumber);
                case NUMBER_IS_NEGATIVE:
                    throw new NumberException("Siffran är mindre än 0...", codeSecondNumber);
            }
        }

        int result = a / b;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Fråga om första siffran
        System.out.println("Skriv in en siffra:");
        int a = scanner.nextInt();

        // Fråga om andra siffran
        System.out.println("Skriv in en siffra igen:");
        int b = scanner.nextInt();

        try {
            int divide = divide(a, b);
            System.out.println(divide);
        } catch (NumberException e) {
            e.printStackTrace();
            System.out.println(e.code);
        }

        /*try {
            methodOne();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }*/




        int result = 0;

        /*try {
            result = divide(a, b);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("Du försökte dividera med 0, det får man inte");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Nu gick någonting annat snett");
        }*/

    }
}
