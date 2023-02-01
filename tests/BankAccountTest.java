import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountTest {

    @Test
    void setOwner() {
        SalaryAccount account = new SalaryAccount(20000, new Customer("Tobias", Status.VIP), 30000);
        Customer Lars = new Customer("Tobias", Status.VIP);
        account.setOwner(Lars);
        assertEquals("Tobias", account.getOwner().getName());
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        SalaryAccount account = new SalaryAccount(20000, new Customer("Tobias", Status.VIP), 30000);
        assertFalse(account.withdraw(-100));
        assertTrue(account.withdraw(100));
        assertFalse(account.withdraw(0));
        assertTrue(account.withdraw(100.25));
        assertTrue(account.withdraw(0.25));
        assertFalse(account.withdraw(-100.25));

    }

    @org.junit.jupiter.api.Test
    void deposit() {
        SalaryAccount account = new SalaryAccount(20000, new Customer("Tobias", Status.VIP), 30000);
        double initialBalance = account.getBalance();

        account.deposit(-100);
        assertEquals(initialBalance, account.getBalance());
        account.deposit(100);
        assertEquals(100, account.getBalance() - initialBalance);
        account.deposit(0);
        assertEquals(100, account.getBalance() - initialBalance);
        account.deposit(0.25);
        assertEquals(100.25, account.getBalance() - initialBalance);
        account.deposit(-100.25);
        assertEquals(100.25, account.getBalance() - initialBalance);
        account.deposit(100.25);
        assertEquals(200.5, account.getBalance() - initialBalance);
    }
}