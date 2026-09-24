package com.medislot.dao;

import com.medislot.config.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDAO {

    public boolean bookAppointment(int patientId, int doctorId,
                                   LocalDate date, LocalTime time) {
        String checkSql = """
                SELECT COUNT(*) FROM appointments
                WHERE doctor_id = ?
                  AND appointment_date = ?
                  AND appointment_time = ?
                  AND status = 'BOOKED'
                """;

        String insertSql = """
                INSERT INTO appointments
                (patient_id, doctor_id, appointment_date, appointment_time, status)
                VALUES (?, ?, ?, ?, 'BOOKED')
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement check = con.prepareStatement(checkSql);
             PreparedStatement insert = con.prepareStatement(insertSql)) {

            check.setInt(1, doctorId);
            check.setDate(2, Date.valueOf(date));
            check.setTime(3, Time.valueOf(time));

            try (ResultSet rs = check.executeQuery()) {
                rs.next();
                if (rs.getInt(1) > 0) {
                    return false;
                }
            }

            insert.setInt(1, patientId);
            insert.setInt(2, doctorId);
            insert.setDate(3, Date.valueOf(date));
            insert.setTime(4, Time.valueOf(time));

            return insert.executeUpdate() == 1;

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            return false;
        }
    }

    public void listAppointments() {
        String sql = """
                SELECT a.id, p.name AS patient, d.name AS doctor,
                       d.specialization, a.appointment_date,
                       a.appointment_time, a.status
                FROM appointments a
                JOIN patients p ON a.patient_id = p.id
                JOIN doctors d ON a.doctor_id = d.id
                ORDER BY a.appointment_date, a.appointment_time
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.printf(
                        "#%d | %s | %s (%s) | %s %s | %s%n",
                        rs.getInt("id"),
                        rs.getString("patient"),
                        rs.getString("doctor"),
                        rs.getString("specialization"),
                        rs.getDate("appointment_date"),
                        rs.getTime("appointment_time"),
                        rs.getString("status")
                );
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
