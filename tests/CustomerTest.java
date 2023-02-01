import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerTest
{
    Customer customer;

    @BeforeAll
    void setUp()
    {
        customer = new Customer("Tobias", Status.VIP);
    }

    @Test
    void addAccount()
    {
        int initialSize = customer.accounts.size();
        customer.addAccount(new PremiumAccount(500000, customer));
        assertEquals(initialSize +1, customer.accounts.size());
    }

    @Test
    void remove()
    {
        BankAccount account = new PremiumAccount(20000, customer);

        customer.addAccount(account);
        customer.remove(new PenguinAccount(10000, new Customer("Tobias dværg", Status.CHILD)));
        assertEquals(1, customer.accounts.size());
    }

    @Test
    void getName()
    {
        assertEquals("Tobias", customer.getName());
    }

    @Test
    void setName()
    {
        customer.setName("R2D2");
        assertEquals("NOT_VALID", customer.getName());

        customer.setName(null);
        assertEquals("NOT_VALID", customer.getName());

        customer.setName("Sander");
        assertEquals("Sander", customer.getName());
    }

    @Test
    void getStatus()
    {
        customer.setStatus(Status.VIP);
        assertEquals(Status.VIP, customer.getStatus());

        customer.setStatus(null);
        assertEquals(Status.VIP, customer.getStatus());
    }

    @Test
    void setStatus()
    {
        customer.setStatus(null);
        assertEquals(Status.VIP, customer.getStatus());

        customer.setStatus(Status.CHILD);
        assertEquals(Status.CHILD, customer.getStatus());
    }
}