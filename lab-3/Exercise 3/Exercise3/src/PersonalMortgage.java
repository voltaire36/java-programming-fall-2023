
public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(int mortgageNumber, String customerName, double amount, double primeInterestRate, int term) {
        super(mortgageNumber, customerName, amount, primeInterestRate + 2, term);
    }
}

