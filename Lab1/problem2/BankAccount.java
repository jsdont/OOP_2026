/**
 * Problem 2 - BankAccount class
 * Demonstrates: enum, static, final, "this" (2 usages),
 * read-only field, method overloading, initialization block.
 *
 * Context: A simple bank account system.
 *
 * static non-final example: accountCount (tracks total accounts created, can change)
 * final non-static example: accountId (unique per object, set once, never changes)
 */
public class BankAccount {

    // Enum - account type
    public enum AccountType {
        SAVINGS, CHECKING, CREDIT
    }

    // static final - constant bank name (shared, never changes)
    public static final String BANK_NAME = "KBTU Bank";

    // static non-final - counts how many accounts have been created (shared, changes)
    public static int accountCount = 0;

    // final non-static (read-only after construction) - unique account ID
    public final int accountId;

    private String ownerName;
    private double balance;
    private AccountType type;

    // Initialization block - runs before every constructor
    {
        accountCount++;
        accountId = accountCount;
        System.out.println("Initialization block: new account being created. Total accounts: " + accountCount);
    }

    // Constructor 1: default
    public BankAccount() {
        this.ownerName = "Unknown";   // "this" usage #1
        this.balance = 0.0;           // "this" usage #2
        this.type = AccountType.CHECKING;
    }

    // Constructor 2: name only
    public BankAccount(String ownerName) {
        this();                        // delegates to default constructor
        this.ownerName = ownerName;
    }

    // Constructor 3: full
    public BankAccount(String ownerName, double balance, AccountType type) {
        this(ownerName);               // delegates to previous constructor
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
        this.type = type;
    }

    // Method overloading - deposit with and without description
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        this.balance += amount;
        System.out.printf("Deposited %.2f. New balance: %.2f%n", amount, balance);
    }

    public void deposit(double amount, String description) {
        System.out.println("Description: " + description);
        deposit(amount);   // calls the other overload
    }

    // Method overloading - withdraw with and without minimum balance check
    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        this.balance -= amount;
        System.out.printf("Withdrawn %.2f. New balance: %.2f%n", amount, balance);
        return true;
    }

    public boolean withdraw(double amount, double minimumBalance) {
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal would go below minimum balance of " + minimumBalance);
            return false;
        }
        return withdraw(amount);
    }

    public String getOwnerName() { return ownerName; }
    public double getBalance()   { return balance; }
    public AccountType getType() { return type; }

    @Override
    public String toString() {
        return String.format("BankAccount[id=%d, owner=%s, type=%s, balance=%.2f]",
                accountId, ownerName, type, balance);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount("Alice");
        BankAccount acc3 = new BankAccount("Bob", 500.0, AccountType.SAVINGS);

        acc3.deposit(200.0, "Monthly salary");
        acc3.withdraw(100.0);
        acc3.withdraw(1000.0, 100.0);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println("Bank: " + BankAccount.BANK_NAME);
        System.out.println("Total accounts: " + BankAccount.accountCount);
    }
}
