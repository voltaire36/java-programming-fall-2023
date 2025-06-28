
public abstract class Mortgage implements MortgageConstants {
    protected int mortgageNumber;
    protected String customerName;
    protected double mortgageAmount;
    protected double interestRate;
    protected int term;

    public Mortgage(int mortgageNumber, String customerName, double amount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.interestRate = interestRate;
        if (amount > MAX_MORTGAGE_AMOUNT) {
            throw new IllegalArgumentException("Mortgage amount cannot exceed " + MAX_MORTGAGE_AMOUNT);
        }
        this.mortgageAmount = amount;
        this.term = (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM) ? term : SHORT_TERM;
    }

    public String getMortgageInfo() {
        return "Mortgage Number: " + mortgageNumber +
                "\nCustomer Name: " + customerName +
                "\nMortgage Amount: " + mortgageAmount +
                "\nInterest Rate: " + interestRate +
                "\nTerm: " + term;
    }

    public double calculateTotalOwed() {
        return mortgageAmount + (mortgageAmount * (interestRate / 100) * term);
    }
}