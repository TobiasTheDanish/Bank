public class SalaryAccount extends BankAccount
{
    private double creditLimit;

    public SalaryAccount(double balance, Customer owner, double creditLimit)
    {
        super(balance, owner);
        setCreditLimit(creditLimit);
    }

    @Override
    void setOwner(Customer owner)
    {
        if (owner.getStatus() == Status.VIP || owner.getStatus() == Status.ADULT) {
            this.owner = owner;
        } else {
            this.owner = null;
        }
    }

    @Override
    boolean withdraw(double amount)
    {
        if (amount <= 0 || amount > balance + creditLimit) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public double getCreditLimit()
    {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit)
    {
        if (creditLimit > 0) {
            this.creditLimit = creditLimit;
        } else {
            this.creditLimit = 0;
        }
    }
}
