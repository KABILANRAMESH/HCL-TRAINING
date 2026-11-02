
import java.util.Objects;

public class Student {
    private final int id;
    private String name;
    private String department;

    public Student(int id, String name, String department) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid student ID");
        }

        this.id = id;
        setName(name);
        setDepartment(department);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }
        this.department = department;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student student = (Student) obj;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{id=" + id +
                ", name='" + name +
                "', department='" + department + "'}";
    }
}
