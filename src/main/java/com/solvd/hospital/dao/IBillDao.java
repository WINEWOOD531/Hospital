package com.solvd.hospital.dao;

import com.solvd.hospital.models.BillModel;

import java.util.List;

public interface IBillDao {


    void createBill(BillModel billModel);

    void updateBill(BillModel billModel);

    void deleteBillByPatientId(BillModel billModel);

    BillModel getBillById(int id);
}
