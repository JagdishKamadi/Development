package pattern.design.behavioral.stategy;
public class PhonePay implements PaymentMethod{
    final private String username;
    final private String email;
    final private String password;

    public PhonePay(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void pay(double amount)
    {
        System.out.println(amount+" paid by "+username);
    }
}
