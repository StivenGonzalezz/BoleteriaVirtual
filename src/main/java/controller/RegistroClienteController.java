package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class RegistroClienteController {
    ArrayList<Usuario> datosClientes= new ArrayList<Usuario>();
    @FXML
    private TextField txtApellidosCliente;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField txtCorreoElectronicoCliente;
    @FXML
    private Button btnVolver;
    @FXML
    private TextField txtNombreCliente;
    @FXML
    private TextField txtPasswordCliente;
    @FXML
    private TextField txtRepetirPasswordCliente;
    @FXML
    private Button btnConRegUser;
    //Constructor solo//
    public RegistroClienteController() {
        //Hacer visible la clase

    }
//Constructor con arraylist
    public RegistroClienteController(ArrayList<Usuario> baseDatosUsuarios) {
        // Hacer visible la clase
        datosClientes=baseDatosUsuarios;
    }



    @FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        MenuPrincipalController menuPrincipalController= new MenuPrincipalController();
        //menuPrincipalController.setVisible();
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuPrincipal.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void registroUser(ActionEvent actionEvent) {
        registroController registroController= new registroController();
        //registroController.setVisible();

    }
}
