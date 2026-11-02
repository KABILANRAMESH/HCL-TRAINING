
public class StudentDemo {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        service.addStudent(new Student(101, "Arun", "ECE"));
        service.addStudent(new Student(102, "Bala", "CSE"));

        System.out.println("All Students:");
        service.getAllStudents().forEach(System.out::println);

        System.out.println("\nSearch Student 101:");
        System.out.println(service.findStudentById(101));

        System.out.println("\nRemove Student 102:");
        System.out.println(service.removeStudent(102));

        System.out.println("\nRemaining Students:");
        service.getAllStudents().forEach(System.out::println);
    }
}
