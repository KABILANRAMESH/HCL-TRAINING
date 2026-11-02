
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        if (students.contains(student)) {
            throw new IllegalArgumentException("Student already exists");
        }

        students.add(student);
    }

    public Student findStudentById(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean removeStudent(int id) {
        return students.removeIf(student -> student.getId() == id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
