package inici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegistreController implements Initializable{
    ResultSet rs;
    ConnexioBD con;
    Alert alertError = new Alert(Alert.AlertType.ERROR);
    Alert alertConfirmation = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private Button bContinuar;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private TextField userField;


    @FXML
    void cmdContinuar(ActionEvent event){
        System.out.println("cmdContinuar");
        System.out.println(passwordField.getText());
        int cont = 0;

        try {
            rs = con.queryDB("select * from usuaris");

            while (rs.next()){
                if (rs.getString("usuari").equals(userField.getText())){
                    cont++;
                }
            }
            //si l'usuari ja està agafat
            if (cont != 0){
                alertError.setTitle("Registre");
                alertError.setHeaderText("Usuari repetit");
                alertError.show();
            }
            else {
                //si les contrasenyes coinsideixen
                if (passwordField.getText().equals(newPasswordField.getText())){
                    con.execDB("insert into usuaris values ('" + userField.getText() + "','" + passwordField.getText() + "');");
                    alertConfirmation.setTitle("Registre");
                    alertConfirmation.setHeaderText("Usuari " + userField.getText() + " afegit amb exit!");
                    alertConfirmation.show();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	/*
	public void initialize(Stage primaryStage) {
		System.out.println("initialize");

		try {
			Parent parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
			primaryStage.setTitle("LuxyRestaurant");
			primaryStage.setScene(new Scene(parent));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        con = new ConnexioBD();
    }
}