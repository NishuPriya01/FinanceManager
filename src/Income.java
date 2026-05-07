public class Income extends Transaction {
    public Income(double amount){
        super(amount);
    }

    @Override
    public boolean apply(Account acc){
        return acc.deposit(amount);
    }
}
