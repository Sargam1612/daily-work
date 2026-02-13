import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unitTestingBMS.Account;
import unitTestingBMS.BankService;
import unitTestingBMS.BankingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class BankServiceTest {
    BankService bank;

    @BeforeEach
    void setup() {
        bank = new BankService();
        bank.createAccount(1, "Sargam", 2000);

    }

    @Test
    void testDeposit() {
        bank.deposit(1, 200);
        assertEquals(2200, bank.getAccount(1).getBalance());
    }

    @Test
    void testWithdraw() {
        bank.withdraw(1, 200);
        assertEquals(1800, bank.getAccount(1).getBalance());
    }

    @Test
    void testInsufficientBalance() {
        assertThrowsExactly(BankingException.class, () -> bank.withdraw(1, 240000));
    }

    @Test
    void testDuplicateAccount() {
        assertThrowsExactly(BankingException.class, () -> bank.createAccount(1, "THIEF", 1200));
    }

    @Test
    void testAccountNumber() {
        int accountNumber = bank.getAccount(1).getAccountNumber();
        assertEquals(1, accountNumber);
    }

    @Test
    void testAccountHolderName() {
        assertEquals("TEST", bank.getAccount(1).getHolderName());
    }


}
