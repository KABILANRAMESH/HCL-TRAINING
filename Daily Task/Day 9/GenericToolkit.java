
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pair<K, V> {
    private final K key;
    private final V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    void display() {
        System.out.println(key + " : " + value);
    }
}

class Box<T extends Number> {
    private final T value;

    Box(T value) {
        this.value = value;
    }

    void display() {
        System.out.println("Number: " + value);
    }
}

class GenericMethods {
    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static void printNumbers(List<? extends Number> values) {
        for (Number value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void addNumbers(List<? super Integer> values) {
        values.add(10);
        values.add(20);
    }
}

class ResourceDemo implements AutoCloseable {
    private final String name;

    ResourceDemo(String name) {
        this.name = name;
        System.out.println(name + " opened");
    }

    @Override
    public void close() {
        System.out.println(name + " closed");
    }
}

public class GenericToolkit {
    public static void main(String[] args) {
        System.out.println("=== Pair ===");
        Pair<Integer, String> pair = new Pair<>(101, "Arun");
        pair.display();

        System.out.println("\n=== Box ===");
        Box<Double> box = new Box<>(95.5);
        box.display();

        System.out.println("\n=== Maximum ===");
        System.out.println(GenericMethods.max(10, 25));

        System.out.println("\n=== Wildcards ===");
        GenericMethods.printNumbers(Arrays.asList(10, 20, 30));

        List<Number> numbers = new ArrayList<>();
        GenericMethods.addNumbers(numbers);
        System.out.println("Added numbers: " + numbers);

        System.out.println("\n=== CSV File ===");
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("Daily Task/Day 9/products.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("CSV file error: " + e.getMessage());
        }

        System.out.println("\n=== Resource Closing ===");
        try (ResourceDemo first = new ResourceDemo("First");
             ResourceDemo second = new ResourceDemo("Second")) {
            System.out.println("Using resources");
        }

        System.out.println("\nDay 9 completed.");
    }
}
