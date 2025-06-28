public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(int mortgageNumber, String customerName, double amount, double primeInterestRate, int term) {
        super(mortgageNumber, customerName, amount, primeInterestRate + 1, term);
    }
}