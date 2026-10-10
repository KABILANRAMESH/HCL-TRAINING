package com.hospital;

import com.hospital.exception.AppointmentConflictException;
import com.hospital.exception.InvalidAppointmentException;

public class AppointmentServiceDemo {

    public static void main(String[] args) {
        AppointmentService service = new AppointmentService();

        // Test 1: Valid booking
        try {
            service.bookAppointment("P101", "2026-10-12-10AM");
        } catch (InvalidAppointmentException | AppointmentConflictException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        // Test 2: Invalid patient ID
        try {
            service.bookAppointment("", "2026-10-12-11AM");
        } catch (InvalidAppointmentException | AppointmentConflictException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        // Test 3: Duplicate slot
        try {
            service.bookAppointment("P102", "2026-10-12-10AM");
        } catch (InvalidAppointmentException | AppointmentConflictException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }

        System.out.println("Demo completed. The program continues after errors.");
    }
}