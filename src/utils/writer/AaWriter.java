package utils.writer;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AaWriter {
    public AaWriter(String userName, String keyToPut, String valueToPut) {
        try { // if file does not exist, it will be created:
            FileWriter writer = new FileWriter("src/data/profile/"+userName+"Profile.json");
            Gson gson = new Gson();

            Map<String, String> input = new HashMap<>();
            input.put(keyToPut, valueToPut);

            gson.toJson(input, writer);
            input.clear();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
