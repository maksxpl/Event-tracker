package com.nukeops.gw2;

import com.nukeops.other.JSON;
import com.nukeops.other.Process;

import java.io.File;
import java.io.IOException;

public class Blish {

    static void run(){
        try {
            Process.run("src\\Blish.bat");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    static boolean installed() {
        String blishPath = JSON.parse("BlishPath");
        assert blishPath != null: "corrupted config file";
        File f = new File(blishPath);
        return f.exists();
    }

    static Boolean isRunning() throws IOException {
        return Process.isRunning("Blish HUD.exe");
    }

}
