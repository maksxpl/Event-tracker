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
