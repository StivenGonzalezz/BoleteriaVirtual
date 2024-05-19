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
    //Usuario persona ="daniel "+ "lopez "+"1034"+" 2004" +" csca@gmail.com";
    ArrayList<Usuario> baseDatosUsuarios;
    ArrayList<Usuario> DatosUsuarios;
    MenuPrincipalController menuPrincipalController = new MenuPrincipalController();

    public ArrayList<Usuario> getBaseDatosUsuarios() {
        return baseDatosUsuarios;
    }


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
        baseDatosUsuarios.add(persona);
        System.out.println(baseDatosUsuarios);
        MenuClienteController menuClienteController= new MenuClienteController(baseDatosUsuarios);
        //menuClienteController.setVisible(true);

        String documento = "12345";
        String contrasenia = "12345";

        if (txtPassword.getText().equals(contrasenia) && txtUser.getText().equals(documento)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("FUTURE AGENCY");
            alert.setContentText("Sesión iniciada.");
            alert.show();
            String link = "/application/viewMenuCliente.fxml";
            Parent fxml = avanzar(link);
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
        LoginAdministradorController loginAdministradorController= new LoginAdministradorController(baseDatosUsuarios);
        //loginAdministradorController.setVisible();
        String link = "/application/viewLoginAdministrador.fxml";
        Parent fxml = avanzar(link);
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void registrar(ActionEvent actionEvent) throws IOException {
        RegistroClienteController registroClienteController = new RegistroClienteController(baseDatosUsuarios);
        //registroClienteController.setVisible();
        String link = "/application/viewRegistroCliente.fxml";
        Parent fxml = avanzar(link);
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void eventKey(Event event) {
    }
    // Constructor vacio
    public MenuPrincipalController() {
        //Hacer visible la clase
    }
    // Constructor que pasa el arraylist
    public MenuPrincipalController(ArrayList<Usuario> baseDatosUsuarios) {
     // hacer visible la clase
     this.DatosUsuarios = baseDatosUsuarios;

     }

    public Parent avanzar (String link) throws IOException {
        Parent avanzar = null;
        if (link == "/application/viewMenuCliente.fxml") {
            avanzar = FXMLLoader.load(getClass().getResource("/application/viewMenuCliente.fxml"));
        }else if (link == "/application/viewLoginAdministrador.fxml") {
            avanzar = FXMLLoader.load(getClass().getResource("/application/viewLoginAdministrador.fxml"));
        }else if (link == "/application/viewRegistroCliente.fxml"){
            avanzar = FXMLLoader.load(getClass().getResource("/application/viewRegistroCliente.fxml"));
        }

        return avanzar;

    }
}