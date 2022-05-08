package com.solvd.hospital.dao;

import com.solvd.hospital.models.AppointmentModel;

public interface IAppointmentDao {

    void createAppointment(int id,String appointmentDate,int doctorsId,int patientsId);

    void updateAppointment(String appointmentDate,int id);

    void deleteAppointmentById(int id);

    AppointmentModel getAppointmentByDoctorId(int id);
}
