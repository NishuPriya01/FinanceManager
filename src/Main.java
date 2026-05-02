import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        FinanceManager manager = new FinanceManager();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n1. Create User");
            System.out.println("2. Create Account");
            System.out.println("3. Add Transaction");
            System.out.println("4. View Balance");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    manager.createUser();
                    break;
                case 2:
                    manager.createAccount();
                    break;
                case 3:
                    manager.addTransaction();
                    break;
                case 4:
                    manager.viewBalance();
                    break;
                case 5:
                    manager.viewTransactions();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
