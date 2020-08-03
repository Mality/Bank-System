package banking;

import banking.menu.MenuManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankSystem bankSystem = new BankSystem();
        CardDatabase cardDatabase = new CardDatabase(bankSystem);
        bankSystem.setCardDatabase(cardDatabase);
        if (args.length == 2 && "-fileName".equals(args[0])) {
            cardDatabase.setName(args[1]);
        }
        cardDatabase.connect();
        MenuManager menuManager = new MenuManager(scanner, bankSystem);
        menuManager.run();
    }
}
