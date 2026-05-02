import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Account> accounts;

    public User(String name){
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account acc){
        accounts.add(acc);
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public String getName() {
        return name;
    }
}
