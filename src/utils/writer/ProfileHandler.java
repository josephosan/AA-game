package utils.writer;

import utils.Tools;

public class ProfileHandler {
    private static int levelNumber;
    public static void run(int levelNumber, String userName) {
        ProfileHandler.levelNumber = levelNumber;
        putData(levelNumber, userName);
    }

    private static void putData(int levelNumber, String userName) {
        String key = "levelNumber-time-score";

        // TODO getting time from danial.
        int time = 0;
        // TODO getting score from score calculator.
        int score = Tools.scoreCalculator(time);

        String value = levelNumber + " " + time + " " + score;

        AaWriter.pushValue(userName, key, value);
    }
}
