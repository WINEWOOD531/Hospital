package com.solvd.hospital.dao.jdbcMySQLImpl;

import com.solvd.hospital.dao.IBillDao;
import com.solvd.hospital.models.BillModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BillDao implements IBillDao {

    private static final Logger LOGGER = LogManager.getLogger(BillDao.class);


    @Override
    public void createBill(BillModel bill) {

    }

    @Override
    public void updateBillByPatientId(int id) {

    }

    @Override
    public void deleteBillByPatientId(int id) {

    }

    @Override
    public IBillDao getBillByPatientId(int id) {
        return null;
    }
}
