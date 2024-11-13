import java.util.Scanner;

class Account {
    protected String customerName;
    protected int accountNumber;
    protected double balance;

    public Account(String customerName, int accountNumber, double balance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

class SavAcct extends Account {
    private double interestRate;

    public SavAcct(String customerName, int accountNumber, double balance, double interestRate) {
        super(customerName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        balance += balance * (interestRate / 100);
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
    }
}

class CurAcct extends Account {
    private double minimumBalance, penaltyCharge;

    public CurAcct(String customerName, int accountNumber, double balance, double minimumBalance, double penaltyCharge) {
        super(customerName, accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.penaltyCharge = penaltyCharge;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            if (balance < minimumBalance) balance -= penaltyCharge;
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accNumber = sc.nextInt();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        Account account = null;
        while (true) {
            System.out.println("1. Savings\n2. Current");
            int type = sc.nextInt();
            if (type == 1) {
                System.out.print("Enter interest rate: ");
                double interestRate = sc.nextDouble();
                account = new SavAcct(name, accNumber, balance, interestRate);
                break;
            } else if (type == 2) {
                System.out.print("Enter minimum balance: ");
                double minBalance = sc.nextDouble();
                System.out.print("Enter penalty charge: ");
                double penaltyCharge = sc.nextDouble();
                account = new CurAcct(name, accNumber, balance, minBalance, penaltyCharge);
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        while (true) {
            System.out.println("1. Deposit\n2. Withdraw\n3. Display Balance\n4. Compute Interest\n5. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter deposit amount: ");
                account.deposit(sc.nextDouble());
            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                double amount = sc.nextDouble();
                if (account instanceof SavAcct) ((SavAcct) account).withdraw(amount);
                else if (account instanceof CurAcct) ((CurAcct) account).withdraw(amount);
            } else if (choice == 3) {
                account.displayBalance();
            } else if (choice == 4 && account instanceof SavAcct) {
                ((SavAcct) account).computeAndDepositInterest();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
