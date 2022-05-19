package com.solvd.hospital.models;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class PatientModel extends PersonModel {

    @XmlAttribute
    private int id;

    @XmlElement
    private int age;

    @XmlElement
    private String bloodGroup;

    @XmlElement
    private String sex;

    PersonModel personModel;

    public PatientModel() {
    }

    public PatientModel(int id, int age, String bloodGroup, String sex, PersonModel personModel) {
        this.id = id;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.sex = sex;
        this.personModel = personModel;
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

    public void setPerson(PersonModel person) {
        this.personModel = person;
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

    public PersonModel getPerson() {
        return personModel;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "id=" + id +
                ", age=" + age +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", sex='" + sex + '\'' +
                ", personModel=" + personModel +
                '}';
    }
}
