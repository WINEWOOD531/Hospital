package com.solvd.hospital.dao;

import com.solvd.hospital.models.NurseAllocationModel;

import java.util.ArrayList;

public interface INurseAllocationDao {

    void createNurseAllocation(NurseAllocationModel nurseAllocationModel);

    void updateNursesAllocation(NurseAllocationModel nurseAllocationModel);

    void deleteNursesAllocationById(NurseAllocationModel nurseAllocationModel);

    ArrayList<NurseAllocationModel> getNurseAllocationById(int id);

}
