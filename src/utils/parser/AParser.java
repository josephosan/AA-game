package utils.parser;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

public class AParser {

    public JsonObject findAndReturnData(String path) {
        URL url = getClass().getClassLoader().getResource("data/"+path);
        File file = null;
        try {
            System.out.println(url.toURI());
            System.out.println(url.toURI());
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
            return fileElement.getAsJsonObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, String> returnJsonFileInHashMap(JsonObject jsonFile) {
        Gson gson = new Gson();
        HashMap<String, String> result = gson.fromJson(jsonFile.toString(), HashMap.class);
        return result;
    }

    public static HashMap<String, String> run(String path) {
        AParser parser = new AParser();
        return parser.returnJsonFileInHashMap(parser.findAndReturnData(path));
    }
}
