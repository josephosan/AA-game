package frameManager.panels;

import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import frameManager.APanel;
import frameManager.FrameManager;
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
    //FrameManager frameManager = Config.getFrameManager();
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    APanel menuPanel ;
    JButton playButton;
    JButton levelButton;
    public MenuPanel(String id) {
        super(id);

        this.setBackground(new Color(0x32ff98));
       
        ImageIcon playIcon = new ImageIcon("src/Icons/play.png");
        ImageIcon levelIcon = new ImageIcon("src/Icons/levels.png");

        playButton = new JButton();
        levelButton = new JButton();

        playButton.setFocusable(false);
        levelButton.setFocusable(false);

        playButton.addActionListener(this);
        levelButton.addActionListener(this);

        playButton.setBounds(275,500,75,50);
        levelButton.setBounds(50,500,75,50);  
        
        playButton.setIcon(playIcon);
        levelButton.setIcon(levelIcon);

        playButton.setBackground(new Color(0xd48a98));
        levelButton.setBackground(new Color(0xd48a98));

        playButton.setBorder(BorderFactory.createEtchedBorder(new Color(0xd48a98), new Color(0xd48a98)));
        levelButton.setBorder(BorderFactory.createEtchedBorder(new Color(0xd48a98), new Color(0xd48a98)));

        this.add(levelButton);
        this.add(playButton);
        setLocation(0, 0);
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
        // TODO - call to open other panels based on which button was clicked
        if(e.getSource()==playButton){
            Middleware transitionPanels = new TransitionPanels("menu", "game");
            MiddlewareLocation transitionPanelsLocation = new MiddlewareLocation();
            middlewareManager.addMiddleware(transitionPanels, transitionPanelsLocation);
        }
        else if(e.getSource()==levelButton){
            Middleware transitionPanels = new TransitionPanels("menu", "levels" , false);
            MiddlewareLocation transitionPanelsLocation = new MiddlewareLocation();
            middlewareManager.addMiddleware(transitionPanels, transitionPanelsLocation);
        }

    }
}
