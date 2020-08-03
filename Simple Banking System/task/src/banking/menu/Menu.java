package banking.menu;

import banking.BankSystem;

import java.util.Scanner;

public class Menu {

    Scanner scanner;
    BankSystem bankSystem;

    public Menu(Scanner scanner, BankSystem bankSystem) {
        this.scanner = scanner;
        this.bankSystem = bankSystem;
    }

    public Menu run() {
        return this;
    }

}
