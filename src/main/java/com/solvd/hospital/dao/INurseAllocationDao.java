package com.solvd.hospital.dao;

import com.solvd.hospital.models.NurseAllocationModel;

public interface INurseAllocationDao {

    void createNurseAllocation(int id,String dateIn,String dateOut,int nursesId,int doctorsId,int personId);

    void updateNursesAllocation(String dateIn,int id);

    void deleteNursesAllocationById(int id);

    NurseAllocationModel getNurseAllocationById(int id);

}
