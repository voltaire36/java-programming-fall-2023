public abstract class Insurance {
    private String insuranceType;
    private double monthlyCost;

    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    protected void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public abstract void setInsuranceCost(double cost);
    public abstract void displayInfo();
}
