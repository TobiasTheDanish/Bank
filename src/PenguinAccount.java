public class PenguinAccount extends BankAccount
{
    public PenguinAccount(double balance, Customer owner)
    {
        super(balance, owner);
    }

    @Override
    void setOwner(Customer owner)
    {
        if (owner.getStatus() == Status.CHILD) {
            this.owner = owner;
        } else {
            this.owner = null;
        }
    }

    @Override
    boolean withdraw(double amount)
    {
        if (amount <= 0 ) {
            return false;
        }

        if (amount <= balance) {
            balance -= amount;
            return true;
        }

        return false;
    }
}
