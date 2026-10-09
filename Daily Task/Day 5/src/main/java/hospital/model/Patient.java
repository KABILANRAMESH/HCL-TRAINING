package hospital.model;

public class Patient extends BaseEntity {

    private final String name;
    private final int age;

    public Patient(int id, String name, int age) {
        super(id);

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }

        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getEntityType() {
        return "Patient";
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createdAt=" + getCreatedAt() +
                '}';
    }
}
