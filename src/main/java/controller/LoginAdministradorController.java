package controller;

import Logica.Usuario;
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
import java.util.ArrayList;

public class LoginAdministradorController {
    private ArrayList<Usuario> datosUsuario1;

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
//constructor vacio//
    public LoginAdministradorController() {
        //hacer visible la clase no c como//

    }
// constructor con arraylist//
    public LoginAdministradorController(ArrayList<Usuario> baseDatosUsuarios) {
        // hacer visible la clase//
        datosUsuario1=baseDatosUsuarios;

    }

    @FXML
    public void login(ActionEvent actionEvent) throws IOException {

        String documento = "12345";
        String contrasenia = "12345";

        if (txtPassword.getText().equals(contrasenia) && txtUser.getText().equals(documento)) {
            MenuAdministradorController menuAdministradorController= new MenuAdministradorController(ArrayList<Usuario> baseDatosUsuarios);
            //menuAdministradorController.setVisible();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("FUTURE AGENCY");
            alert.setContentText("Sesión iniciada.");
            alert.show();
            Parent OtraPagina = avanzar();
            anchorPane.getChildren().removeAll();
            anchorPane.getChildren().setAll(OtraPagina);


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
        MenuPrincipalController menuPrincipalController= new MenuPrincipalController(Arraylist<Usuario> datosUsuario1);
        //menuprincipalController.setVisible();
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuPrincipal.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }
    public Parent avanzar () throws IOException{
        Parent avanzar = FXMLLoader.load(getClass().getResource("/application/viewMenuAdministrador.fxml"));
        return avanzar;

    }
}
