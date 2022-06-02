package com.solvd.hospital.abstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DrSurgeon implements ISurgery {
    private static final Logger LOGGER = LogManager.getLogger(DrSurgeon.class);
    public DrSurgeon() {
        LOGGER.info("Create Dr.Surgeon");
    }
}
