package dip.solution;

public class CreditCard implements Card {
    @Override
    public void doTransaction() {
        System.out.println("Transaction done using the credit card");
    }
}
