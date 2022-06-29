package soundManager;
import java.io.File;
import java.util.*;
import javax.sound.sampled.*;

public class SoundManager {

    HashMap<String, Clip> clips = new HashMap<>();

    public void onConfigSubscribe() {

    }

    public SoundManager() {

    }

    public void addClip(String clipName, String soundFileaName) {
        try {
            File file = new File("src/data/sounds/" + soundFileaName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clips.put(clipName, clip);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeClip(String clipName) {
        clips.remove(clipName);
    }

    public void play(String clipName) {
        if (clips.containsKey(clipName)) {
            System.out.println("here");
            Clip clip = clips.get(clipName);
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void stop(String clipName) {
        if (clips.containsKey(clipName)) {
            Clip clip = clips.get(clipName);
            clip.stop();
        }
    }

    public void playForEver(String clipName) {
        if (clips.containsKey(clipName)) {
            Clip clip = clips.get(clipName);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
}
