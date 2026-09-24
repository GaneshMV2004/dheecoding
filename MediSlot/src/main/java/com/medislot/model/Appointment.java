package com.medislot.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private final int id;
    private final int patientId;
    private final int doctorId;
    private final LocalDate date;
    private final LocalTime time;
    private final String status;

    public Appointment(int id, int patientId, int doctorId,
                       LocalDate date, LocalTime time, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
}
