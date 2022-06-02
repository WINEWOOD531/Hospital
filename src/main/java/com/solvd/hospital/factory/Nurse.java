package com.solvd.hospital.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Nurse implements IHuman {
    private static final Logger LOGGER = LogManager.getLogger(Nurse.class);

    @Override
    public void getHuman() {
        LOGGER.info("Using Nurse");
    }
}
