package payment;

public class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    protected void processPayment() {
        System.out.println("Processing cash payment...");
        System.out.println("Amount paid: ₹" + amount);
        System.out.println("Cash payment successful!");
    }
}
