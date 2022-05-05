package com.solvd.hospital.dao;

public interface IRoomsDao {

    void createRoom();

    void updateRoom();

    void deleteRoom();

    void getRoomByPatientId();
}
