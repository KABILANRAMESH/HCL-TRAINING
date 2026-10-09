package hospital.model;

public class Receptionist extends HospitalStaff {

    public Receptionist(int staffId, String name) {
        super(staffId, name);
    }

    @Override
    public String getRole() {
        return "Receptionist";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Responsibility: Patient registration and appointments");
    }
}
