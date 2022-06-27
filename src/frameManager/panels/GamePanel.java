package frameManager.panels;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import config.Config;
import elementManager.ElementManager;
import elementManager.elements.Element;
import frameManager.*;
import middlewareManager.MiddlewareLocation;
import middlewareManager.*;
import middlewareManager.middlewares.*;

public class GamePanel extends APanel implements ActionListener {
    ElementManager elementManager = Config.getElementManager();
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    private Color backgroundColor = new Color(0x6ae7f8);
    private Color borderColor = new Color(0x2a6a7b);
    private Color buttonColor = new Color(0x32ff98);
    JButton pauseButton;

    public GamePanel(String id) {
        super(id);
        setLocation(0, 0);
        setBackground(backgroundColor);

        pauseButton = new JButton();
        pauseButton.setBounds(15, 15, 50, 50);
        pauseButton.setBackground(backgroundColor);
        pauseButton.setBorder(BorderFactory.createEtchedBorder(borderColor, borderColor));
        pauseButton.setFocusable(false);
        pauseButton.setIcon(new ImageIcon("src/Icons/pause.png"));
        pauseButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            pauseButton.setBackground(buttonColor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            pauseButton.setBackground(backgroundColor);
        }
        });
        this.add(pauseButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println("game panel repainting");
        ArrayList<Element> elements = elementManager.getElementsByPanel(this);
        System.out.println(elements);

        for (Element element : elements) {
            System.out.println("from paint component");
            element.paintSelf(g);
        }
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pauseButton){
            middlewareManager.addMiddleware(new TransitionPanels("game", "pause"), new MiddlewareLocation());
        }
    }
}
