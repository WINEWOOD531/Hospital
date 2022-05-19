package com.solvd.hospital.models;

public class TakesModel extends MedicinesModel{

    private int id;
    //private int medicinesId;
    //private int patientId;
    private Double quantity;
    private String takesDate;
    private MedicinesModel medicines;
    private PatientModel patient;

    public TakesModel() {
    }
    public TakesModel(int id, Double quantity, String takesDate, int medicinesId, int patientId) {
        this.id = id;
        this.quantity = quantity;
        this.takesDate = takesDate;
        this.medicines = medicines;
        this.patient = patient;
    }

    public TakesModel(int id, Double quantity, String takesDate, MedicinesModel medicines, PatientModel patient) {
        this.id = id;
        this.quantity = quantity;
        this.takesDate = takesDate;
        this.medicines = medicines;
        this.patient = patient;
    }

    public void setId(int id) {
        this.id = id;
    }

/*    public void setMedicinesId(int medicinesId) {
        this.medicinesId = medicinesId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }*/

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setTakesDate(String takesDate) {
        this.takesDate = takesDate;
    }

    public void setMedicines(MedicinesModel medicines) {
        this.medicines = medicines;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

/*    public int getMedicinesId() {
        return medicinesId;
    }

    public int getPatientId() {
        return patientId;
    }*/

    public Double getQuantity() {
        return quantity;
    }

    public String getTakesDate() {
        return takesDate;
    }

    public MedicinesModel getMedicines() {
        return medicines;
    }

    public PatientModel getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "TakesModel{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", takesDate='" + takesDate + '\'' +
                ", medicines=" + medicines +
                ", patient=" + patient +
                '}';
    }
}
