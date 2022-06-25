package elementManager.elements;

import config.Config;
import elementManager.coordinate.AaPosition;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class BigBall extends Element{
    public AaPosition aaPosition = new AaPosition();
    Color color;
    int bornaXPos = 0;
    int bornaYPos = 0;
    private Image bornaImage;

    public BigBall(JPanel panel) {
        super(panel);
        this.size.setSize(Config.getMainCircleSize().getWidth(), Config.getMainCircleSize().getHeight());
        aaPosition.setX(Config.getFrameWidth()/2);
        aaPosition.setY(this.size.getHeight() + Config.getBigCircleRadios() + 50);

        // borna stuff:
        try {
            bornaImage = ImageIO.read(new File("src/Icons/borna.jpg"));
        } catch (ImagingOpException | IOException e) {
            e.printStackTrace();
        }
    }

    public AaPosition getPosition() {
        return aaPosition;
    }

    public void setPos(int x, int y){
        position.setX(x);
        position.setY(y);
    }

    public void setColor(Color c){
        this.color = c;
    }

    public void setBornaPosition(int xPos, int yPos) {
        this.bornaXPos = xPos;
        this.bornaYPos = yPos;
    }


    @Override
    public void paintSelf(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g2D.setPaint(this.color);
        g2D.fillOval(
            this.position.getX() - this.size.getWidth() / 2,
            this.position.getY(),
            this.size.getWidth(), 
            this.size.getHeight());
        if (bornaXPos != 0 || bornaYPos != 0)
            g2D.drawImage(bornaImage, bornaXPos, bornaYPos, 60, 60, null);
    }

    public Integer getR() {
        return Config.getBigCircleRadios();
    }
}
