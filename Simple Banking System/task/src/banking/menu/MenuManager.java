package banking.menu;

import banking.BankSystem;

import java.util.Scanner;

public class MenuManager {
    Menu currentMenu;
    Scanner scanner;
    BankSystem bankSystem;

    public MenuManager(Scanner scanner, BankSystem bankSystem) {
        currentMenu = new MainMenu(scanner, bankSystem);
        this.scanner = scanner;
        this.bankSystem = bankSystem;
    }

    public void run() {
        while (currentMenu != null) {
            currentMenu = currentMenu.run();
        }
        System.out.println("\nBye!");
    }
}
