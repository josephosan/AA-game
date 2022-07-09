package elementManager.elements;

import config.Config;
import elementManager.coordinate.AaPosition;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;


public class BigBall extends Element{
    public AaPosition aaPosition = new AaPosition();
    Color color;
    int ostadXPos = 0;
    int ostadYPos = 0;
    int ostadXSize = 60;
    int ostadYSize = 60;
    private Image ostadImage;
    private String osName;

    public BigBall(JPanel panel) {
        super(panel);
        this.size.setSize(Config.getMainCircleSize().getWidth(), Config.getMainCircleSize().getHeight());
        aaPosition.setX(Config.getFrameWidth()/2);
        aaPosition.setY(this.size.getHeight() + Config.getLineLength() + 50);

        // borna stuff:
        try {
            ostadImage = ImageIO.read(new File("src/Icons/os.jpg"));
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

    public void setOsPosition(int xPos, int yPos) {
        this.ostadXPos = xPos;
        this.ostadYPos = yPos;
    }

    public void setOsSize(int xSize, int ySize) {
        this.ostadXSize = xSize;
        this.ostadYSize = ySize;
    }


    @Override
    public void paintSelf(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g2D.setPaint(this.color);
        g2D.fillOval(
            this.position.getX() - this.size.getWidth() / 2,
            this.position.getY() - this.size.getHeight() / 2,
            this.size.getWidth(), 
            this.size.getHeight());
        if (ostadXPos != 0 || ostadYPos != 0)
            g2D.drawImage(ostadImage, ostadXPos, ostadYPos, ostadXSize, ostadYSize, null);
    }

    public Integer getR() {
        return Config.getLineLength();
    }
}
