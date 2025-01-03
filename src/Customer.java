// Customer class
class Customer extends Thread {
    private final Bank bank;
    private final int accountNumber;

    public Customer(Bank bank, int accountNumber) {
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    @Override
    public void run() {
        // Perform some transactions
        bank.deposit(accountNumber, 100);
        bank.withdraw(accountNumber, 50);
        bank.deposit(accountNumber, 200);
        bank.withdraw(accountNumber, 300);
    }
}
