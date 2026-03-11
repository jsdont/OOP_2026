public class CheckingAccount extends Account {
    private static final int    FREE_TRANSACTIONS = 3;
    private static final double FEE_PER_TRANSACTION = 0.02;
    private int transactionCount;
    public CheckingAccount(int accNumber) {
        super(accNumber);
        this.transactionCount = 0;
    }
    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
    }
    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
    }
    public void deductFee() {
        int chargeableTransactions = transactionCount - FREE_TRANSACTIONS;
        if (chargeableTransactions > 0) {
            double fee = chargeableTransactions * FEE_PER_TRANSACTION;
            setBalance(getBalance() - fee);
            System.out.printf("Fee deducted: $%.2f for %d extra transaction(s)%n",
                    fee, chargeableTransactions);
        } else {
            System.out.println("No fee: within free transaction limit.");
        }
        transactionCount = 0; 
    }
    public int getTransactionCount() { return transactionCount; }
    @Override
    public String toString() {
        return String.format("CheckingAccount #%d | Balance: $%.2f | Transactions: %d (free: %d)",
                getAccountNumber(), getBalance(), transactionCount, FREE_TRANSACTIONS);
    }
}
