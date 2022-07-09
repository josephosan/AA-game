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
        g.drawString(this.text, 100, 100);
    }
}
