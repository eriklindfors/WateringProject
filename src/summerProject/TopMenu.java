package summerProject;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class TopMenu extends MenuBar {

    private Menu file = new Menu("File");;
    private MenuItem exit = new MenuItem("Exit");

    public TopMenu(){
        exit.setOnAction(e -> {
            Platform.exit();
        });
        file.getItems().add(exit);
        this.getMenus().add(file);
    }
}
