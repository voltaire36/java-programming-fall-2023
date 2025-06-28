import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];

        System.out.print("Enter the current prime interest rate: ");
        double currentPrimeInterestRate = scanner.nextDouble();

        for (int i = 0; i < mortgages.length; i++) {
            System.out.print("Enter mortgage type (Business=1/Personal=2): ");

            int type = scanner.nextInt();
            System.out.print("Enter mortgage number: ");

            int number = scanner.nextInt();
            System.out.print("Enter customer name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Enter mortgage amount: ");

            double amount = scanner.nextDouble();
            System.out.print("Enter term (1=Short-term, 3=Medium-term, 5=Long-term): ");
            int term = scanner.nextInt();

            if (type == 1) {
                mortgages[i] = new BusinessMortgage(number, name, amount, currentPrimeInterestRate, term);
            } else {
                mortgages[i] = new PersonalMortgage(number, name, amount, currentPrimeInterestRate, term);
            }
        }

        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
            System.out.println("Total Owed: " + mortgage.calculateTotalOwed());
            System.out.println("------------------------");
        }

        scanner.close();
    }
}




