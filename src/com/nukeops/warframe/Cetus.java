package com.nukeops.warframe;

import com.nukeops.other.API;
import com.nukeops.color.Color;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Cetus {
    public static String DayState() throws JSONException, IOException {
        JSONObject a = API.jsonFromURL();
        String output = API.transform(a,"shortString");

        return(" "+ Color.font("Cetus","yellow")+": "+output+"   ");
    }
}
