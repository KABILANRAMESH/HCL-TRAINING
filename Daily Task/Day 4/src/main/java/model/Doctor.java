package model;

import java.util.Objects;

public class Doctor {

    private final int doctorId;
    private String name;
    private String specialization;
    private String department;

    public Doctor(int doctorId, String name, String specialization, String department) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.department = department;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return doctorId == doctor.doctorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}