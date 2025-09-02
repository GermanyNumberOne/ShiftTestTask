package com.shift.model;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Context {
    private static List<Worker> workers = new ArrayList<>();
    private static List<String> errors = new ArrayList<>();

    public static void addWorker(Worker worker){
        workers.add(worker);
    }

    public static void addError(String string){
        errors.add(string);
    }

    public static List<Worker> getWorkers() {
        return workers;
    }

    public static List<String> getErrors() {
        return errors;
    }
}
