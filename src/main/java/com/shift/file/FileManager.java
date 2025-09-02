package com.shift.file;

import com.shift.model.Context;
import com.shift.model.Worker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void loadWorkers(String[] filePaths) throws IOException {
        for (String path : filePaths){
            Files.lines(Paths.get(path))
                    .forEach(line -> {
                        String[] parts = line.split(",");
                        try {
                            String position = parts[0];

                            long id = Long.parseLong(parts[1]);

                            String name = parts[2];

                            double salary = Double.parseDouble(parts[3]);
                            if(salary < 0)throw new NumberFormatException(name + "'s salary is negative");

                            String department = parts[4];
                            if(department)
                            Context.addWorker(new Worker(position, id, name, salary, department));
                        } catch (NumberFormatException e){
                            Context.addError(String.join(",", parts));
                        }
                    });
        }



    }
}
