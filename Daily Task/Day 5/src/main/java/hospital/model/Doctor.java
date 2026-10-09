package hospital.model;

public class Doctor extends HospitalStaff {

    private final String specialization;

    public Doctor(int staffId, String name, String specialization) {
        super(staffId, name);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialization: " + specialization);
    }
}
