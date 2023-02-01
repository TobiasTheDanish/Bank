import java.util.ArrayList;

public class Customer
{
    String name;
    Status status;
    int id;
    ArrayList<BankAccount> accounts;

    public Customer(String name, Status status)
    {
        setName(name);
        setStatus(status);
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {

    }

    public void remove(BankAccount account) {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public Status getStatus()
    {
        return status;
    }
}
