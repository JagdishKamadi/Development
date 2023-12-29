package dip.problem;

// now this is completely depending upon the credit card
// this is also the tight couple
// what if credit card expires
// then this won't work
// and even if we want to try the different cards
public class ShoppingMall {

    private CreditCard creditCard;

    ShoppingMall(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void purchase() {
        creditCard.doTransaction();
    }

    public static void main(String[] args) {

        CreditCard creditCard = new CreditCard();
        ShoppingMall shoppingMall = new ShoppingMall(creditCard);
        shoppingMall.purchase();

    }
}
