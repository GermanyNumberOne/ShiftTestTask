package com.shift.model;

public enum Departments {
    HR(1),Sales(2), IT(3);

    private final int departmentId;

    Departments(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public static Departments fromValue(int val) throws IllegalAccessException {
        for (Departments d : values()){
            if(d.departmentId == val){
                return d;
            }
        }
        throw new IllegalAccessException("No enum constant with value " + val);
    }

    public static Departments fromValue(String val) {
        return Departments.valueOf(val);
    }
}
