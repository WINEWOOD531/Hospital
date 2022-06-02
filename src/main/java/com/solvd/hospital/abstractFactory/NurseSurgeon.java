package com.solvd.hospital.abstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NurseSurgeon implements ISurgery {
    private static final Logger LOGGER = LogManager.getLogger(NurseSurgeon.class);

    public NurseSurgeon() {
        LOGGER.info("Create Nurse Surgeon");
    }
}
