package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import elementManager.elements.SmallBall;
import utils.parser.AParser;

public class Tools {
    public static double getTwoPointDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(((y2 - y1) * (y2 - y1)) + ((x2 - x1) * (x2 - x1)));
    }
    public static void AddShootingBallToRotatingBalls(SmallBall shootingSB){
        shootingSB.leave("shootingSmallBalls"); // removing the shot ball form its group.
        shootingSB.join("rotatingSmallBalls"); // joining the shooting ball using join method in Element class.
    }
    public static String chooseRandomSound(String[] soundsId){
        Random random = new Random(System.currentTimeMillis());
        int randomNum = random.nextInt(5);
        if(randomNum<soundsId.length){
            return soundsId[randomNum];
        }
        return new String("");
    }
    public static int getWhichLevelWeShouldStartWith(String userName) {
        Map<String, String> profileInformation;
        profileInformation = AParser.run("profile/"+userName+"Profile.json");
        int lastLevel = 0;
        for (int i = 0; i < 10; i++)
            if (profileInformation.containsKey("level"+i) && i > lastLevel)
                lastLevel = i;

        return lastLevel;
    }

    public static int generatRandomPositiveNegitiveValue(int max , int min) {
        //Random rand = new Random();
        int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
        return ii;
    }

}
