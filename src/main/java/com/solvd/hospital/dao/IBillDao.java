package com.solvd.hospital.dao;

public interface IBillDao {

    void createBill();

    void updateBillByPatientId();

    void deleteBillByPatientId();

    IBillDao getBillByPatientId();
}
