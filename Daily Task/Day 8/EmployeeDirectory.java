
import java.util.*;

class Employee implements Comparable<Employee> {
    private final int id;
    private final String name;
    private final String department;
    private final double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Natural ordering: employee ID
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    // Employees are equal when their IDs are equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;

        Employee other = (Employee) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department
                + " - Rs." + salary;
    }
}

public class EmployeeDirectory {

    public static void main(String[] args) {

        // 1. HashMap: Employee lookup by ID
        Map<Integer, Employee> employeeMap = new HashMap<>();

        employeeMap.put(103, new Employee(
                103, "Kumar", "Cardiology", 45000));
        employeeMap.put(101, new Employee(
                101, "Arun", "Neurology", 60000));
        employeeMap.put(105, new Employee(
                105, "Priya", "Cardiology", 75000));
        employeeMap.put(102, new Employee(
                102, "Bala", "Neurology", 50000));
        employeeMap.put(104, new Employee(
                104, "Divya", "Orthopedics", 80000));
        employeeMap.put(106, new Employee(
                106, "Ravi", "Orthopedics", 55000));

        System.out.println("1. EMPLOYEE DIRECTORY");
        for (Employee e : employeeMap.values()) {
            System.out.println(e);
        }

        System.out.println("\n2. EMPLOYEE LOOKUP");
        System.out.println(employeeMap.get(102));


        // 2. LinkedHashMap: Maintains insertion order
        Map<Integer, String> orderedEmployees =
                new LinkedHashMap<>();

        orderedEmployees.put(103, "Kumar");
        orderedEmployees.put(101, "Arun");
        orderedEmployees.put(102, "Bala");

        System.out.println("\n3. INSERTION ORDER");
        System.out.println(orderedEmployees);


        // 3. TreeMap: Sorted department report
        Map<String, Integer> departmentReport =
                new TreeMap<>();

        for (Employee e : employeeMap.values()) {
            departmentReport.merge(
                    e.getDepartment(), 1, Integer::sum);
        }

        System.out.println("\n4. DEPARTMENT REPORT");
        System.out.println(departmentReport);


        // 4. Frequency count using merge()
        Map<String, Integer> frequency = new HashMap<>();

        String[] visits = {
                "Cardiology", "Neurology", "Cardiology",
                "Orthopedics", "Neurology", "Cardiology"
        };

        for (String department : visits) {
            frequency.merge(department, 1, Integer::sum);
        }

        System.out.println("\n5. DEPARTMENT FREQUENCY");
        System.out.println(frequency);


        // 5. Comparable: Sort by employee ID
        List<Employee> byId =
                new ArrayList<>(employeeMap.values());

        Collections.sort(byId);

        System.out.println("\n6. SORTED BY EMPLOYEE ID");
        for (Employee e : byId) {
            System.out.println(e);
        }


        // 6. Comparator: Highest salary first, then name
        Comparator<Employee> salaryComparator =
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
                        .thenComparing(Employee::getName);

        List<Employee> topEmployees =
                new ArrayList<>(employeeMap.values());

        topEmployees.sort(salaryComparator);

        System.out.println("\n7. TOP 5 HIGHEST-PAID EMPLOYEES");
        topEmployees.stream()
                .limit(5)
                .forEach(System.out::println);


        // 7. equals() and hashCode() contract
        Employee first =
                new Employee(101, "Arun", "Neurology", 60000);

        Employee duplicate =
                new Employee(101, "Arun Updated", "Cardiology", 70000);

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(first);
        employeeSet.add(duplicate);

        System.out.println("\n8. EQUALS AND HASHCODE DEMO");
        System.out.println("Employees equal: "
                + first.equals(duplicate));
        System.out.println("Unique employees in set: "
                + employeeSet.size());

        System.out.println("\nDay 8 completed successfully.");
    }
}
