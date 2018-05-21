package inici;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
	ResultSet rs;
	ConnexioBD con;

	@FXML
	private Button bContinuar;
	@FXML
	private PasswordField passwordField;
	@FXML
	private TextField userField;


	@FXML
	void cmdContinuar(ActionEvent event){
		System.out.println("cmdContinuar");
		System.out.println(passwordField.getText());

		Alert alert = new Alert(Alert.AlertType.ERROR);
		int cont = 0;

		try {
			rs = con.queryDB("select * from usuaris");

			while (rs.next()){
                if (rs.getString("usuari").equals(userField.getText()) && rs.getString("contrasenya").equals(passwordField.getText())){
                	cont ++;
				}
            }

			//usuari o contrasenya incorrecta
			if (cont == 0){
				alert.setTitle("Login");
				alert.setHeaderText("Usuari o contrasenya incorrecta");
				alert.show();
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