package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginAdministradorController {
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void login(ActionEvent actionEvent) throws IOException {

        String documento = "12345";
        String contrasenia = "12345";

        if (txtPassword.getText().equals(contrasenia) && txtUser.getText().equals(documento)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("FUTURE AGENCY");
            alert.setContentText("Sesión iniciada.");
            alert.show();
            Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuAdministrador.fxml"));
            anchorPane.getChildren().removeAll();
            anchorPane.getChildren().setAll(fxml);

        } else if (txtUser.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Ingrese ambos campos completos.");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Datos incorrectos.");
            alert.show();

        }
    }

    @FXML
    public void eventKey (KeyEvent event) {

    }

    @FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuPrincipal.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }
}
