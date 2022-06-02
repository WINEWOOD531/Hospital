package com.solvd.hospital.abstractFactory;

public class DoctorsFactory implements IMedicinesWorkersAbstractFactory{
    @Override
    public ISurgery createSurgery() {
        return new  DrSurgeon();
    }

    @Override
    public IOphthalmology createOphthalmology() {
        return new DrOphthalmologist();
    }
}
