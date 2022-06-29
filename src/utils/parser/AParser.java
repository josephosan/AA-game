package utils.parser;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class AParser {

    public JsonObject findAndReturnData(String path) {
        File file = new File("src/data/"+path);
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
