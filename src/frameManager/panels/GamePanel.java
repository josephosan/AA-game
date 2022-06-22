package frameManager.panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frameManager.*;

public class GamePanel extends APanel implements ActionListener {
    public GamePanel(String id) {
        super(id);
        setLocation(0, 0);
        setBackground(Color.YELLOW);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // doing danialish stuff.
    }
}
