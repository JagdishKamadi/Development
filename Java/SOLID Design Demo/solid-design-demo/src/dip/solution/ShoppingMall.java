package dip.solution;

// so now we can easily replace  any cards with parent class or interface
// so this not the tight couple now
public class ShoppingMall {

    private Card card;

    ShoppingMall(Card card) {
        this.card = card;
    }

    public void purchase() {
        card.doTransaction();
    }

    public static void main(String[] args) {

        Card creditCard = new CreditCard();
        Card debitCard = new DebitCard();
        ShoppingMall shoppingMall1 = new ShoppingMall(creditCard);
        shoppingMall1.purchase();

        ShoppingMall shoppingMall2 = new ShoppingMall(debitCard);
        shoppingMall2.purchase();

    }
}
