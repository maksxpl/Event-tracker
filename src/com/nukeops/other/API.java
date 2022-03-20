package com.nukeops.other;

//import com.nukeops.color.Color;
import com.nukeops.color.Color;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
//import java.net.MalformedURLException;
import java.net.URL;
//import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class API {

    static String api = "";
    static JSONObject output = null;

    public static JSONObject jsonFromURL() throws JSONException {
        try{
            JSONObject json = new JSONObject(IOUtils.toString(
                    new URL("https://api.warframestat.us/PC/cetusCycle"), StandardCharsets.UTF_8));
            // save json to 'output' in case api was offline
            api = "online";
            output = json;
            return output;
        } catch(IOException io) {
            api = "offline";
        } return output;
    }

    public static String transform(JSONObject json,String string){
        String output = (json.getString(string));
        if(api.equals("online")){
            if(output.contains("Day")){
                output = output.replace("Day", Color.font("Day","yellow"));
            } else if(output.contains("Night")){
                output = output.replace("Night", Color.font("Night","blue"));
            }
            output = output + Terminal.clearTextFormatting();
        } else {
            // if client can't reach api - change color to yellow
            // output = Color.yellow + output + Terminal.clearTextFormatting(null);
            output = Color.font(output,"yellow");
        }
        return output;
    }
}
