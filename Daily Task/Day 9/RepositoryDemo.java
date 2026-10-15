
public class RepositoryDemo {
    public static void main(String[] args) {
        InMemoryRepository<String, Integer> patients =
                new InMemoryRepository<>();

        patients.save(101, "Arun");
        patients.save(102, "Bala");

        System.out.println("Patient 101: "
                + patients.findById(101));

        System.out.println("Total patients: "
                + patients.count());

        patients.deleteById(102);

        System.out.println("After deletion: "
                + patients.count());
    }
}
