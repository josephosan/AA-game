package frameManager.panels;

import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import frameManager.APanel;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import middlewareManager.middlewares.*;

import elementManager.*;
import elementManager.elements.*;
import config.Config;

import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends APanel implements ActionListener{
    ElementManager elementManager = Config.getElementManager();
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    APanel menuPanel ;

    JButton playButton;
    JButton levelButton;
    JButton scoreButton;

    private final Color backgroundColor = new Color(0x32ff98);
    private final Color buttonsColor = new Color(0xd48a98);
    private final Color buttonBorderColor = new Color(0x2a6a7b);
    ArrayList<JButton> buttons = new ArrayList<JButton>();

    public MenuPanel(String id) {
        super(id);
        this.setBackground(backgroundColor);

        playButton = new JButton();
        levelButton = new JButton();
        scoreButton = new JButton();

        //Adding to ArrayList
        buttons.add(playButton);
        buttons.add(levelButton);
        buttons.add(scoreButton);

        //Set Bounds
        playButton.setBounds(275,500,75,50);
        levelButton.setBounds(50,500,75,50);  
        scoreButton.setBounds(50,425,75,50);


        playButton.setIcon(new ImageIcon("src/Icons/play.png"));
        levelButton.setIcon(new ImageIcon("src/Icons/levels.png"));
        scoreButton.setIcon(new ImageIcon("src/Icons/score.png"));

        this.add(playButton);
        for(JButton b: buttons){
            b.setBackground(backgroundColor);
            b.setFocusable(false);
            b.addActionListener(this);
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
        //setLocation(0, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println("menu panel repainting");
        ArrayList<Element> elements = elementManager.getElementsByPanel(this);
        System.out.println(elements);

        for (Element element : elements) {
            System.out.println("from paint component");
            element.paintSelf(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {   
        if(e.getSource()==playButton){
            middlewareManager.addMiddleware(new TransitionPanels("menu", "game"), new MiddlewareLocation());
        }
        else if(e.getSource()==levelButton){
            middlewareManager.addMiddleware(new TransitionPanels("menu", "levels", false), new MiddlewareLocation());
        }
        else if(e.getSource()==scoreButton){
            middlewareManager.addMiddleware(new TransitionPanels("menu", "pause",false), new MiddlewareLocation());
        }

    }
}
