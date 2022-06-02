package com.solvd.hospital.abstractFactory;

public interface IMedicinesWorkersAbstractFactory {
    ISurgery createSurgery();
    IOphthalmology createOphthalmology();
}
