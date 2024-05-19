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

public class CatalogoEventosController {

    @FXML
    private AnchorPane anchorPane;

    private Stage stage;

    @FXML
    private Button btnVolver;

    private ObservableList<String> listaEstudiantes;
    @FXML
    private TableColumn colDisponibilidadBoletaPlataEvento;
    @FXML
    private TableColumn colDisponibilidadBoletaCobreEvento;
    @FXML
    private TableColumn colNombreEvento;
    @FXML
    private TableColumn colPrecioBoletaOroEvento;
    @FXML
    private TableColumn colLugarEvento;
    @FXML
    private TableColumn colPrecioBoletaCobreEvento;
    @FXML
    private TableView lstEventos;
    @FXML
    private TableColumn colDisponibilidadBoletaOroEvento;
    @FXML
    private TableColumn colArtistasEvento;
    @FXML
    private TableColumn colPrecioBoletaPlataEvento;
    @FXML
    private TableColumn colFechaEvento;

    public void initialize() {
    }

    @FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuCliente.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void seleccionar(MouseEvent event) {
    }

}