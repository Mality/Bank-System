package banking.menu;

import banking.Account;
import banking.BankSystem;

import java.util.Scanner;

public class LoginMenu extends Menu {

    private String message1 = "\nEnter your card number:";
    private String message2 = "Enter your PIN:";
    private String successfulLogin = "\nYou have successfully logged in!\n";
    private String unsuccessfulLogin = "\nWrong card number or PIN!\n";

    public LoginMenu(Scanner scanner, BankSystem bankSystem) {
        super(scanner, bankSystem);
    }

    @Override
    public Menu run() {
        System.out.println(message1);
        String number = scanner.nextLine();
        System.out.println(message2);
        String pin = scanner.nextLine();
        return processInput(number, pin);
    }

    private Menu processInput(String number, String pin) {
        Account account = bankSystem.login(number, pin);
        if (account != null) {
            System.out.println(successfulLogin);
            return new AccountMenu(scanner, account, bankSystem);
        }
        System.out.println(unsuccessfulLogin);
        return new MainMenu(scanner, bankSystem);
    }
}
