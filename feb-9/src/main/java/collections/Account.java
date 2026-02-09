package collections;

public abstract class Account {
    private float balance;  //mutable
    private final int number;
    public Account(int number) {
        this.number = number;
    }// immutable property

   public abstract float deposit (float amount);

   public abstract float withdraw(float amount);

    public int getNumber() {
        return number;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }


}
