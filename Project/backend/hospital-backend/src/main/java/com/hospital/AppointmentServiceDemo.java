
package com.hospital;

import com.hospital.exception.AppointmentConflictException;
import com.hospital.exception.InvalidAppointmentException;

public class AppointmentServiceDemo {

    public static void main(String[] args) {
        AppointmentService service = new AppointmentService();

        // Test 1: Book the first appointment.
        book(service, "P101", "2026-10-12-10AM");

        // Test 2: Book the second appointment.
        book(service, "P102", "2026-10-12-11AM");

        // Test 3: Invalid patient ID.
        book(service, "", "2026-10-12-12PM");

        // Test 4: Duplicate slot.
        book(service, "P103", "2026-10-12-10AM");

        // List: display appointments in booking order.
        System.out.println("\nAll appointments (List):");
        System.out.println(service.getAppointments());

        // Set: display unique booked slots.
        System.out.println("\nBooked slots (Set):");
        System.out.println(service.getBookedSlots());

        // Queue: display patients waiting for consultation.
        System.out.println("\nOPD waiting queue:");
        System.out.println(service.getWaitingPatients());

        // Queue: call patients in FIFO order.
        System.out.println("\nCalling next patients:");
        System.out.println("Next: " + service.callNextPatient());
        System.out.println("Next: " + service.callNextPatient());

        System.out.println("\nRemaining queue:");
        System.out.println(service.getWaitingPatients());

        System.out.println("\nDemo completed.");
    }

    private static void book(
            AppointmentService service,
            String patientId,
            String slot
    ) {
        try {
            service.bookAppointment(patientId, slot);
        } catch (InvalidAppointmentException
                 | AppointmentConflictException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}
