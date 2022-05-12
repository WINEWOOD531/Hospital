package com.solvd.hospital.dao;

import com.solvd.hospital.models.NurseAllocationModel;

import java.util.ArrayList;

public interface INurseAllocationDao {

    void createNurseAllocation(int id,String dateIn,String dateOut,int nursesId,int doctorsId,int personId);

    void updateNursesAllocation(String dateIn,int id);

    void deleteNursesAllocationById(int id);

    ArrayList<NurseAllocationModel> getNurseAllocationById(int id);

}
