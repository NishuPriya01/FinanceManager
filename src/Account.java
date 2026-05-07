import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected double balance;
    protected List<Transaction> transactions = new ArrayList<>();

    public boolean deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid amount.");
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if(amount <= 0){
            System.out.println("Invalid amount.");
            return false;
        }
        if(amount > balance){
            System.out.println("Insufficient Balance.");
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public void addTransaction(Transaction t){
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
