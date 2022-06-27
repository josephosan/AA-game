package frameManager.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import elementManager.elements.*;
import elementManager.coordinate.*;
import frameManager.*;
import groovyjarjarantlr4.v4.parse.ANTLRParser.elementEntry_return;

public class GamePanel extends APanel implements ActionListener {
    public GamePanel(String id) {
        super(id);
        setLocation(0, 0);
        setBackground(Color.YELLOW);

        // do not touch this from duniyal!!
        // testOrderPatterns();
    }

    public void testOrderPatterns() {
        Line line = new Line(this);
        line.setPos(100, 100, 200, 200);

        SmallBall smallBall = new SmallBall(this);
        smallBall.setPosition(new AaPosition(150, 150));
        smallBall.setColor(Color.BLUE);

        
        SmallBall smallBall1 = new SmallBall(this);
        smallBall1.setPosition(new AaPosition(140, 150));
        smallBall1.setColor(Color.RED);

        SmallBall smallBall11 = new SmallBall(this);
        smallBall11.setPosition(new AaPosition(140, 150));
        smallBall11.setColor(Color.GREEN);

        this.elementManager.addElement("duniLine", line);
        this.elementManager.addElement("duniBall", smallBall);
        this.elementManager.addElement("duniBall1", smallBall1);
        this.elementManager.addElement("duniBall11", smallBall11);

        line.join("duniLine");
        smallBall.join("duniBall");

        setPaintOrder("*>duniBall>#duniBall1>duniLine");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // doing danialish stuff.
    }
}
