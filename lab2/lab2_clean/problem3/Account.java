public class Account {
    private double balance;
    private int accNumber;
    public Account(int accNumber) {
        this.balance = 0.0;
        this.accNumber = accNumber;
    }
    public void deposit(double sum) {
        if (sum <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += sum;
    }
    public void withdraw(double sum) {
        if (sum <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (sum > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= sum;
    }
    public double getBalance() { return balance; }
    protected void setBalance(double balance) { this.balance = balance; }
    public int getAccountNumber() { return accNumber; }
    public void transfer(double amount, Account other) {
        if (amount <= 0) {
            System.out.println("Transfer amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds for transfer.");
            return;
        }
        this.withdraw(amount);
        other.deposit(amount);
    }
    @Override
    public String toString() {
        return String.format("Account #%d | Balance: $%.2f", accNumber, balance);
    }
    public final void print() {
        System.out.println(toString());
    }
}
