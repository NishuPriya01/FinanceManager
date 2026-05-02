import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected double balance;
    protected List<Transaction> transactions = new ArrayList<>();

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
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
