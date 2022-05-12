package com.solvd.hospital.dao;

import com.solvd.hospital.models.AppointmentModel;
import com.solvd.hospital.models.DoctorsModel;

import java.util.List;

public interface IAppointmentDao {

    //void createAppointment(AppointmentModel appointmentModel);
    void createAppointment(int id, String appointmentDate, int doctorsModelId, int patientModelId);

    void updateAppointment(String appointmentDate,int id);

    void deleteAppointmentById(int id);

    List<AppointmentModel>  getAppointmentByDoctorId(int id);
}
