import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField and;

    @FXML
    private TextField or;

    @FXML
    private TextField not;

    @FXML
    private Button go;

    @FXML
    private ChoiceBox<?> choix;

    @FXML
    void initialize() {
        assert and != null : "fx:id=\"and\" was not injected: check your FXML file 'Sample.fxml'.";
        assert or != null : "fx:id=\"or\" was not injected: check your FXML file 'Sample.fxml'.";
        assert not != null : "fx:id=\"not\" was not injected: check your FXML file 'Sample.fxml'.";
        assert go != null : "fx:id=\"go\" was not injected: check your FXML file 'Sample.fxml'.";
        assert choix != null : "fx:id=\"choix\" was not injected: check your FXML file 'Sample.fxml'.";

    }
}
