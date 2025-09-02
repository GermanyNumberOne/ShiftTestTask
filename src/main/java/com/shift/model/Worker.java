package com.shift.model;

import lombok.Data;

@Data
public class Worker {
    private String position;
    private Long id;
    private String name;
    private double salary;
    private String department;

    public Worker(String position, Long id, String name, double salary, String department) {
        this.position = position;
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Worker() {
    }

    @Override
    public String toString() {
        return "Worker{" +
                "position='" + position + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
