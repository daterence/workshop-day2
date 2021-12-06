package workshop.day2;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> transactions = new ArrayList<>();
        BankAccount account = new BankAccount("John Smith", 200);
        account.deposit(123.45f);
        System.out.println(account.getAccountBalance());
    }
}
