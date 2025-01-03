import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Main class to simulate the bank system
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Initialize accounts
        bank.addAccount(1, 500);
        bank.addAccount(2, 1000);

        // Create customer threads
        Customer customer1 = new Customer(bank, 1);
        Customer customer2 = new Customer(bank, 2);

        // Start the customer threads
        customer1.start();
        customer2.start();

        // Wait for threads to complete
        try {
            customer1.join();
            customer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final account balances
        System.out.println("Final balance of account 1: " + bank.getBalance(1));
        System.out.println("Final balance of account 2: " + bank.getBalance(2));
    }
}
