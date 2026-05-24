package Exceptii_ex;

public class BankAccount {
    private String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Suma de depus trebuie sa fie mai mare decat 0. Suma introdusa: " + amount);
        }
        balance += amount;
        System.out.println("Succes! S-au depus " + amount + " RON. Sold curent: " + balance + " RON.");
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Suma de retras trebuie sa fie mai mare decat 0.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Fonduri insuficiente! Sold disponibil: " + balance + " RON. Ai cerut: " + amount + " RON.");
        }
        balance -= amount;
        System.out.println("Succes! S-au retras " + amount + " RON. Sold curent: " + balance + " RON.");
    }
}
