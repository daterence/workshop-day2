package workshop.day2;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {

    @Test
    public void testGetBalance(){
        BankAccount account = new BankAccount("John Smith", 123.45f);
        assertTrue(account.getAccountBalance()==123.45f);
        System.out.println("testGetBalance successful");
    }

    @Test
    public void testDeposit(){
        BankAccount account = new BankAccount("John Smith", 12.00f);
        account.deposit(2.00f);
        assertTrue(account.getAccountBalance() == 24.00f);
        System.out.println("testDeposit successful");
    }
}
