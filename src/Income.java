public class Income extends Transaction {
    public Income(double amount){
        super(amount);
    }

    @Override
    public void apply(Account acc){
        acc.deposit(amount);
    }
}
