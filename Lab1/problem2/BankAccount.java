public class BankAccount {
    public enum AccountType {
        SAVINGS, CHECKING, CREDIT
    }
    public static final String BANK_NAME = "KBTU Bank";
    public static int accountCount = 0;
    public final int accountId;
    private String ownerName;
    private double balance;
    private AccountType type;
    {
        accountCount++;
        accountId = accountCount;
        System.out.println("Initialization block: new account being created. Total accounts: " + accountCount);
    }
    public BankAccount() {
        this.ownerName = "Unknown";   
        this.balance = 0.0;           
        this.type = AccountType.CHECKING;
    }
    public BankAccount(String ownerName) {
        this();                        
        this.ownerName = ownerName;
    }
    public BankAccount(String ownerName, double balance, AccountType type) {
        this(ownerName);               
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
        this.type = type;
    }
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        this.balance += amount;
        System.out.printf("Deposited %.2f. New balance: %.2f%n", amount, balance);
    }
    public void deposit(double amount, String description) {
        System.out.println("Description: " + description);
        deposit(amount);   
    }
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
