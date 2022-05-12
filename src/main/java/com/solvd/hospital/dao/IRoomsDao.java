package com.solvd.hospital.dao;

import com.solvd.hospital.models.RoomsModel;

import java.util.ArrayList;

public interface IRoomsDao {

    void createRoom(int id, String roomNumber, String departmentName, String dateIn, String dateOut, int patientId);

    void updateRoom(String dateIn, int id);

    void deleteRoomById(int id);

    ArrayList<RoomsModel> getRoomByDepartmentName(String name);
}
