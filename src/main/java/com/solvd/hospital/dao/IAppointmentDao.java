package com.solvd.hospital.dao;

import com.solvd.hospital.models.AppointmentModel;

public interface IAppointmentDao {

    void createAppointment(AppointmentModel appointment);

    void updateAppointmentById(int id);

    void deleteAppointmentById(int id);

    IAppointmentDao getAppointmentById(int id);
}
