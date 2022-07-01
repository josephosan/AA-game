package utils.writer;

public class ProfileHandler {
    public static void putData(String userName, int levelNumber, int endTime) {
        // this method will get the level number and getting time from levelTime
        // then will push a key value pare to the profile.json with the given name.
        // and as value, it will push the time of finishing level to profile.json.
        String key = "level"+levelNumber;

        String value = ""+endTime;

        AaWriter.pushValue(userName, key, value);
    }
}
