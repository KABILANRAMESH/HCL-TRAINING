public class MonthlyUsageAnalyser {

    public static void main(String[] args) {

        // 1-D array: usage for 12 months
        int[] monthlyUsage = {
            120, 150, 180, 200,
            250, 300, 280, 220,
            190, 170, 160, 140
        };

        int total = 0;
        int maximum = monthlyUsage[0];
        int minimum = monthlyUsage[0];

        // Calculate total, maximum and minimum
        for (int usage : monthlyUsage) {
            total += usage;

            if (usage > maximum) {
                maximum = usage;
            }

            if (usage < minimum) {
                minimum = usage;
            }
        }

        // Widening cast: int -> double
        double average = (double) total / Constants.MONTHS;

        // Ternary operator for grade
        char grade = average >= Constants.GRADE_A_LIMIT ? 'A'
                   : average >= Constants.GRADE_B_LIMIT ? 'B'
                   : average >= Constants.GRADE_C_LIMIT ? 'C'
                   : 'D';

        // Slab calculation
        int sampleUsage = Constants.SAMPLE_USAGE;
        int bill;

        if (sampleUsage <= Constants.SLAB_LIMIT) {
            bill = sampleUsage * Constants.SLAB_RATE_1;
        } else {
            bill = (Constants.SLAB_LIMIT * Constants.SLAB_RATE_1)
                 + ((sampleUsage - Constants.SLAB_LIMIT)
                 * Constants.SLAB_RATE_2);
        }

        // Integer overflow demonstration
        int intOverflow = Integer.MAX_VALUE;
        intOverflow = intOverflow + 1;

        // Fixed using long
        long safeValue = (long) Integer.MAX_VALUE + 1;

        // 2-D array for 3 houses
        int[][] houseUsage = {
            {120, 150, 180, 200, 250, 300, 280},
            {100, 130, 160, 190, 220, 250, 270},
            {140, 170, 200, 230, 260, 290, 310}
        };

        System.out.println("===== Monthly Usage Analyser =====");

        System.out.println("\nMonthly Usage:");

        for (int month = 0; month < monthlyUsage.length; month++) {
            System.out.println(
                "Month " + (month + 1) + ": " + monthlyUsage[month]
            );
        }

        System.out.println("\nTotal Usage: " + total);
        System.out.println("Average Usage: " + average);
        System.out.println("Maximum Usage: " + maximum);
        System.out.println("Minimum Usage: " + minimum);
        System.out.println("Grade: " + grade);

        System.out.println("\nSample Slab Bill:");
        System.out.println("Usage: " + sampleUsage);
        System.out.println("Bill: " + bill);

        System.out.println("\nInteger Overflow:");
        System.out.println("int overflow value: " + intOverflow);
        System.out.println("long safe value: " + safeValue);

        System.out.println("\n2-D Array - 3 Houses:");

        for (int house = 0; house < houseUsage.length; house++) {
            System.out.print("House " + (house + 1) + ": ");

            for (int day = 0; day < houseUsage[house].length; day++) {
                System.out.print(houseUsage[house][day] + " ");
            }

            System.out.println();
        }
    }
}