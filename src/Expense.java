public class Expense extends Transaction {
    public Expense(double amount){
        super(amount);
    }

    @Override
    public boolean apply(Account acc){
        return acc.withdraw(amount);
    }
}
