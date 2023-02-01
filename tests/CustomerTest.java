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
        assertAll(
        () -> {
            ArrayList<BankAccount> initialAccounts = customer.accounts;
            customer.addAccount(new PremiumAccount(500000, customer));
            assertTrue(initialAccounts.size() < customer.accounts.size());
        },
        () -> {
            ArrayList<BankAccount> initialAccounts = customer.accounts;
            customer.addAccount(new PenguinAccount(10000, customer));
            assertEquals(customer.accounts.size(), initialAccounts.size());
        },
        () -> {
            ArrayList<BankAccount> initialAccounts = customer.accounts;
            customer.addAccount(new PremiumAccount(1000000, customer));
            assertEquals(customer.accounts.size(), initialAccounts.size());
        }
         );
    }

    @Test
    void remove()
    {
        BankAccount account = new PremiumAccount(20000, customer);
        customer.addAccount(account);

        customer.remove(account);
        assertEquals(0, customer.accounts.size());

        customer.addAccount(account);
        customer.remove(new PenguinAccount(10000, new Customer("Tobias berg", Status.CHILD)));
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
        assertEquals("Tobias", customer.getName());

        customer.setName(null);
        assertEquals("Tobias", customer.getName());

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