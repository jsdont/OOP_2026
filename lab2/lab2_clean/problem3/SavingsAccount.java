public class SavingsAccount extends Account {
    private double interestRate; 
    public SavingsAccount(int accNumber, double interestRate) {
        super(accNumber);
        this.interestRate = interestRate;
    }
    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }
    public void addInterest() {
        double interest = getBalance() * (interestRate / 100.0);
        deposit(interest);
        System.out.printf("Interest added: $%.2f (rate: %.2f%%)%n", interest, interestRate);
    }
    @Override
    public String toString() {
        return String.format("SavingsAccount #%d | Balance: $%.2f | Interest Rate: %.2f%%",
                getAccountNumber(), getBalance(), interestRate);
    }
}
