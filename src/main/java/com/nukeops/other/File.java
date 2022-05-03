package com.nukeops.other;

import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

import static com.nukeops.Main.initError;

public class File {
    public static boolean copy(String sourcePath, String targetPath){
        try {
            java.io.File copied = new java.io.File(String.valueOf(Paths.get(targetPath)));
            java.io.File original = new java.io.File(String.valueOf(Paths.get(sourcePath)));
            FileUtils.copyFile(original, copied);
            return true;
        } catch (Exception e){
            initError(String.valueOf(e),9);
            return false;
        }
    }
    public static boolean remove(String file){
        java.io.File f= new java.io.File(file);
        return f.delete();
    }
    public static boolean exist(String path){
        java.io.File f = new java.io.File(path);
        return f.exists();
    }
    public static Boolean compare(String file1, String file2) {
        try {
             java.io.File a = new java.io.File(file1);
             java.io.File b = new java.io.File(file2);
            return FileUtils.contentEquals(a,b);
        } catch (IOException e){
            initError(String.valueOf(e),8);
            return false;
        }
    }
    public static void download(String url, String fileName){
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (Exception e) {
            initError(String.valueOf(e),7);
        }
    }
}
