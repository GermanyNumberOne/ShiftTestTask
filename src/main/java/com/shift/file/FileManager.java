package com.shift.file;

import com.shift.model.Departments;
import com.shift.model.Worker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Worker> loadWorkers(String filePath) throws IOException {
        List<Worker> workers = new ArrayList<>();

        Files.lines(Paths.get(filePath))
                .forEach(line -> {
                    String[] parts = line.split(",");
                    try {
                        String position = parts[0];
                        Long id = Long.parseLong(parts[1]);
                    } catch (NumberFormatException e){

                    }


                });

        return workers;
    }
}
