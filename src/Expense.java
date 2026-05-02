public class Expense extends Transaction {
    public Expense(double amount){
        super(amount);
    }

    @Override
    public void apply(Account acc){
        acc.withdraw(amount);
    }
}
