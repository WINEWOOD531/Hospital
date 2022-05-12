package com.solvd.hospital.dao;

import com.solvd.hospital.models.BillModel;

import java.util.List;

public interface IBillDao {

    void createBill(int id,Double sum,String paymentDate,int patientId);

    void updateBill(Double sum, int id);

    void deleteBillByPatientId(int id);

    List<BillModel> getBillByPatientId(int id);
}
