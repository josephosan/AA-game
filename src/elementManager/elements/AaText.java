package elementManager.elements;

import javax.swing.*;
import java.awt.*;

public class AaText extends Element{
    String text = "";
    public AaText(JPanel panel) {
        super(panel);
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void paintSelf(Graphics g) {
<<<<<<< HEAD
        //System.out.println("painting self");
=======
>>>>>>> 673f89b7d60bd045dbf801ea8cb757d786fb7de8
        g.drawString(this.text, 100, 100);
    }
}
