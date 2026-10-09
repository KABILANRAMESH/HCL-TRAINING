package payment;

public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Payment amount must be greater than zero."
            );
        }

        this.amount = amount;
    }

    // Method overloading
    public void pay() {
        processPayment();
    }

    public void pay(String reference) {
        System.out.println("Payment reference: " + reference);
        processPayment();
    }

    // Subclasses must implement this method
    protected abstract void processPayment();

    public double getAmount() {
        return amount;
    }
}
