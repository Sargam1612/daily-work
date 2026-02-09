package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaWithCollections {
    public static void main(String[] args){
        showWithArrayList();
    }

    static Predicate<Account> removeFunction = account -> account.getNumber()%2==0;
    public static void showWithArrayList(){
        List<Account> accounts = new ArrayList<>();
        for(int i=0;i<10;i++){
            accounts.add(new SavingAccount(i+1) {});
        }

        //built in removeIf function
        accounts.removeIf(removeFunction);
        //Lambda function - consumer type
        accounts.forEach(account -> System.out.println(account.getNumber()));
    }
}
