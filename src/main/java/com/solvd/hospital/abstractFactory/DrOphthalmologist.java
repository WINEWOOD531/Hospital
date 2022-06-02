package com.solvd.hospital.abstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DrOphthalmologist implements IOphthalmology {
    private static final Logger LOGGER = LogManager.getLogger(DrOphthalmologist.class);

    public DrOphthalmologist() {
        LOGGER.info("Create Dr.Ophthalmologist");
    }
}
