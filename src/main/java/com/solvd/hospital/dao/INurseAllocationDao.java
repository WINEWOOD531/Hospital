package com.solvd.hospital.dao;

import com.solvd.hospital.models.NurseAllocationModel;
import com.solvd.hospital.models.NursesModel;

public interface INurseAllocationDao {

    void createNurses(NurseAllocationModel nurseAllocation);

    void updateNursesById(int id);

    void deleteNursesById(int id);

    INurseAllocationDao getNurseAllocationById(int id);

}
