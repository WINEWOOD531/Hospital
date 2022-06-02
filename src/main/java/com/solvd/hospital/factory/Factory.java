package com.solvd.hospital.factory;

public class Factory {

    public IHuman getHuman(String inputHuman) {
        IHuman human = null;
        if (inputHuman.equals("patient")) {
            human = new Patient();
        } else if (inputHuman.equals("nurse")) {
            human = new Nurse();
        } else if (inputHuman.equals("doctor")) {
            human = new Doctor();
        }
        return human;
    }
}
