
import java.util.*;
import java.util.function.*;

public class FilterEngine {

    // Product model
    static class Product {
        private int id;
        private String name;
        private String category;
        private double price;
        private boolean inStock;

        public Product(int id, String name, String category,
                       double price, boolean inStock) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
            this.inStock = inStock;
        }

        public double getPrice() {
            return price;
        }

        public String getCategory() {
            return category;
        }

        public boolean isInStock() {
            return inStock;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return id + " | " + name + " | " + category
                    + " | Rs." + price + " | In Stock: " + inStock;
        }
    }

    // Custom functional interface
    @FunctionalInterface
    interface ProductValidator {
        boolean validate(Product product);
    }

    // Static method for method reference
    static boolean isAffordable(Product product) {
        return product.getPrice() <= 2000;
    }

    // Instance method for method reference
    void printProduct(Product product) {
        System.out.println(product);
    }

    public static void main(String[] args) {

        // 1. Create products
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", "Electronics", 55000, true),
                new Product(2, "Mouse", "Electronics", 750, true),
                new Product(3, "Keyboard", "Electronics", 1500, false),
                new Product(4, "Chair", "Furniture", 3000, true),
                new Product(5, "Notebook", "Stationery", 100, true)
        );

        // 2. Lambda expression
        Predicate<Product> lowPrice =
                p -> p.getPrice() <= 2000;

        // 3. Predicate composition
        Predicate<Product> electronics =
                p -> p.getCategory().equals("Electronics");

        Predicate<Product> available =
                Product::isInStock;

        Predicate<Product> finalFilter =
                lowPrice.and(electronics).and(available);

        System.out.println("=== FILTERED PRODUCTS ===");

        products.stream()
                .filter(finalFilter)
                .forEach(System.out::println);

        // 4. Predicate or() and negate()
        Predicate<Product> expensive =
                p -> p.getPrice() > 2000;

        System.out.println("\n=== EXPENSIVE PRODUCTS ===");

        products.stream()
                .filter(expensive.or(electronics.negate()))
                .forEach(System.out::println);

        // 5. Function transformation
        Function<Product, String> getName =
                Product::getName;

        Function<String, String> uppercase =
                String::toUpperCase;

        Function<Product, String> nameTransformation =
                getName.andThen(uppercase);

        System.out.println("\n=== PRODUCT NAMES ===");

        products.stream()
                .map(nameTransformation)
                .forEach(System.out::println);

        // 6. Function compose()
        Function<Integer, Integer> multiplyByTwo =
                n -> n * 2;

        Function<Integer, Integer> addFive =
                n -> n + 5;

        System.out.println("\nCompose result: "
                + multiplyByTwo.compose(addFive).apply(10));

        // 7. Consumer
        Consumer<Product> display =
                p -> System.out.println(p.getName());

        System.out.println("\n=== CONSUMER ===");

        products.forEach(display);

        // 8. Supplier
        Supplier<Product> defaultProduct =
                () -> new Product(
                        6, "Pen", "Stationery", 20, true);

        System.out.println("\n=== DEFAULT PRODUCT ===");
        System.out.println(defaultProduct.get());

        // 9. Custom functional interface
        ProductValidator validator =
                p -> p.getPrice() < 5000;

        System.out.println("\n=== CUSTOM VALIDATOR ===");

        products.stream()
                .filter(validator::validate)
                .forEach(System.out::println);

        // 10. Method reference examples
        System.out.println("\n=== METHOD REFERENCES ===");

        // Static method reference
        products.stream()
                .filter(FilterEngine::isAffordable)
                .forEach(System.out::println);

        // Bound instance method reference
        FilterEngine engine = new FilterEngine();

        products.forEach(engine::printProduct);

        // Unbound instance method reference
        Function<Product, String> productName =
                Product::getName;

        System.out.println(productName.apply(products.get(0)));

        // Constructor reference
        Supplier<ArrayList<Product>> listSupplier =
                ArrayList::new;

        List<Product> newList = listSupplier.get();

        newList.addAll(products);

        System.out.println("New list size: " + newList.size());

        // 11. Effectively final variable
        double maximumPrice = 2000;

        Predicate<Product> priceCheck =
                p -> p.getPrice() <= maximumPrice;

        System.out.println("\n=== EFFECTIVELY FINAL ===");

        products.stream()
                .filter(priceCheck)
                .forEach(System.out::println);
    }
}
