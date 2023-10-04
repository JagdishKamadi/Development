package pattern.design.behavioral.stategy;

public class Creditcard implements PaymentMethod{
    final private String cardHolderName;
    final private String cardNumber;
    final private String cvv;
    final private String expiry;

    public Creditcard(String cardHolderName, String cardNumber, String cvv, String expiry) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiry = expiry;
    }

    public void pay(double amount)
    {
        System.out.println(amount+" paid by using card holder name : "+cardHolderName);
    }
}
