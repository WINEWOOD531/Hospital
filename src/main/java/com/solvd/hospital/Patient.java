package com.solvd.hospital;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Patient {
    @XmlAttribute
    private int id;

    @XmlElement
    private int age;

    @XmlElement
    private String bloodGroup;

    @XmlElement
    private String sex;

    @XmlTransient
    private String passportNumber;

    public Patient() {
    }

    public Patient(int id, int age, String bloodGroup, String sex, String passportNumber) {
        this.id = id;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.sex = sex;
        this.passportNumber = passportNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getSex() {
        return sex;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", age=" + age +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", sex='" + sex + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }
}
