package com.solvd.hospital.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Patient implements IHuman {
    private static final Logger LOGGER = LogManager.getLogger(Patient.class);

    @Override
    public void getHuman() {
        LOGGER.info("Using Patient");
    }
}
