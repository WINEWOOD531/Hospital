package com.solvd.hospital.dao;

import com.solvd.hospital.models.AppointmentModel;
import com.solvd.hospital.models.DoctorsModel;

import java.util.List;

public interface IAppointmentDao {

    void createAppointment(AppointmentModel appointmentModel);

    void updateAppointment(AppointmentModel appointmentModel);

    void deleteAppointmentById(AppointmentModel appointmentModel);

    AppointmentModel getAppointmentById(int id);
}
