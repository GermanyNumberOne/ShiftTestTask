package com.shift;

import com.shift.file.FileManager;
import com.shift.model.Context;
import com.shift.model.Departments;
import com.shift.model.Worker;

import java.io.IOException;

public class ShiftTestTask {

    public static void main(String[] args){
//       ConsoleArgsProcessor consoleArgsProcessor = new ConsoleArgsProcessor();
//        Map<String, String> settings = consoleArgsProcessor.validateAllArgs(consoleArgsProcessor.mapAllArgs(args));

        try {
            FileManager.loadWorkers(new String[]{"C:\\Users\\duben\\Downloads\\example_files\\example_files\\input1.sb", "C:\\Users\\duben\\Downloads\\example_files\\example_files\\input2.sb"});

            System.out.println("workers: ");
            Context.getWorkers().forEach(worker -> System.out.println(worker.toString()));
            System.out.println("errors: ");
            Context.getErrors().forEach(System.out::println);

            for (Worker worker : Context.getWorkers()){
                if((Departments)worker.getDepartment())
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
