package com.fileUtils;

import com.ApiUtils.HTTPMethods;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Path;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtils {
    private static Properties properties;
    Logger logger = Logger.getLogger(HTTPMethods.class.getName());

    public JSONObject getJsonObject(String Inputdata) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject Object = (JSONObject) jsonParser.parse(Inputdata);
        return Object;
    }

    public JSONArray getJsonArray(String Inputdata, String Key) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject Object = (JSONObject) jsonParser.parse(Inputdata);
        JSONArray array = (JSONArray) Object.get(Key);
        return array;
    }

    public String getJsonValue(String Inputdata, String Key) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject Object = (JSONObject) jsonParser.parse(Inputdata);
        return Object.get(Key).toString();
    }

    public JSONObject getpayload(String filename) {
        logger.log(Level.INFO, "getting payload for {0} ", new Object[]{filename});
        try {
            FileReader reader = new FileReader(new File("src/main/resources/payloads/" + filename + ".json"));
            JSONParser jsonParser = new JSONParser();
            JSONObject Object = (JSONObject) jsonParser.parse(reader);
            return Object;
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
        return null;
    }

    public JSONObject getUpdateuserdata(String filename1) throws IOException, ParseException {
        FileReader reader = new FileReader(new File("src/main/resources/payloads/" + filename1 + ".json"));
        JSONParser jsonParser = new JSONParser();
        JSONObject Object = (JSONObject) jsonParser.parse(reader);
        return Object;
    }

    public JSONObject getJsonobjFromJsonfile(String filename) throws IOException, ParseException {

        //1. Read Json file for user data

        FileReader reader = new FileReader(new File(filename));
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        return jsonObject;
    }

    public void loadApplicationProperties() {
        logger.log(Level.INFO,"Loading Application Properties file");
        try (FileInputStream fis = new FileInputStream(new File("src/test/resources/application-configurations/application.properties"))) {
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Error in loading config file Error:{0}",new Object[]{e.getMessage()});
            e.printStackTrace();
        }
    }

    public String getApplicationProperties(String key) {
      return properties.getProperty(key);
    }

}
