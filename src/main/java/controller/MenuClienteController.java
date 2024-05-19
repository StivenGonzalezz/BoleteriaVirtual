package controller;

import Logica.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class MenuClienteController {
    //ArrayList<Usuario> DatosUsuarios;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Button btnVolver;
    @javafx.fxml.FXML
    private Button btnEntrarPanelEstudiante;
    @javafx.fxml.FXML
    private Button btnEntrarPanelDocente;
//Constructor vacio
    public MenuClienteController() {
       // DatosUsuarios = new ArrayList<>();
        // inicializar la clase (no c como)

    }
//Constructor con arraylist por parametro//
    public MenuClienteController(ArrayList<Usuario> baseDatosUsuarios) {
        //DatosUsuarios = baseDatosUsuarios;
    }

    @javafx.fxml.FXML
    public void EntrarPanelEstudiante(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        MenuPrincipalController menuPrincipalController= new MenuPrincipalController(Arraylist<Usuario> baseDatosUsuarios);
        //menuprincipalController.setVisible();
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuPrincipal.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @javafx.fxml.FXML
    public void EntrarPanelDocente(ActionEvent actionEvent) {
    }

    @Deprecated
    public void btnEntrarPanelMateria(ActionEvent actionEvent) {
    }

    @Deprecated
    public void gestion(ActionEvent actionEvent) {
    }

    @Deprecated
    public void registro(ActionEvent actionEvent) {
    }
}
