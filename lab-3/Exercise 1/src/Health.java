public class Health extends Insurance {

    public Health() {
        super("Health");
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
