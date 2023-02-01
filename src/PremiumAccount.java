public class PremiumAccount extends BankAccount
{
    public PremiumAccount(double balance, Customer owner)
    {
        super(balance, owner);
    }

    @Override
    void setOwner(Customer owner)
    {
        if (owner.getStatus() == Status.VIP) {
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

        balance -= amount;
        return true;
    }
}
