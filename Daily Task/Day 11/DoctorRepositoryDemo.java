
public class DoctorRepositoryDemo {
    public static void main(String[] args) {
        DoctorRepository repository = new DoctorRepository();

        repository.save(new Doctor(201, "Dr. Kumar", "Cardiology"));
        repository.save(new Doctor(202, "Dr. Priya", "Neurology"));

        System.out.println("Doctor 201: " + repository.findById(201));
        System.out.println("Total doctors: " + repository.count());

        repository.deleteById(202);

        System.out.println("After deletion: " + repository.count());
    }
}
