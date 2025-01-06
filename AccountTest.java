import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account1;
    private Account account2;

    @BeforeEach
    public void setUp() {
        account1 = new Account(1000);
        account2 = new Account(500);
    }

    @Test
    public void testDeposit() {
        assertTrue(account1.deposit(200));
        assertEquals(1200, account1.checkBalance());
        assertFalse(account1.deposit(-100));
    }

    @Test
    public void testWithdraw() {
        assertTrue(account1.withdraw(200));
        assertEquals(800, account1.checkBalance());
        assertFalse(account1.withdraw(1000));
    }

    @Test
    public void testCheckBalance() {
        assertEquals(1000, account1.checkBalance());
    }

    @Test
    public void testTransfer() {
        assertTrue(account1.transfer(400, account2));
        assertEquals(600, account1.checkBalance());
        assertEquals(900, account2.checkBalance());
        assertFalse(account1.transfer(1000, account2));
}
}
