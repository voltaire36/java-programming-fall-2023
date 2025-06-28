
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000); // Initial balance
        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(account, 2000, true)); // Deposit
        transactions.add(new Transaction(account, 1500, false)); // Withdraw
        transactions.add(new Transaction(account, 3000, true)); // Deposit


        ExecutorService executor = Executors.newFixedThreadPool(3); // Thread pool

        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }



        System.out.println("Final Balance: " + account.getBalance());

    }
}


