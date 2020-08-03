package banking;

import java.util.Random;

public class BankInformationGenerator {

    private static final int pinLenght = 4;
    private static final Random random = new Random();

    private static String generateSequence(int lenght) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            sequence.append(random.nextInt(10));
        }
        return sequence.toString();
    }

    private static int getControlSum(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int e = (int)number.charAt(i) - '0';
            if (i % 2 == 0) {
                e *= 2;
            }
            if (e > 9) {
                e -= 9;
            }
            sum += e;
        }
        return sum;
    }

    private static String getChecksum(String number) {
        int controlSum = getControlSum(number);
        if (controlSum % 10 == 0) {
            return "0";
        }
        return String.valueOf(10 - controlSum % 10);
    }

    public static String generateNumber() {
        String number = "400000" + generateSequence(9);
        return number + getChecksum(number);
    }

    public static boolean isCorrectNumber(String number) {
        return getChecksum(number.substring(0, number.length() - 1)).equals(String.valueOf(number.charAt(number.length() - 1)));
    }

    public static String generatePin() {
        return generateSequence(pinLenght);
    }
}
