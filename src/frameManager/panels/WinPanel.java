package frameManager.panels;

import frameManager.APanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class WinPanel extends APanel {
    private final Color backgroundColor = new Color(0x32ff98);
    private final Color buttonsColor = new Color(0xd48a98);
    private final Color buttonBorderColor = new Color(0x2a6a7b);

    ArrayList<JButton> buttons = new ArrayList<JButton>();

    JButton retryButton;
    JButton nextLevelButton;
    JButton menuButton;

    public WinPanel(String id) {
        super(id);

        this.setBackground(backgroundColor);

        retryButton = new JButton();
        nextLevelButton = new JButton();
        menuButton = new JButton();

        //Adding to ArrayList
        buttons.add(retryButton);
        buttons.add(nextLevelButton);
        buttons.add(menuButton);

        //Set Bounds
        retryButton.setBounds(275,500,75,50);
        nextLevelButton.setBounds(50,500,75,50);
        menuButton.setBounds(50,425,75,50);


        retryButton.setIcon(new ImageIcon("src/Icons/play.png"));
        nextLevelButton.setIcon(new ImageIcon("src/Icons/levels.png"));
        menuButton.setIcon(new ImageIcon("src/Icons/score.png"));

        for(JButton b: buttons){
            b.setBackground(backgroundColor);
            b.setFocusable(false);
            b.setBorder(BorderFactory.createEtchedBorder(buttonBorderColor, buttonBorderColor));
            b.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    b.setBackground(buttonsColor);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    b.setBackground(backgroundColor);
                }
            });
            this.add(b);
        }

    }
}
