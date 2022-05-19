package com.solvd.hospital.dao;

import com.solvd.hospital.models.RoomsModel;

import java.util.ArrayList;

public interface IRoomsDao {

    void createRoom(RoomsModel roomsModel);

    void updateRoom(RoomsModel roomsModel);

    void deleteRoomById(RoomsModel roomsModel);

    RoomsModel getRoomById(int id);
}
