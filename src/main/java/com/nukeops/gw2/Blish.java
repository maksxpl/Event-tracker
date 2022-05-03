package com.nukeops.gw2;

import com.nukeops.other.JSON;
import com.nukeops.other.Process;

import java.io.File;
import java.io.IOException;

import static com.nukeops.Main.initError;

public class Blish {
    static String blishPath = JSON.parse("BlishPath");


    static void run(){
        try {
            Process.run("Blish HUD.exe",blishPath);
        }
        catch (Exception e){
            initError(String.valueOf(e),16);
        }
    }
    static boolean installed() {
        assert blishPath != null: "Can't find in config file: BlishPath";
        File f = new File(blishPath);
        return f.exists();
    }

    static Boolean isRunning() throws IOException {
        return Process.isRunning("Blish HUD.exe");
    }

}
