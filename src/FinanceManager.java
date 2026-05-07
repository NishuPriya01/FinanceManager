import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinanceManager {
    private List<User> users = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void createUser(){
        System.out.print("Enter user name: ");
        String name = scanner.next();
        users.add(new User(name));
        System.out.println("User created.");
    }

    public void createAccount(){
        if (users.isEmpty()){
            System.out.println("No user found");
            return;
        }
         User user = users.get(0);

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Go back to the main menu");

        int choice = scanner.nextInt();

        Account acc;
        if(choice == 1){
            acc = new SavingsAccount();
        } else if (choice == 2){
            acc = new CurrentAccount();
        } else if (choice == 3){
            return;
        } else {
            System.out.println("Invalid Input.");
            return;
        }

        user.addAccount(acc);
        System.out.println("Account created.");
    }

    public void viewBalance(){
        if(users.isEmpty() || users.get(0).getAccounts().isEmpty()){
            System.out.println("No account found");
            return;
        }

        Account acc = users.get(0).getAccounts().get(0);
        System.out.println("Balance: "+ acc.getBalance());
    }

    public void addTransaction() {
        if(users.isEmpty() || users.get(0).getAccounts().isEmpty()){
            System.out.println("Account not found");
            return;
        }

        Account acc = users.get(0).getAccounts().get(0);

        System.out.println("1. Income");
        System.out.println("2. Expense");

        int type = scanner.nextInt();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        if(amount <= 0){
            System.out.println("Invalid amount.");
            return;
        }

        Transaction t;

        if(type == 1){
            t = new Income(amount);
        } else{
            t = new Expense(amount);
        }

        boolean success = t.apply(acc);

        if(success){
            acc.addTransaction(t);
        }

        System.out.println("Transaction added.");
    }

    public void viewTransactions() {
        if (users.isEmpty() || users.get(0).getAccounts().isEmpty()) {
            System.out.println("No account found.");
            return;
        }

        Account acc = users.get(0).getAccounts().get(0);

        if(acc.getTransactions().isEmpty()){
            System.out.println("No transactions yet.");
            return;
        }

        for (Transaction t : acc.getTransactions()) {
            System.out.println(t.getClass().getSimpleName() + " - Rs." + t.amount);
        }
    }
}
