import java.util.Scanner;


public class GameTesterApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the game tester:");
        String name = scanner.nextLine();
        System.out.println("Is the game tester full-time? (yes/no)");
        String fullTimeResponse = scanner.nextLine();
        GameTester tester;

        if ("yes".equalsIgnoreCase(fullTimeResponse)) {
            tester = new FullTimeGameTester(name);
        } else {
            System.out.println("Enter the number of hours the part-time game tester has worked:");
            int hours = scanner.nextInt();
            tester = new PartTimeGameTester(name, hours);
        }

        System.out.println("The salary is: $" + tester.calculateSalary());
        scanner.close();
    }
}





abstract class GameTester {
    protected String name;
    protected boolean isFullTime;

    public GameTester(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    public abstract double calculateSalary();
}

class FullTimeGameTester extends GameTester {
    private static final double BASE_SALARY = 3000.0;

    public FullTimeGameTester(String name) {
        super(name, true);
    }

    @Override
    public double calculateSalary() {
        return BASE_SALARY;
    }
}

class PartTimeGameTester extends GameTester {
    private static final double HOURLY_RATE = 20.0;
    private int hoursWorked;

    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * HOURLY_RATE;
    }
}

