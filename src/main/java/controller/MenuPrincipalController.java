package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MenuPrincipalController {
    //ArrayList<Usuario> baseDatosUsuarios;
    //Arraylist<Usuario> DatosUsuarios = baseDatosUsuarios;
    MenuPrincipalController menuPrincipalController = new MenuPrincipalController();

    @FXML
    private Button btnClickAdministrador;
    private Stage stage;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUser;
    @FXML
    private Button btnRegistrar;
    @FXML
    private PasswordField txtPassword;

    @FXML
    public void ingresar(ActionEvent actionEvent) throws IOException {

        String documento = "12345";
        String contrasenia = "12345";

        if (txtPassword.getText().equals(contrasenia) && txtUser.getText().equals(documento)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("FUTURE AGENCY");
            alert.setContentText("Sesión iniciada.");
            alert.show();
            Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuCliente.fxml"));
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
    public void clickAdministrador(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewLoginAdministrador.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void registrar(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewRegistroCliente.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void eventKey(Event event) {
    }
// Constructor vacio
    public MenuPrincipalController() {
    }
    // Constructor que pasa el arraylist
    /**public MenuPrincipalController(Arraylist<Usuario> DatosUsuarios) {
        this.DatosUsuarios = DatosUsuarios;
    }
     **/
}