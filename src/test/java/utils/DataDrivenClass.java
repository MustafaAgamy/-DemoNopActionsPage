package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class DataDrivenClass {

    public static String readJson(String filePath, String key) throws IOException, ParseException {
    	JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filePath));

        if(jsonObject.get(key) == null){
            return "Sorry, unable to find Json Key";
        }
        return (String) jsonObject.get(key);
    }
}
