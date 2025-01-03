

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Bank class
class Bank {
    private final Map<Integer, Integer> accounts = new HashMap<>();
    private final Lock lock = new ReentrantLock();

    // Add an account with an initial balance
    public void addAccount(int accountNumber, int initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    // Deposit method
    public void deposit(int accountNumber, int amount) {
        lock.lock();
        try {
            if (accounts.containsKey(accountNumber)) {
                int newBalance = accounts.get(accountNumber) + amount;
                accounts.put(accountNumber, newBalance);
                System.out.println("Deposited " + amount + " to account " + accountNumber + ". New balance: " + newBalance);
            } else {
                System.out.println("Account " + accountNumber + " not found.");
            }
        } finally {
            lock.unlock();
        }
    }

    // Withdraw method
    public void withdraw(int accountNumber, int amount) {
        lock.lock();
        try {
            if (accounts.containsKey(accountNumber)) {
                int currentBalance = accounts.get(accountNumber);
                if (currentBalance >= amount) {
                    int newBalance = currentBalance - amount;
                    accounts.put(accountNumber, newBalance);
                    System.out.println("Withdrew " + amount + " from account " + accountNumber + ". New balance: " + newBalance);
                } else {
                    System.out.println("Insufficient funds in account " + accountNumber + ". Current balance: " + currentBalance);
                }
            } else {
                System.out.println("Account " + accountNumber + " not found.");
            }
        } finally {
            lock.unlock();
        }
    }

    // Get balance method
    public int getBalance(int accountNumber) {
        lock.lock();
        try {
            return accounts.getOrDefault(accountNumber, 0);
        } finally {
            lock.unlock();
        }
    }
}
