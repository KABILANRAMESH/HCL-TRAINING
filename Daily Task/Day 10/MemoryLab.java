
public class MemoryLab {

    // Experiment 1: StackOverflowError
    static int count = 0;

    static void recursiveMethod() {
        count++;
        recursiveMethod();
    }

    static void stackExperiment() {
        try {
            recursiveMethod();
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError occurred!");
            System.out.println("Recursion depth: " + count);
        }
    }

    // Experiment 2: OutOfMemoryError
    static void memoryExperiment() {
        try {
            java.util.List<byte[]> list = new java.util.ArrayList<>();

            while (true) {
                list.add(new byte[1024 * 1024]);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemoryError occurred!");
        }
    }

    // Experiment 3: String vs StringBuilder
    static void stringExperiment() {
        int n = 20000;

        long start = System.nanoTime();
        String str = "";

        for (int i = 0; i < n; i++) {
            str += "A";
        }

        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append("A");
        }

        long builderTime = System.nanoTime() - start;

        System.out.println("String time: " + stringTime / 1_000_000 + " ms");
        System.out.println("StringBuilder time: " + builderTime / 1_000_000 + " ms");
    }

    // Experiment 4: Integer cache
    static void integerExperiment() {
        Integer a = 127;
        Integer b = 127;

        Integer x = 128;
        Integer y = 128;

        System.out.println("127 comparison: " + (a == b));
        System.out.println("128 comparison: " + (x == y));
        System.out.println("128 equals: " + x.equals(y));
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Choose experiment:");
            System.out.println("stack");
            System.out.println("memory");
            System.out.println("string");
            System.out.println("integer");
            return;
        }

        switch (args[0]) {
            case "stack":
                stackExperiment();
                break;

            case "memory":
                memoryExperiment();
                break;

            case "string":
                stringExperiment();
                break;

            case "integer":
                integerExperiment();
                break;

            default:
                System.out.println("Invalid experiment");
        }
    }
}
