package middlewareManager.middlewares;

import config.Config;
import frameManager.APanel;
import frameManager.FrameManager;

// ----- SHOWPANEL -----
/*
 * this middleware gets panel id and make it active
 */
// ---- /SHOWPANEL -----

public class ShowPanel extends Middleware{
    String panelId;
    public ShowPanel(String panelId) {
        super("showPanel");
        this.panelId = panelId;
    }

    public void init() {
        FrameManager frameManager = Config.getFrameManager();
        APanel panel = frameManager.getAPanel(panelId);

        if (panel != null) {
            APanel activePanel = frameManager.getActivePanel();
            if (activePanel != null) {
                activePanel.setVisible(false);
                activePanel.onDeactivePanel();
            }

            panel.setLocation(0, 0);
            panel.onActivePanel();
            panel.setVisible(true);
        }

        this.remove();
    }
}
