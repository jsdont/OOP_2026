import java.util.Vector;
public class Bank {
    private Vector<Account> accounts;
    private int nextAccountNumber;
    public Bank() {
        accounts = new Vector<>();
        nextAccountNumber = 1001;
    }
    public Account openAccount() {
        Account acc = new Account(nextAccountNumber++);
        accounts.add(acc);
        System.out.println("Opened: " + acc);
        return acc;
    }
    public SavingsAccount openSavingsAccount(double interestRate) {
        SavingsAccount acc = new SavingsAccount(nextAccountNumber++, interestRate);
        accounts.add(acc);
        System.out.println("Opened: " + acc);
        return acc;
    }
    public CheckingAccount openCheckingAccount() {
        CheckingAccount acc = new CheckingAccount(nextAccountNumber++);
        accounts.add(acc);
        System.out.println("Opened: " + acc);
        return acc;
    }
    public boolean closeAccount(Account account) {
        boolean removed = accounts.remove(account);
        if (removed) System.out.println("Closed account #" + account.getAccountNumber());
        else System.out.println("Account not found.");
        return removed;
    }
    public void update() {
        System.out.println("\n--- Bank Update ---");
        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).addInterest();
            } else if (acc instanceof CheckingAccount) {
                ((CheckingAccount) acc).deductFee();
            }
        }
        System.out.println("-------------------\n");
    }
    public void printAll() {
        System.out.println("=== All Accounts ===");
        for (Account acc : accounts) {
            acc.print();
        }
        System.out.println("====================");
    }
    public Vector<Account> getAccounts() { return accounts; }
}
