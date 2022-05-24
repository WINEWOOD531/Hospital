package com.solvd.hospital;

import java.util.List;

public class Hospital {
    private int id;
    private String name;
    private Integer employeesCount;
    /*    public List<String> departments;*/

    public Hospital() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getEmployeesCount() {
        return employeesCount;
    }

    /*    public Hospital(String name, Integer employeesCount, List<String> departments) {
        this.name = name;
        this.employeesCount = employeesCount;
        this.departments = departments;
    }*/

/*    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", employeesCount=" + employeesCount +
                ", departments=" + departments +
                '}';
    }*/

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employeesCount=" + employeesCount +
                '}';
    }
}
