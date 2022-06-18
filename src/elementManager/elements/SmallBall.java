package elementManager.elements;

import javax.swing.*;
import java.awt.*;
import elementManager.coordinate.AaPosition;

public class SmallBall extends Element {
    int number=1;
    int width=0;
    int height=0;
    boolean numberVisible=false;
    public SmallBall(JPanel panel) {
        super(panel);
    }

    public void setPos(int x, int y){
        this.width = x;
        this.height = y;
    }

    public void setNumber(int number){
        this.number = number;
    }


    public String getNumber(){
        return Integer.toString(this.number);
    }

    public static int getXPos() {
        return 0;
    }

    public static int getYPos() {
        return 0;
    }

    public Double getAngle() {      //returning 90 degree angle for use in Rotation class
        return 90.0;
    }

    public void setNumberVisible(boolean numberVisible){
        this.numberVisible = numberVisible;
    }

    @Override
    public void paintSelf(Graphics g){
        Graphics2D g2D = (Graphics2D)g;      //Graphics2D is more feature-rich than Graphics
        if(numberVisible){                   //checking whether we want number inside the ball
            g2D.setPaint(Color.ORANGE);             
            g2D.fillOval(this.width - 8, this.height - 8, 16, 16);      //Drawing the circle with radius 15
            g2D.setPaint(Color.BLACK);
            g2D.drawString(getNumber(), this.width - 8, this.height - 8);          //Drawing the number inside the circle. *still not sure about it
            System.out.println("print smallBall with number");
        }
        else{
            g2D.setPaint(Color.ORANGE);
            g2D.fillOval(this.width - 8, this.height - 8, 16, 16);
            System.out.println("print smallBall without number");
        }

    }    
}
