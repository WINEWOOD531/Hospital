package com.solvd.hospital.dao;

import com.solvd.hospital.models.RoomsModel;

public interface IRoomsDao {

    void createRoom(RoomsModel rooms);

    void updateRoomById(int id);

    void deleteRoomById(int id);

    IRoomsDao getRoomByPatientId(int id);
}
