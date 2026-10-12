
package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionTiming {

    private static final int SIZE = 20000;

    public static void main(String[] args) {

        // Compare adding elements at the end.
        long arrayInsertTime = measureInsertion(new ArrayList<>());
        long linkedInsertTime = measureInsertion(new LinkedList<>());

        // Compare indexed access after filling the lists.
        List<Integer> arrayList = createArrayList();
        List<Integer> linkedList = createLinkedList();

        long arrayGetTime = measureIndexedAccess(arrayList);
        long linkedGetTime = measureIndexedAccess(linkedList);

        System.out.println("Collection Performance Comparison");
        System.out.println("---------------------------------");
        System.out.println("Elements: " + SIZE);
        System.out.println();
        System.out.printf("%-25s %15s%n", "Operation", "Time (ms)");
        System.out.printf("%-25s %15.3f%n",
                "ArrayList insertion", arrayInsertTime / 1_000_000.0);
        System.out.printf("%-25s %15.3f%n",
                "LinkedList insertion", linkedInsertTime / 1_000_000.0);
        System.out.printf("%-25s %15.3f%n",
                "ArrayList get(i)", arrayGetTime / 1_000_000.0);
        System.out.printf("%-25s %15.3f%n",
                "LinkedList get(i)", linkedGetTime / 1_000_000.0);
    }

    private static long measureInsertion(List<Integer> list) {
        long start = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }

        return System.nanoTime() - start;
    }

    private static List<Integer> createArrayList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }

        return list;
    }

    private static List<Integer> createLinkedList() {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }

        return list;
    }

    private static long measureIndexedAccess(List<Integer> list) {
        long start = System.nanoTime();
        long sum = 0;

        for (int i = 0; i < SIZE; i++) {
            sum += list.get(i);
        }

        long elapsed = System.nanoTime() - start;

        // Use the result so the reads contribute to observable work.
        if (sum < 0) {
            System.out.println(sum);
        }

        return elapsed;
    }
}
