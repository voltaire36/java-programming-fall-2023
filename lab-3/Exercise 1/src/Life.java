public class Life extends Insurance {

    public Life() {
        super("Life");
    }

    @Override
    public void setInsuranceCost(double cost) {
        setMonthlyCost(cost);
    }

    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + getInsuranceType() +
                "\nMonthly Cost: $" + getMonthlyCost());
    }
}
