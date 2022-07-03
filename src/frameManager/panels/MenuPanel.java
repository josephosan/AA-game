package frameManager.panels;

import java.util.*;

import javax.swing.*;

import frameManager.APanel;
import middlewareManager.MiddlewareLocation;
import middlewareManager.MiddlewareManager;
import middlewareManager.middlewares.*;

import elementManager.*;
import config.Config;
import utils.Tools;

import java.awt.*;
import java.awt.event.*;

public class MenuPanel extends APanel implements ActionListener{
    ElementManager elementManager = Config.getElementManager();
    MiddlewareManager middlewareManager = Config.getMiddlewareManager();
    APanel menuPanel ;
    JLabel POWERED_BY;
    Image logo = Toolkit.getDefaultToolkit().createImage("src/Icons/aaLogo.png");

    JButton playButton;
    JButton levelButton;
    //JButton scoreButton;

    private final Color backgroundColor = new Color(0xBFBFBF);
    private final Color buttonsColor = new Color(0xBFBFBF);
    // private final Color buttonBorderColor = new Color(0x2a6a7b);
    ArrayList<JButton> buttons = new ArrayList<JButton>();

    public MenuPanel(String id) {
        super(id);


        playButton = new JButton();
        levelButton = new JButton();
        //scoreButton = new JButton();

        //Adding to ArrayList
        buttons.add(playButton);
        buttons.add(levelButton);
        //buttons.add(scoreButton);

        //Set Bounds
        playButton.setBounds(275,500,75,50);
        levelButton.setBounds(50,500,75,50);
        //scoreButton.setBounds(50,425,75,50);


        playButton.setIcon(new ImageIcon("src/Icons/play.png"));
        levelButton.setIcon(new ImageIcon("src/Icons/levels.png"));
        //scoreButton.setIcon(new ImageIcon("src/Icons/score.png"));

        POWERED_BY = new JLabel("powered by: " +
                "dalton brothers ex borna" +
                " OR " +
                "arman va baghie:/");
        POWERED_BY.setBounds(70, 190, 300, 200);
        POWERED_BY.setFont(new Font("serif", Font.ITALIC, 10));

        this.add(playButton);
        for(JButton b: buttons){
            b.setBackground(backgroundColor);
            b.setFocusable(false);
            b.addActionListener(this);
            b.setBorder(BorderFactory.createEmptyBorder());
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
            add(POWERED_BY);

            //ATTENTION ATTENTION
            // this should change based on profile later on
            middlewareManager.setMiddlewareValue("currentLevel", "1");
        }
        //setLocation(0, 0);

        setBackground(new Color(0x969696));

    }

    // @Override
    // public void paintComponent(Graphics g) {
    //     super.paintComponent(g);

    //     ////System.out.println("menu panel repainting");
    //     ArrayList<Element> elements = elementManager.getElementsByPanel(this);
    //     ////System.out.println(elements);

    //     for (Element element : elements) {
    //         ////System.out.println("from paint component");
    //         element.paintSelf(g);
    //     }
    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==playButton){
            middlewareManager.setMiddlewareValue("currentLevel",
                    (Tools.getWhichLevelWeShouldStartWith(middlewareManager.getMiddlewareValue("userName")) == 0) ? ""+1
                            : ""+(Tools.getWhichLevelWeShouldStartWith(middlewareManager.getMiddlewareValue("userName"))+1));
            middlewareManager.addMiddleware(new ClearLevel(), new MiddlewareLocation());
            middlewareManager.addMiddleware(new LoadGame(Integer.parseInt(middlewareManager.getMiddlewareValue("currentLevel"))), new MiddlewareLocation());
            middlewareManager.addMiddleware(new TransitionPanels("menu", "game"), new MiddlewareLocation());
        }
        else if(e.getSource()==levelButton){
            middlewareManager.addMiddleware(new TransitionPanels("menu", "levels", false), new MiddlewareLocation());
        }
        // else if(e.getSource()==scoreButton){
        //     middlewareManager.addMiddleware(new TransitionPanels("menu", "pause",false), new MiddlewareLocation());
        // }


    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(0xBFBFBF));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(logo, 50, 40, 300, 300, null);
    }
}
