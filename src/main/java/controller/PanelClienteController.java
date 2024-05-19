package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PanelClienteController {

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizar;

    @FXML
    private AnchorPane anchorPane;

    private Stage stage;

    @FXML
    private Button btnVolver;

    private ObservableList<String> listaEstudiantes;

    @FXML
    private TableColumn colApellidosCliente;
    @FXML
    private TextField txtCorreoElectronicoCliente;
    @FXML
    private TableColumn colContraseñaCliente;
    @FXML
    private TextField txtApellidosCliente;
    @FXML
    private TextField txtNombreCliente;
    @FXML
    private TableColumn colCorreoElectronicoCliente;
    @FXML
    private TableView lstClientes;
    @FXML
    private TextField txtPasswordCliente;
    @FXML
    private TextField txtRepetirPasswordCliente;

    public void initialize() {
    }

    @FXML
    public void guardar(ActionEvent actionEvent) {
    }

    @FXML
    public void actualizar (ActionEvent actionEvent) {
    }

    @FXML
    public void eliminar (ActionEvent actionEvent) {
    }

    @FXML
    public void limpiar (ActionEvent actionEvent) {
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
    public void volver(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuAdministrador.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void seleccionar(MouseEvent event) {
    }
}