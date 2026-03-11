public class TestProblem3 {
    public static void main(String[] args) {
        System.out.println("===== Problem 3: Bank Account System =====\n");
        Bank bank = new Bank();
        Account basic         = bank.openAccount();
        SavingsAccount savings = bank.openSavingsAccount(5.0);  
        CheckingAccount checking = bank.openCheckingAccount();
        System.out.println();
        basic.deposit(500);
        savings.deposit(1000);
        checking.deposit(200);  
        checking.deposit(150);  
        checking.withdraw(50);  
        checking.withdraw(30);  
        checking.deposit(20);   
        System.out.println("\nBefore update:");
        bank.printAll();
        System.out.println("\nTransferring $100 from basic to savings:");
        basic.transfer(100, savings);
        basic.print();
        savings.print();
        bank.update();
        System.out.println("After update:");
        bank.printAll();
        System.out.println("\nClosing basic account:");
        bank.closeAccount(basic);
        bank.printAll();
    }
}
