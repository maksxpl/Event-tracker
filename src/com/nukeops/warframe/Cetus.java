package com.nukeops.warframe;

import com.nukeops.other.API;
import com.nukeops.color.Color;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static com.nukeops.Coordinate.coordinates;
import static com.nukeops.other.Terminal.align;

public class Cetus {
    static int widthWf= coordinates().widthWf;
    public static String DayState() throws JSONException, IOException {
        JSONObject jsonObj = API.jsonFromURL();
        String transformedJson =
                Color.font("Cetus","yellow")+": "+
                API.transform(jsonObj,"shortString");
        return align(transformedJson,widthWf);
    }
}
