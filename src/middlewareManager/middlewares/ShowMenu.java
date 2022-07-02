package middlewareManager.middlewares;

import frameManager.APanel;

public class ShowMenu extends Middleware {
    public ShowMenu() {
        super("showMenu");
    }

    @Override
    public void init() {
//        ////System.out.println("init of showMenu");
        APanel menuPanel = this.frameManager.getAPanel("menu");
        menuPanel.setVisible(true);
//        ////System.out.println(menuPanel);
        this.remove();
    }
}