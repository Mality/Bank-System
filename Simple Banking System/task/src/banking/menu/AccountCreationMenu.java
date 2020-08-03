package banking.menu;

import banking.Account;
import banking.BankSystem;

import java.util.Scanner;

public class AccountCreationMenu extends Menu {

    String message = "\nYour card has been created\n" +
            "Your card number:\n" +
            "%s\n" +
            "Your card PIN:\n" +
            "%s\n\n";

    public AccountCreationMenu(Scanner scanner, BankSystem bankSystem) {
        super(scanner, bankSystem);
    }

    @Override
    public Menu run() {
        Account account = bankSystem.createNewAccount();
        System.out.printf(message, account.getNumber(), account.getPin());
        return new MainMenu(scanner, bankSystem);
    }
}
