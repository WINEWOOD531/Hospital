package com.solvd.hospital.abstractFactory;

public class NursesFactory implements IMedicinesWorkersAbstractFactory{
    @Override
    public ISurgery createSurgery() {
        return new NurseSurgeon();
    }

    @Override
    public IOphthalmology createOphthalmology() {
        return new NurseOphthalmologist();
    }
}
