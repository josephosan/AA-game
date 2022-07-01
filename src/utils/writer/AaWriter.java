package utils.writer;

import com.google.gson.Gson;
import utils.parser.AParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AaWriter {

    public static void pushValue(String userName, String key, String value) {
        try { // if file does not exist, it will be created:
            FileWriter writer;
            Map<String, String> input = new HashMap<>();

            if (!checkIfFileExists(userName)) {
                Gson gson = new Gson();

                writer = new FileWriter("src/data/profile/"+userName +"Profile.json");
                input.put(key, value);

                gson.toJson(input, writer);
                input.clear();
                writer.close();
                return;
            }


            Gson gson = new Gson();
            input = AParser.run("profile/"+userName+"Profile.json");

            writer = new FileWriter("src/data/profile/"+userName +"Profile.json");
            input.put(key, value);

            gson.toJson(input, writer);
            input.clear();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static Boolean checkIfFileExists(String userName) {
        File folder = new File("src/data/profile");
        for (String file: Objects.requireNonNull(folder.list()))
            if (file.contains(userName))
                return true;

        return false;
    }
}
