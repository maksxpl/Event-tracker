package com.nukeops.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import static com.nukeops.Main.initError;

public class Process {
//    public static void run(String pathToProcess) throws IOException {
//        try {
//            Runtime runTime = Runtime.getRuntime();
//            runTime.exec(pathToProcess);
//        } catch (IOException e) {
//            initError(String.valueOf(e));
//        }
    public static void run(String command, String dir) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(dir,command);
        java.lang.Process p = pb.start();
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
        }
        catch (IOException e) {
            initError(String.valueOf(e),5);
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
