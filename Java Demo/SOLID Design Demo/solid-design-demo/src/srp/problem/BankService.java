package srp.problem;

public class BankService {
    public long deposit(final long amount) {
        return 0;
    }

    public long withdraw(final long withdrawAmount) {
        return 0;
    }

    public void printPassbook() {
        System.out.println("Passbook Details");
    }

    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("Home Loan")) {

        } else if (loanType.equals("Personal Loan")) {

        } else if (loanType.equals("Car Loan")) {

        }
    }

    public void sentOTP(String medium) {
        if (medium.equals("email")) {

        }
    }
}
