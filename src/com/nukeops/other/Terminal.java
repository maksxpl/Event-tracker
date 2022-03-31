package com.nukeops.other;

import com.nukeops.color.Background;
import com.nukeops.color.Color;
import com.nukeops.color.Font;

public class Terminal {
    public static void moveCursor(int x,int y){
        System.out.print("\u001b["+y+";"+x+"H");
        //    return output;
    }
    public static void clearScreen(){
        System.out.print("\u001b[2J");
    }
    public static void disableCursor(){
        System.out.print("\u001b[?12l");
        System.out.print("\u001b[?25l");
    }
    public static String moveCursorDown(int y){
        return "\u001b["+y+"B";
    }

    public static String textFormatting(int value){
        return "\u001b["+value+"m";
    }

    public static String clearTextFormatting(){
        return "\u001b[0m";
    }

    public static String align(String string, int max){

        String transformedString = string.replaceAll("\u001B|\\[..m|\\[.m","");
        int len = transformedString.length();
        int difference;
        if (len < max) {
            //both walls and one space takes 3 spaces, + 1 cos of bug or smth dont ask me
            difference = max-len-4;
        } else {
            difference = 0;
        }
        return string + " ".repeat(Math.max(0, difference + 1));
    }

    /**
     * Generates rectangle starting from specified (x,y) and going to bottom right
     * @param name {@link String} printed on middle of top bar
     * @param theme changes color scheme of the frame, there's few variations:
     *              <ul><li>Default</li><li>Cyan</li></ul>
     */
    public static void rect(int leftTopX, int leftTopY, int height, int width, String name, String theme){
        // https://en.wikipedia.org/wiki/Box-drawing_character
        height -= 1;
        width -= 2;
        int wallY = leftTopY+1; // +1 cos it starts 1 line below corner

        // theme
        switch (theme) {
            case "default" -> System.out.print(Color.clearFormatting);
            case "cyan" -> {
                System.out.print(Font.black);
                System.out.print(Background.cyan);
            }
        }

        // top bar
        moveCursor(leftTopX,leftTopY);
        System.out.print("┌");
             for(int x=0;x<width;x++){
                 System.out.print("─");
             }
        System.out.print("┐");

        // walls
        moveCursor(leftTopX,leftTopY+1);
        for(int y=0;y<height;y++){
            System.out.print("│"); // left wall
            moveCursor(leftTopX+width+1,leftTopY+y+1);
            System.out.print("│"); // right wall
            moveCursor(leftTopX,wallY);
            wallY++; // go one line down
        }

        // bottom bar
        System.out.print("└");
        for(int x=0;x<width;x++){
            System.out.print("─");
        } System.out.print("┘");

        // rect name (middle of top bar)
        // moveCursor(leftTopX+width/2,leftTopY); // center
        moveCursor(leftTopX+2,leftTopY); // left
        System.out.print(name);

        System.out.print(Color.clearFormatting);
    }
}





