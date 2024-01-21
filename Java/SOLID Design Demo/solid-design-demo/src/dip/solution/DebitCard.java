package dip.solution;

public class DebitCard implements Card {
    @Override
    public void doTransaction() {
        System.out.println("Transaction done using the debit card");
    }
}
