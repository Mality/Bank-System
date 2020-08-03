package banking;

import java.util.*;

public class BankSystem {
    private List<Account> accounts;
    Set<String> accountNumbers;
    CardDatabase cardDatabase;

    public BankSystem() {
        accounts = new ArrayList<>();
        accountNumbers = new HashSet<>();
    }

    public Account createNewAccount() {
        String number;
        do {
            number = BankInformationGenerator.generateNumber();
        } while (accountNumbers.contains(number));
        String pin = BankInformationGenerator.generatePin();
        Account newAccount = new Account(number, pin);
        accounts.add(newAccount);
        accountNumbers.add(number);
        cardDatabase.addCard(number, pin);
        return newAccount;
    }

    public Account login(String number, String pin) {
        if (!accountNumbers.contains(number)) {
            return null;
        }
        for (Account account : accounts) {
            if (account.getNumber().equals(number) && account.getPin().equals(pin)) {
                return account;
            }
        }
        return null;
    }

    public void insertAccount(String number, String pin, int balance) {
        if (!accountNumbers.contains(number)) {
            Account account = new Account(number, pin);
            account.setBalance(balance);
            accounts.add(account);
            accountNumbers.add(number);
        }
    }

    public void deleteAccount(String number) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getNumber().equals(number)) {
                accounts.remove(i);
                break;
            }
        }
        accountNumbers.remove(number);
        cardDatabase.deleteCard(number);
    }

    public boolean hasAccount(String number) {
        return accountNumbers.contains(number);
    }

    public int size() {
        return accounts.size();
    }

    public void setCardDatabase(CardDatabase cardDatabase) {
        this.cardDatabase = cardDatabase;
    }

    public Account getAccountByNumber(String number) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getNumber().equals(number)) {
                return accounts.get(i);
            }
        }
        return null;
    }
}
