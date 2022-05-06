package com.solvd.hospital.dao;

import com.solvd.hospital.models.BillModel;

public interface IBillDao {

    void createBill(BillModel bill);

    void updateBillByPatientId(int id);

    void deleteBillByPatientId(int id);

    IBillDao getBillByPatientId(int id);
}
