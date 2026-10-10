
package order;

public class OrderProcessor {

    private int availableStock = 10;

    public void processOrder(int quantity)
            throws InsufficientStockException {

        try {
            System.out.println("\nProcessing order for quantity: " + quantity);

            // Rule 1: Quantity must be positive
            if (quantity <= 0) {
                throw new InvalidQuantityException(
                        "Quantity must be greater than zero."
                );
            }

            // Rule 2: Requested quantity cannot exceed stock
            if (quantity > availableStock) {
                IllegalStateException cause = new IllegalStateException(
                        "Available stock is " + availableStock
                );

                throw new InsufficientStockException(
                        "Not enough stock for quantity " + quantity,
                        cause
                );
            }

            availableStock -= quantity;

            System.out.println("Order successful!");
            System.out.println("Remaining stock: " + availableStock);

        } catch (InsufficientStockException |
                 InvalidQuantityException exception) {

            System.out.println("Order failed: " + exception.getMessage());

            // Preserve and display the original cause, if present
            if (exception.getCause() != null) {
                System.out.println(
                        "Original cause: " + exception.getCause().getMessage()
                );
            }

            throw exception;

        } finally {
            System.out.println("AUDIT: Order processing attempt completed.");
        }
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public static void main(String[] args) {

        OrderProcessor processor = new OrderProcessor();

        int[] quantities = {3, 0, 15, 2};

        for (int quantity : quantities) {
            try {
                processor.processOrder(quantity);
            } catch (InsufficientStockException exception) {
                System.out.println("Handled stock exception in main.");
            } catch (InvalidQuantityException exception) {
                System.out.println("Handled quantity exception in main.");
            } finally {
                System.out.println("Main: Ready for the next order.");
            }
        }

        System.out.println(
                "\nFinal available stock: " + processor.getAvailableStock()
        );
    }
}
