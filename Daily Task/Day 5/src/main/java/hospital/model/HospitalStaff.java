package hospital.model;

public abstract class HospitalStaff {

    private final int staffId;
    protected String name;

    public HospitalStaff(int staffId, String name) {
        this.staffId = staffId;
        this.name = name;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public abstract String getRole();

    public void displayDetails() {
        System.out.println("Staff ID: " + staffId);
        System.out.println("Name: " + name);
        System.out.println("Role: " + getRole());
    }
}
