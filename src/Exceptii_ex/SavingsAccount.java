package Exceptii_ex;

public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("S-a aplicat dobanda de " + (interestRate * 100) + "%. Dobanda acumulata: " + interest + " RON. Sold nou: " + balance + " RON.");
    }
}
