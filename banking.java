import java.util.*;
class Account {
    int accountNumber;
    String name;
    double balance;

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully!");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: " + balance);
    }
}

class Bank {
    List<Account> accounts = new ArrayList<>();

    public void createAccount(int accountNumber, String name, double initialBalance) {
        accounts.add(new Account(accountNumber, name, initialBalance));
        System.out.println("Account created successfully!");
    }

    public Account findAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.accountNumber == accountNumber) {
                return acc;
            }
        }
        return null;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initBal = sc.nextDouble();
                    bank.createAccount(accNo, name, initBal);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    Account acc = bank.findAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        acc.deposit(sc.nextDouble());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    acc = bank.findAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        acc.withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();
                    acc = bank.findAccount(accNo);
                    if (acc != null) {
                        acc.displayBalance();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Banking System!");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

