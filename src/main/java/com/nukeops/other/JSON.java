package com.nukeops.other;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static com.nukeops.Main.initError;

public class JSON {
    public static String parse(String object) {
        try {
            Object ob = new JSONParser().parse(new FileReader("src\\config.json"));
            String a = new Gson().toJson(ob);
            JSONObject mJSONObject = new JSONObject(a);
            return (String) mJSONObject.get(object);
        } catch (IOException | ParseException e) {
            initError(String.valueOf(e),6);
            return null;
        }
    }
}

