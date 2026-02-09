package collections;

public class SavingAccount extends Account {

    public SavingAccount(int number) {
        super(number);
    }

    @Override
    public float deposit(float amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return getBalance();
        }
        setBalance(getBalance() + amount);
        return getBalance();
    }

    @Override
    public float withdraw(float amount) {
        if (getBalance() < amount) {
            System.out.println("Insufficient Balance.");
            return getBalance();
        }
        setBalance(getBalance() - amount);
        return getBalance();
    }
}
