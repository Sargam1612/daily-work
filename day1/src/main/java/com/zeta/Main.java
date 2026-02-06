import com.zeta.Account;
import com.zeta.CurrentAccount;
import com.zeta.SavingsAccount;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account account=new SavingsAccount(123);
//        account.number = 345;
        System.out.println(account.getNumber());
//        account.type = ACCOUNT_TYPE.SAVINGS;
        Account current = new CurrentAccount(999);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(current);
        accounts.forEach(account1 -> {
            account1.deposit(2000);
        });
    }
}