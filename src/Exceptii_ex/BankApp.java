package Exceptii_ex;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CREARE CONT BANCAR");
        System.out.println("Introdu numarul de cont: ");
        String accNum = scanner.nextLine();

        SavingsAccount myAccount = new SavingsAccount(accNum, 500.0, 0.05);
        System.out.println("Contul a fost creat cu succes! Sold initial: 500.0 RON.\n");

        boolean running = true;

        while (running) {
            System.out.println("\n--- Meniu Operatiuni ---");
            System.out.println("1. Depunere");
            System.out.println("2. Retragere");
            System.out.println("3. Aplica dobanda");
            System.out.println("4. Verifica sold");
            System.out.println("5. Iesire");
            System.out.print("Alege o optiune: ");

            int option = scanner.nextInt();

            try {
                switch (option) {
                    case 1:
                        System.out.print("Introdu suma pentru depunere: ");
                        double depAmount = scanner.nextDouble();
                        myAccount.deposit(depAmount);
                        break;

                    case 2:
                        System.out.print("Introdu suma pentru retragere: ");
                        double withAmount = scanner.nextDouble();
                        myAccount.withdraw(withAmount);
                        break;

                    case 3:
                        myAccount.applyInterest();
                        break;

                    case 4:
                        System.out.println("Soldul curent al contului " + myAccount.getAccountNumber() + " este: " + myAccount.getBalance() + " RON.");
                        break;

                    case 5:
                        running = false;
                        break;

                    default:
                        System.out.println("Optiune invalida. Încearca din nou.");
                }
            } catch (InvalidAmountException e) {
                System.out.println("Eroare de Validare: " + e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println("Eroare Bancara: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("O eroare neasteptata a avut loc: " + e.getMessage());
            } finally {
                System.out.println("[Sistemul functioneaza in siguranta. Tranzactie procesata.]");
            }
        }

        System.out.println("\nProgramul s-a incheiat.");
        scanner.close();
    }
}
