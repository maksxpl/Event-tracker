package com.nukeops.warframe;

import com.nukeops.other.Terminal;
import org.json.JSONException;

import java.io.IOException;

import static com.nukeops.Main.initError;

public class Warframe {
    public static void init(int x, int y){
        try {
            Terminal.moveCursor(x, y);
            System.out.print(Cetus.DayState());
        } catch (JSONException|IOException e){
            initError(String.valueOf(e),1);
        }
    }
}
