package controller;

import Logica.Boleteria;
import Logica.Persistencia;
import Logica.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RegistroClienteController {
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
    private TextField txtDocumentoCliente;
    @FXML
    private TextField txtPasswordCliente;
    @FXML
    private TextField txtRepetirPasswordCliente;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Button btnRegistrar;

    @FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuPrincipal.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void Limpiar(ActionEvent actionEvent) {
        txtNombreCliente.clear();
        txtApellidosCliente.clear();
        txtCorreoElectronicoCliente.clear();
        txtPasswordCliente.clear();
        txtRepetirPasswordCliente.clear();
        System.out.println("¡Campos limpios!");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("FUTURE AGENCY");
        alert.setContentText("¡Campos limpios!");
        alert.show();
    }

    @FXML
    public void registrar(ActionEvent actionEvent) {


        Persistencia archivos = new Persistencia();
        ArrayList<Usuario> baseDatosUsuarios = archivos.leerArchivoUsers();


        if (txtNombreCliente.getText().isEmpty() || txtApellidosCliente.getText().isEmpty() ||
                txtCorreoElectronicoCliente.getText().isEmpty() || txtPasswordCliente.getText().isEmpty() ||
                txtRepetirPasswordCliente.getText().isEmpty()){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Ingrese todos campos.");
            alert.show();

        }else if ((!Objects.equals(txtPasswordCliente.getText(), txtRepetirPasswordCliente.getText()))){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("La contraseñas no coinciden");
            alert.show();
        }else{

            String documento = txtDocumentoCliente.getText();
            Usuario usuario = Boleteria.buscarUsuario(documento, baseDatosUsuarios, archivos);
            if (usuario == null){

                baseDatosUsuarios.add(new Usuario(txtNombreCliente.getText(), txtApellidosCliente.getText(), txtDocumentoCliente.getText(), txtPasswordCliente.getText(), txtCorreoElectronicoCliente.getText()));
                archivos.escribirArchivoUsers(baseDatosUsuarios);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("REGISTRADO");
                alert.setContentText("Registro exitoso");
                alert.show();

                txtDocumentoCliente.clear();
                txtNombreCliente.clear();
                txtApellidosCliente.clear();
                txtCorreoElectronicoCliente.clear();
                txtPasswordCliente.clear();
                txtRepetirPasswordCliente.clear();
            }
        }
    }
}