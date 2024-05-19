package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class PanelEventosController {

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
    private TableColumn colDisponibilidadBoletaPlataEvento;
    @FXML
    private TextField txtNombreEvento;
    @FXML
    private TableColumn colDisponibilidadBoletaCobreEvento;
    @FXML
    private TableColumn colNombreEvento;
    @FXML
    private TableColumn colPrecioBoletaOroEvento;
    @FXML
    private TableColumn colLugarEvento;
    @FXML
    private TextField txtPrecioBoletaPlataEvento;
    @FXML
    private TextField txtPrecioBoletaOroEvento;
    @FXML
    private TextField txtCantidadBoletasEvento;
    @FXML
    private TextField txtArtistasEvento;
    @FXML
    private TableColumn colPrecioBoletaCobreEvento;
    @FXML
    private TableView lstEventos;
    @FXML
    private TextField txtFechaEvento;
    @FXML
    private TableColumn colDisponibilidadBoletaOroEvento;
    @FXML
    private TableColumn colArtistasEvento;
    @FXML
    private TableColumn colPrecioBoletaPlataEvento;
    @FXML
    private TableColumn colFechaEvento;
    @FXML
    private TextField txtPrecioBoletaBronceEvento;
    @FXML
    private TextField txtLugarEvento;
    @FXML
    private TextField txtHoraEvento;

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
        txtNombreEvento.clear();
        txtFechaEvento.clear();
        txtHoraEvento.clear();
        txtLugarEvento.clear();
        txtArtistasEvento.clear();
        txtCantidadBoletasEvento.clear();
        txtPrecioBoletaBronceEvento.clear();
        txtPrecioBoletaPlataEvento.clear();
        txtPrecioBoletaOroEvento.clear();
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