import javax.sound.midi.SysexMessage;
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

        int choice = scanner.nextInt();

        Account acc;
        if(choice == 1){
            acc = new SavingsAccount();
        } else{
            acc = new CurrentAccount();
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
}
