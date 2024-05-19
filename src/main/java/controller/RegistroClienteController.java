package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

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
    }
}
