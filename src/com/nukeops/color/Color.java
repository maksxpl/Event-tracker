package com.nukeops.color;

import com.nukeops.other.Terminal;

public class Color {
public static String clearFormatting = Terminal.clearTextFormatting();

    public static String font(String string, String color){
        switch(color){
            case "black":
                string = Font.black  + string + clearFormatting;
            case "white":
                string = Font.white  + string + clearFormatting;
            case "red":
                string = Font.red    + string + clearFormatting;
            case "green":
                string = Font.green  + string + clearFormatting;
            case "yellow":
                string = Font.yellow + string + clearFormatting;
            case "blue":
                string = Font.blue   + string + clearFormatting;
            case "cyan":
                string = Font.cyan   + string + clearFormatting;
        }
        return string;
    }
    public static String background(String string, String color){
        switch(color){
            case "black":
                string = Background.black  + string + clearFormatting;
            case "white":
                string = Background.white  + string + clearFormatting;
            case "red":
                string = Background.red    + string + clearFormatting;
            case "green":
                string = Background.green  + string + clearFormatting;
            case "yellow":
                string = Background.yellow + string + clearFormatting;
            case "blue":
                string = Background.blue   + string + clearFormatting;
            case "cyan":
                string = Background.cyan   + string + clearFormatting;
        }
        return string;
    }
}

