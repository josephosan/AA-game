package frameManager;

import config.Config;

import javax.swing.*;
import java.awt.*;
import config.Config;

public class APanel extends JPanel{
    String id;
    public APanel(String id) {
        // super();
        this.id = id;
        // when not declared the width and height is frame width's and height's
        System.out.println(Config.getFrameWidth());
        // System.exit(0);
        setPreferredSize(new Dimension(Config.getFrameWidth(), Config.getFrameHeight()));
        setLocation(0, 0);
        setOpaque(true);
        setBackground(Color.GREEN);
        setVisible(false);
    }

    // @Override 
    // public void paintComponent(Graphics g) {
    //     System.out.println("here");
    // }
}
