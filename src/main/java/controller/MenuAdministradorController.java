package controller;

import Logica.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class MenuAdministradorController {
    ArrayList<Usuario> baseDatos= new ArrayList<Usuario>();
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Button btnVolver;
    @javafx.fxml.FXML
    private Button btnEntrarPanelEstudiante;
    @javafx.fxml.FXML
    private Button btnEntrarPanelDocente;
// Constructor vacio//
    public MenuAdministradorController() {
        //Hacer visible la clase
    }
    //Constructor con Arraylist//
    public MenuAdministradorController(ArrayList<Usuario> baseDatosUsuarios) {
        //Hacer visible la clase
        baseDatos=baseDatosUsuarios;

    }

    @javafx.fxml.FXML
    public void EntrarPanelEstudiante(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        LoginAdministradorController loginAdministradorController = new LoginAdministradorController();
        //loginAdministradorController.setVisible();
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewLoginAdministrador.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @javafx.fxml.FXML
    public void EntrarPanelDocente(ActionEvent actionEvent) {
    }
}
