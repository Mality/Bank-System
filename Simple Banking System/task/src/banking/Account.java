package banking;

public class Account {
    private String number;
    private String pin;
    private int balance;

    public Account(String number, String pin) {
        this.number = number;
        this.pin = pin;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int value) {
        balance += value;
    }

    public void withdraw(int value) {
        balance -= value;
    }
}
