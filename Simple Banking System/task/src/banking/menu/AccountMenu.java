package banking.menu;

import banking.Account;
import banking.BankInformationGenerator;
import banking.BankSystem;

import java.util.Scanner;

public class AccountMenu extends Menu {

    private Account account;
    private String message = "1. Balance\n" +
            "2. Add income\n" +
            "3. Do transfer\n" +
            "4. Close account\n" +
            "5. Log out\n" +
            "0. Exit";
    private String logOutMessage = "\nYou have successfully logged out!\n";
    private String balanceMessage = "\nBalance: %d\n\n";

    public AccountMenu(Scanner scanner, Account account, BankSystem bankSystem) {
        super(scanner, bankSystem);
        this.account = account;
    }

    @Override
    public Menu run() {
        System.out.println(message);
        String input = scanner.nextLine();
        return processInput(input);
    }

    private Menu processInput(String input) {
        switch (input) {
            case "1":
                System.out.printf(balanceMessage, account.getBalance());
                return this;

            case "2":
                System.out.println("\nEnter income:");
                int income = Integer.parseInt(scanner.nextLine());
                account.deposit(income);
                System.out.println("Income was added!\n");
                return this;

            case "3":
                System.out.println("\nTransfer");
                System.out.println("Enter card number:");
                String toNumber = scanner.nextLine();
                if (toNumber.equals(account.getNumber())) {
                    System.out.println("You can't transfer money to the same account!\n");
                    return this;
                }
                if (!BankInformationGenerator.isCorrectNumber(toNumber)) {
                    System.out.println("Probably you made mistake in the card number. Please try again!\n");
                    return this;
                }
                if (!bankSystem.hasAccount(toNumber)) {
                    System.out.println("Such a card does not exist.\n");
                    return this;
                }
                System.out.println("Enter how much money you want to transfer:");
                int sum = Integer.parseInt(scanner.nextLine());
                if (account.getBalance() < sum) {
                    System.out.println("Not enough money!\n");
                }
                account.withdraw(sum);
                Account targetAccount = bankSystem.getAccountByNumber(toNumber);
                targetAccount.deposit(sum);
                System.out.println("Success!\n");
                return this;

            case "4":
                bankSystem.deleteAccount(account.getNumber());
                System.out.println("\nThe account has been closed!\n");
                return new MainMenu(scanner, bankSystem);

            case "5":
                System.out.println(logOutMessage);
                return new MainMenu(scanner, bankSystem);

            case "0":
                return null;

            default:
                System.out.println("Unknown command");
                return this;
        }
    }
}
