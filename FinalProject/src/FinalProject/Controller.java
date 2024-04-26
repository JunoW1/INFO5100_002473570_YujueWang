package FinalProject;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import java.awt.Desktop;
import java.net.URL;

public class Controller {
    @FXML
    public void Github_link(){
        String urlString = "https://github.com/JunoW1/INFO5100_002473570_YujueWang";
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
