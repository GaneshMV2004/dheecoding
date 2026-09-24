package com.medislot;

import com.medislot.dao.AppointmentDAO;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        System.out.println("=== MediSlot ===");
        System.out.println("Booking sample appointment...");

        boolean booked = appointmentDAO.bookAppointment(
                1,
                1,
                LocalDate.now().plusDays(1),
                LocalTime.of(10, 0)
        );

        System.out.println(booked
                ? "Appointment booked successfully."
                : "Appointment could not be booked. Check patient ID, doctor ID, or slot availability.");

        System.out.println("\nAppointments:");
        appointmentDAO.listAppointments();
    }
}
