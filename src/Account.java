import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    protected double balance;

    public void deposit(double amount){
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
