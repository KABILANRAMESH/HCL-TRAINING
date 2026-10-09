package payment;

public class CardPayment extends Payment implements Refundable {

    private final String cardHolder;

    public CardPayment(double amount, String cardHolder) {
        super(amount);
        this.cardHolder = cardHolder;
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing card payment...");
        System.out.println("Card holder: " + cardHolder);
        System.out.println("Amount paid: ₹" + amount);
        System.out.println("Card payment successful!");
    }

    @Override
    public void refund(double refundAmount) {
        if (refundAmount <= 0 || refundAmount > amount) {
            throw new IllegalArgumentException("Invalid refund amount.");
        }

        System.out.println("Card refund processed: ₹" + refundAmount);
    }
}
