package com.shift.model;

import lombok.Data;

@Data
public class Worker {
    private String position;
    private Long id;
    private String name;
    private int salary;
    private Departments department;

    public Worker(String position, Long id, String name, int salary, Departments department) {
        this.position = position;
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Worker() {
    }
}
