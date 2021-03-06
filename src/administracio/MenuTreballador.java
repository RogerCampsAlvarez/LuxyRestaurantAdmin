package administracio;

import inici.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuTreballador implements Initializable{
    Pane root;
    Scene scene;
    Stage stage;

    @FXML
    private Button bDesconectar;
    @FXML
    private Button bBarra;
    @FXML
    private Button bCuina;
    @FXML
    private AnchorPane anchorPane1;

    public MenuTreballador() throws MalformedURLException {
    }


    @FXML
    void cmdBarra(ActionEvent event) {

    }

    @FXML
    void cmdCuina(ActionEvent event) {

    }

    @FXML
    void cmdDesconectar(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/inici/Login.fxml"));
            scene = new Scene(root);
            stage = (Stage) bDesconectar.getScene().getWindow();
            Util.openGUI(scene, stage, "Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            anchorPane1.getChildren().setAll((Node) FXMLLoader.load(getClass().getResource("/inici/Login.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}