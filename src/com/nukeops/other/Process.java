package com.nukeops.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Process {
    public static void run(String pathToProcess) {
        try {
            Runtime runTime = Runtime.getRuntime();
            runTime.exec(pathToProcess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void kill(String serviceName) throws Exception {
        Runtime.getRuntime().exec("taskkill /F /IM " + serviceName);
    }

    public static void py() {
        String s;
        try {
            java.lang.Process p = Runtime.getRuntime().exec("py src/Counter.py");

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));

            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }

            // System.exit(0);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static Boolean isRunning(String process) throws IOException{
        String filenameFilter = "/nh /fi \"Imagename eq "+ process +"\"";
        String tasksCmd = System.getenv("windir") +"/system32/tasklist.exe "+filenameFilter;

        java.lang.Process p = Runtime.getRuntime().exec(tasksCmd);
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

        ArrayList<String> procs = new ArrayList<>();
        String line;
        while ((line = input.readLine()) != null)
            procs.add(line);

        input.close();

        return procs.stream().anyMatch(row -> row.contains(process));
    }
}
