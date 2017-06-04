package summerProject;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class TopMenu extends MenuBar {

    private Menu file;

    public TopMenu(){
        file = new Menu("File");
        this.getMenus().add(file);

    }
}
