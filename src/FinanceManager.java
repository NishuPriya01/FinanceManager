import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FinanceManager {
    private List<User> users = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void createUser(){
        scanner.nextLine();
        System.out.print("Enter user name: ");
        String name;
        name = scanner.nextLine();

        if(name.trim().isEmpty()){
            System.out.println("User name cannot be empty.");
            return;
        }
        users.add(new User(name));
        System.out.println("User created.");
    }

    public void createAccount(){
        if (users.isEmpty()){
            System.out.println("No user found");
            return;
        }
        User user = selectUser();

        if(user == null){
            return;
        }

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Go back to the main menu");

        int choice;

        try{
            choice = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Please enter a valid input.");
            scanner.nextLine();
            return;
        }

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
        User user = selectUser();
        if(user == null){
            return;
        }

        Account acc = selectAccount(user);
        if(acc == null){
            return;
        }
        System.out.println("Balance: "+ acc.getBalance());
    }

    public void addTransaction() {
        User user = selectUser();
        if(user == null){
            return;
        }

        Account acc = selectAccount(user);
        if(acc == null){
            return;
        }

        System.out.println("1. Income");
        System.out.println("2. Expense");

        int type;

        try{
            type = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Please enter a valid input.");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter amount: ");
        double amount;

        try{
            amount = scanner.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Invalid amount.");
            scanner.nextLine();
            return;
        }

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
            System.out.println("Transaction added.");
        }
    }

    public void viewTransactions() {
        User user = selectUser();
        if(user == null){
            return;
        }

        Account acc = selectAccount(user);
        if(acc == null){
            return;
        }

        if(acc.getTransactions().isEmpty()){
            System.out.println("No transactions yet.");
            return;
        }

        for (Transaction t : acc.getTransactions()) {
            System.out.println(t.getClass().getSimpleName() + " - Rs." + t.getAmount());
        }
    }

    public User selectUser(){
        if (users.isEmpty()){
            System.out.println("No users found.");
            return null;
        }

        System.out.println("\nSelect user:");

        for(int i = 0; i < users.size(); i++){
            System.out.println((i+1)+"."+users.get(i).getName());
        }

        System.out.println("0.Back");

        int choice;

        try{
            choice = scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Invalid input.");
            scanner.nextLine();
            return null;
        }

        if(choice == 0){
            return null;
        }

        if (choice < 1 || choice > users.size()){
            System.out.println("Invalid choice.");
            return null;
        }
        return users.get(choice - 1);
    }

    public Account selectAccount(User user){
        if (user.getAccounts().isEmpty()){
            System.out.println("No account found.");
            return null;
        }

        System.out.println("\nSelect Account:");

        for(int i = 0; i < user.getAccounts().size(); i++){
            Account acc = user.getAccounts().get(i);
            System.out.println((i+1)+"."+acc.getClass().getSimpleName());
        }
        System.out.println("0.Back");

        int choice;

        try{
            choice = scanner.nextInt();
        } catch(InputMismatchException e){
            System.out.println("Invalid input.");
            scanner.nextLine();
            return null;
        }

        if(choice == 0) {
            return null;
        }

        if(choice < 1 || choice > user.getAccounts().size()){
            System.out.println("Invalid choice. Please enter the number from the menu.");
            return null;
        }

        return user.getAccounts().get(choice - 1);
    }
}
