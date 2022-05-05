package com.nukeops;

import com.nukeops.color.Color;
import com.nukeops.gw2.Gw2;
import com.nukeops.other.Template;
import com.nukeops.other.Terminal;
import com.nukeops.other.Time;
import com.nukeops.warframe.Warframe;

import java.io.IOException;

import static com.nukeops.Coordinate.coordinates;
import static java.lang.Thread.sleep;

public class Main{
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        try {
        Coordinate pos=init();
        while(true){
            general(pos.yGen+1);
            Gw2(pos.yGw+1);
            wf(pos.yWf+1);
            //noinspection BusyWait
            sleep(1);
    }   }
        catch (Exception e){
            initError(String.valueOf(e),0);
    }   }

    static Coordinate init() throws IOException {
        Template.init();
        Gw2.updateArc();
        Terminal.clearScreen();
        Terminal.disableCursor();
        generateFrames();
        return coordinates();
    }
    static void Gw2(int y){  Gw2.init(3,y); }
    static void wf(int y) {  Warframe.init(4,y);  }
    static void general(int y){
        Terminal.moveCursor(4,y);
        System.out.print(Time.current());
    }

    public static void generateFrames() {
        Coordinate pos= coordinates();
        Terminal.rect(pos.xGen,pos.yGen,pos.heightGen,pos.widthGen,
                Color.font("┤general├","cyan"),"default");
        Terminal.rect(pos.xGw,pos.yGw,pos.heightGw,pos.widthGw,
                Color.font("┤gw2├","cyan"),"default");
        frameDecorator("──────── Events ─────────",pos.xGw+1,pos.yGw+4);
        Terminal.rect(pos.xWf,pos.yWf,pos.heightWf,pos.widthWf,
                Color.font("┤wf├","cyan"),"default");
    }
    public static void frameDecorator(String decorator,int x,int y){
        Terminal.moveCursor(x, y);
        System.out.println(decorator);
    }

    public static void initError(String error,int code){
        Terminal.moveCursor(1, coordinates().y+5);
        System.out.print("──────── Errors ─────────");
        Terminal.moveCursor(1, coordinates().y+6);
        System.out.print("Error (code "+code+")| " + error);
        coordinates().y += 1;
    }
}

/*bugs*/
//DONE(probably) fix path checks
//DONE fix graphical bugs
//DONE replace .exec with ProcessBuilder
//DONE fix length of status strings but:
//DONE fix duplicated frame generation

/*features*/
//DONE update arc dps automatically
//DONE add event timer
//DONE make frames mobile/movable
//TODO? add more timers
//TODO? add themes for rect
//DONE add frame for general stuff like current time
//DONE add frame for errors
//TODO make event timer in java instead of improving Counter.py
//TODO ^ check timezone

/*config*/
//DONE add config(json?)
//TODO? allow enabling/disabling frames
//TODO? allow to set x,y of frames?
//TODO? allow to enable/disable content of frames

/*other*/
//DONE clear Gw2.init code
//DONE clear coordinates code in Main
//TODO? make Counter.py more modular (allow more timers)
//DONE add on github
//DONE make it public on git
//DONE add actions for code tests
//TODO? changelog generator


