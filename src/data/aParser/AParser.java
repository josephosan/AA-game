package data.aParser;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

public class AParser {

    public JsonObject findAndReturnData(int levelNumber) {
        File file = new File("src/data/levels/level"+ levelNumber +".json");
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(file));
            return fileElement.getAsJsonObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, String> resultRetruner(JsonObject jsonFile) {
        Gson gson = new Gson();
        HashMap<String, String> result = gson.fromJson(jsonFile.toString(), HashMap.class);
        return result;
    }
}
