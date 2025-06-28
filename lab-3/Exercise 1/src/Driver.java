import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Insurance> insurances = new ArrayList<>();

        System.out.println("Enter the type of insurance (Health or Life) and its monthly fee. Type 'done' when finished.");

        while (true) {
            System.out.print("Type of insurance: ");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Monthly fee: ");
            String feeInput = scanner.nextLine();
            double fee;
            try {
                fee = Double.parseDouble(feeInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for the monthly fee.");
                continue;
            }

            Insurance insurance;
            if (type.equalsIgnoreCase("Health")) {
                insurance = new Health();
            } else if (type.equalsIgnoreCase("Life")) {
                insurance = new Life();
            } else {
                System.out.println("Invalid insurance type. Please enter 'Health' or 'Life'.");
                continue;
            }

            insurance.setInsuranceCost(fee);
            insurances.add(insurance);
        }

        System.out.println("\nInsurance Information:");
        for (Insurance insurance : insurances) {
            insurance.displayInfo();
            System.out.println();
        }

        scanner.close();
    }
}
