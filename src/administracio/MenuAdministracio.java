package administracio;

import inici.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAdministracio {
    Pane root;
    Scene scene;
    Stage stage;

    @FXML
    private Button bRegistrarUsuari;
    @FXML
    private Button bDesconectar;
    @FXML
    private Button bGestionarSales;
    @FXML
    private Button bGestionarTaules;
    @FXML
    private Button bGestionarAliments;
    @FXML
    private Button bGestionarBegudes;
    @FXML
    private Button bComptabilitat;

    @FXML
    void cmdRegistrarUsuari(ActionEvent event){
        try {
            root = FXMLLoader.load(getClass().getResource("/inici/Registre.fxml"));
            scene = new Scene(root);
            stage = (Stage) bRegistrarUsuari.getScene().getWindow();
            Util.openGUI(scene, stage, "Registre");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void cmdGestionarSales(ActionEvent event) {

    }

    @FXML
    void cmdGestionarTaules(ActionEvent event) {

    }

    @FXML
    void cmdGestionarAliments(ActionEvent event) {

    }

    @FXML
    void cmdGestionarBegudes(ActionEvent event) {

    }

    @FXML
    void cmdComptabilitat(ActionEvent event) {

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
}