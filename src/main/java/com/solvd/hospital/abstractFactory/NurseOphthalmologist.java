package com.solvd.hospital.abstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NurseOphthalmologist implements IOphthalmology {
    private static final Logger LOGGER = LogManager.getLogger(NurseOphthalmologist.class);

    public NurseOphthalmologist() {
        LOGGER.info("Create Nurse Ophthalmologist");
    }
}
