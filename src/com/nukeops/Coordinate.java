package com.nukeops;

public class Coordinate {
    // default
    public int y = 0;
        // public int x = 0;
        // public int width = 0;
        // public int height = 0;
    // general
    public int yGen = 0;
    public int xGen = 0;
    public int widthGen = 0;
    public int heightGen = 0;
    // guild wars
    public int yGw = 0;
    public int xGw = 0;
    public int widthGw = 0;
    public int heightGw = 0;
    // warframe
    public int yWf = 0;
    public int xWf = 0;
    public int widthWf = 0;
    public int heightWf = 0;

    public static Coordinate coordinates() {
        Coordinate coord=new Coordinate();
        // General
        coord.yGen = coord.y+1;
        coord.xGen = 2;
        coord.widthGen = 27;
        coord.heightGen = 3;
        coord.y += coord.heightGen;
        // Gw2
        coord.yGw = coord.y+1;
        coord.xGw = 2;
        coord.widthGw = 27;
        coord.heightGw = 7;
        coord.y += coord.heightGw;
        // wf
        coord.yWf = coord.y+1;
        coord.xWf = 2;
        coord.widthWf = 27;
        coord.heightWf = 3;
        coord.y += coord.heightWf;
        return coord;
    }
}
