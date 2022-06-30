package frameManager.panels;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

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
    JButton hintButton;
    public JLabel timeLabel = new JLabel();

    public GamePanel(String id) {
        super(id);
        // if(middlewareManager.getMiddlewareValue("buttonColor").equals("1"))
        //     this.backgroundColor = Color.RED;
        setLocation(0, 0);
        setBackground(backgroundColor);
        setFocusable(true);
        pauseButton = new JButton();
        pauseButton.setBounds(15, 15, 50, 50);
        pauseButton.setBackground(backgroundColor);
        pauseButton.setBorder(BorderFactory.createEmptyBorder());
        pauseButton.setFocusable(false);
        pauseButton.setIcon(new ImageIcon("src/Icons/pause.png"));
        pauseButton.addActionListener(this);
        hintButton = new JButton();
        hintButton.setBounds(162, 10,100,85);
        hintButton.setIcon(new ImageIcon("src/Icons/hint.png"));
        hintButton.setFocusable(false);
        hintButton.setBackground(backgroundColor);
        hintButton.setBorder(BorderFactory.createEmptyBorder());
        hintButton.addActionListener(this);
        timeLabel.setBounds(15, 510, 200, 60);
        timeLabel.setIcon(new ImageIcon("src/Icons/time.png"));
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
        this.add(hintButton);
        this.add(timeLabel);
        this.addKeyListener(new myKeyListener());
    }

    public void setButtonColor(Color c){
        //this.backgroundColor = c;
        pauseButton.setBackground(c);
        hintButton.setBackground(c);
    }

    public JLabel getTimerLevel(){
        return timeLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pauseButton){
            middlewareManager.addMiddleware(new Pause("game", true), new MiddlewareLocation());
            middlewareManager.addMiddleware(new TransitionPanels("game", "pause"), new MiddlewareLocation());
        }
        if(e.getSource()==hintButton){
            middlewareManager.addMiddleware(new AutoShooter(), new MiddlewareLocation());
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Element> elements = elementManager.getElementsByPanel(this);

        for (Element element : elements) {
            element.paintSelf(g);
        }
    }    

   
    

}
//THIS IS FOR TEST
//TODO implement a real keylistener
class myKeyListener implements KeyListener{
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed");
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_SPACE){
            Config.getMiddlewareManager().addMiddleware(new SelectShootBall(), new MiddlewareLocation());
            //TODO uncomment Select shoot ball (Auto shoot is jist for test)
            Config.getMiddlewareManager().addMiddleware(new SelectShootBall(), new MiddlewareLocation());
            //Config.getMiddlewareManager().addMiddleware(new AutoShooter(), new MiddlewareLocation());

            //TODO uncomment Select shoot ball (Auto shoot is jist for test)
            Config.getMiddlewareManager().addMiddleware(new SelectShootBall(), new MiddlewareLocation());
            //Config.getMiddlewareManager().addMiddleware(new AutoShooter(), new MiddlewareLocation());

        }
    }

    @Override
    public void keyReleased (KeyEvent e){

    }

    @Override
    public void keyTyped (KeyEvent e){

    }
   

    
}
