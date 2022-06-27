package frameManager;

import config.Config;

import javax.swing.*;
import java.awt.*;
import config.Config;

public class APanel extends JPanel{
    String id;
    Boolean active = false;

    public APanel(String id) {
        this.id = id;
        setSize(new Dimension(Config.getFrameWidth(), Config.getFrameHeight()));
        setLayout(null);
        setLocation(0, 0);
        setOpaque(true);
        setVisible(false);
    }

    //----- EVENTS -----
    // you should override this methods in your panel class if needed;

    // if panel is in transition by a for example tansitionPanel middle
    // the middleware emits this event before starting the transition
    // if the panel is replacing by another panel isReplacing will be true
    // if replacing panels doesn't done with transition middleware 
    // this event will not emit;
    public void onPanelTransitionStart(Boolean isReplacing) {

    }

    // if panel is in the final position after transition 
    // and becomes the activePanel this event will emit.
    public void onActivePanel() {
        
    }

    // when panel becomes deactive.
    public void onDeactivePanel() {

    }

    
    // ----- /EVENTS -----
    
    public void setActive(Boolean active) {
        if (active) {
            Config.getFrameManager().setActivePanel(this.id);
        }
        this.active = active;
    } 

    public Boolean isActive() {
        return active;
    }
}
