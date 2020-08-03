package banking;

import java.io.File;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\pc\\Downloads\\dataset.txt");
        int sum = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext())  {
                sum += scanner.nextInt();
            }
        } catch (Exception e) {

        }
        System.out.println(sum);
    }
}
