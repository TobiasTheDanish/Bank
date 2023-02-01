import java.util.Random;

public abstract class BankAccount
{
    protected int id;
    protected double balance;
    protected Customer owner;

    public BankAccount(double balance, Customer owner)
    {
        Random rand = new Random();
        id = rand.nextInt(4000000) + 1000000;
        this.balance = balance;
        setOwner(owner);
    }

    abstract void setOwner(Customer owner);
    abstract boolean withdraw(double amount);

    public void deposit(double amount) {
        balance += amount;
    }

    public int getId()
    {
        return id;
    }

    public double getBalance()
    {
        return balance;
    }

    public Customer getOwner()
    {
        return owner;
    }
}
