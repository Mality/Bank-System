package banking.menu;

import banking.BankSystem;

import java.util.Scanner;

public class MainMenu extends Menu {

    String message = "1. Create an account\n" +
            "2. Log into account\n" +
            "0. Exit";

    public MainMenu(Scanner scanner, BankSystem bankSystem) {
        super(scanner, bankSystem);
    }

    public Menu run() {
        System.out.println(message);
        String input = scanner.nextLine();;
        return processInput(input);
    }

    private Menu processInput(String input) {
        switch (input) {
            case "1":
                return new AccountCreationMenu(scanner, bankSystem);

            case "2":
                return new LoginMenu(scanner, bankSystem);

            case "0":
                return null;

            default:
                System.out.println("Unknown command\n");
                return this;
        }
    }
}
