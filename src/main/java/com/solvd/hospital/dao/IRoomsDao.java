package com.solvd.hospital.dao;

import com.solvd.hospital.models.RoomsModel;

public interface IRoomsDao {

    void createRoom(int id, String roomNumber, String departmentName, String dateIn, String dateOut, int patientId);

    void updateRoom(String dateIn, int id);

    void deleteRoomById(int id);

    RoomsModel getRoomByDepartmentName(String name);
}
