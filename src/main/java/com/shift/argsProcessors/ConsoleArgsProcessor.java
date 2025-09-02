package com.shift.argsProcessors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConsoleArgsProcessor {
    private boolean checkForExpectedConsoleArgument(String key){
        try {
            ExpectedConsoleArguments.valueOf(key);
        }catch (IllegalArgumentException e){
            return false;
        }

        return true;
    }

    public Map<String, String> mapAllArgs(String[] args){
        if(args.length == 0){
            return null;
        }
        Map<String,String> options = new HashMap<>();

        for (String arg : args){
            if(!arg.startsWith("-")){
                continue;
            }
            String[] temp = arg.split("=");

            String key = temp[0].replaceAll("^[-]+", "");
            if(!checkForExpectedConsoleArgument(key)) throw new RuntimeException("Argument '" + key + "'" + " is not expected");
            if(temp.length < 2){
                options.put(key, "");
                continue;
            }

            String value = String.join("", Arrays.copyOfRange(temp, 1, temp.length));
            options.put(key,value);
        }
        return options;
    }

    public Map<String, String> validateAllArgs(Map<String, String> args){
        if(args.isEmpty())return null;
        String value;

        value = args.containsKey("output") ? args.get("output") : args.get("o");
        if(!(value.equals("console") || value.equals("file"))) throw new RuntimeException("Unexpected value in 'output' argument");

        if(value.equals("file") && !args.containsKey("path")){
            throw new RuntimeException("Expected 'path' argument");
        }
        else if(!value.equals("file") && args.containsKey("path")){
            throw new RuntimeException("Expected 'file' value in 'output' argument");
        }

        value = args.containsKey("sort") ? args.get("sort") : args.get("s");
        if(value == null || value.equals("")){
            args.remove("sort");
            args.remove("order");
        }
        else if(!(value.equals("name") || value.equals("salary"))) throw new RuntimeException("Unexpected value in 'sort' argument");
        else{
            value = args.getOrDefault("order", null);
            if(value == null || !(value.equals("asc") || value.equals("desc"))) throw new RuntimeException("Unexpected value in 'sort' argument");
        }

        return args;
    }
}
