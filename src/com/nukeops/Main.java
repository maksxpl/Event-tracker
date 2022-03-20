package com.nukeops;

import com.nukeops.color.Color;
import com.nukeops.gw2.Gw2;
import com.nukeops.other.Template;
import com.nukeops.other.Terminal;
import com.nukeops.other.Time;
import com.nukeops.warframe.Warframe;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main{
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        try {
        init();
        Coordinate pos=generateFrames();
        while(true){
            general(pos.yGen);
            Gw2(pos.yGw2);
            wf(pos.yWf);
    }   }
        catch (Exception e){
            e.printStackTrace();
    }   }

    static void init() throws IOException {
        Template.init();
        Gw2.updateArc();

        Terminal.clearScreen();
        Terminal.disableCursor();
    }
    static void Gw2(int y){  Gw2.init(3,y); }
    static void wf(int y) {  Warframe.init(2,y);  }
    static Coordinate generateFrames() {
        Coordinate coord=new Coordinate();

        int x = 0;
        int y = 1;

        // General
        coord.yGen = y+1;
        int height = 3;
        Terminal.rect(x,y,height,27,Color.font("┤general├","cyan"),"default");
        int yGw2 = y = y+height;
        // Gw2
        coord.yGw2 = yGw2+1;
        height = 7;
        Terminal.rect(x,y,height,27,Color.font("┤gw2├","cyan"),"default");
        Terminal.moveCursor(x+2, y+4); System.out.println("──────── Events ─────────");
        int yWf = y = y+height;
        // wf
        coord.yWf = yWf+1;
        height = 3;
        Terminal.rect(x,y,height,27,Color.font("┤wf├","cyan"),"default");

        coord.y = y;
    return coord;
    }

    static void general(int y){
        Terminal.moveCursor(3,y);
        System.out.print(Time.current());
    }
    public static void initError(String error){
        Terminal.moveCursor(1, generateFrames().y+5);
        System.out.print("──────── Errors ─────────");
        Terminal.moveCursor(1, generateFrames().y+6);
        System.out.print(error);
        generateFrames().y += 1;
    }
}

class Coordinate {
    public int y = 0;
    public int yGen = 0;
    public int yGw2 = 0;
    public int yWf = 0;
}

/*bugs*/
//DONE(probably) fix path checks
//DONE fix graphical bugs
//TODO fix length of status strings

/*features*/
//DONE update arc dps automatically
//DONE add event timer
//DONE make frames mobile/movable
//TODO? add more timers
//TODO? add themes for rect
//DONE add frame for general stuff like current time
//HALF-DONE add frame for errors

/*config*/
//DONE add config(json?)
//TODO allow enabling/disabling frames
//TODO? allow to set x,y of frames?
//TODO? allow to enable/disable content of frames

/*other*/
//DONE clear Gw2.init code
//DONE clear coordinates code in Main
//TODO make python file modular
//DONE add on github
//TODO? add integrity checks
//KYS make event timer but in java

