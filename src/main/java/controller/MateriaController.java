package controller;

import clases.Materia;
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

import java.io.IOException;

public class MateriaController {

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Button btnActualizar;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnVolver;
    @FXML
    private TextField txtCapacidadMaxMateria;
    @FXML
    private TextField txtNombreMateria;
    @FXML
    private TextField txtCodigoMateria;
    @FXML
    private TableColumn <Materia, String> colNombreMateria;
    @FXML
    private TableColumn <Materia, String> colCodigoMateria;
    @FXML
    private TableColumn <Materia, Integer> colCapacidadMax;
    @FXML
    private TableColumn <Materia, Boolean> colIsHabilitable;
    @FXML
    private TableView <Materia> lstMaterias;
    @FXML
    private ToggleGroup habilitable;


    private ObservableList <Materia> materias = FXCollections.observableArrayList();

    @FXML

    public void initialize() {
        colNombreMateria.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNombreMateria.setStyle("-fx-alignment: CENTER-LEFT");
        colCodigoMateria.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colCodigoMateria.setStyle("-fx-alignment: CENTER");
        colCapacidadMax.setCellValueFactory(new PropertyValueFactory<>("capacidadMax"));
        colCapacidadMax.setStyle("-fx-alignment: CENTER");
    }

    @FXML
    public void guardar () {
        if(!"".equals(txtNombreMateria.getText().trim()) && !"".equals(txtCodigoMateria.getText().trim()) && !"".equals(txtCapacidadMaxMateria.getText().trim())) {
            materias.add(new Materia (txtNombreMateria.getText().trim(), txtCodigoMateria.getText().trim(), txtCapacidadMaxMateria.getText().trim()));
            lstMaterias.setItems(materias);
            lstMaterias.refresh();
            txtNombreMateria.setText("");
            txtCodigoMateria.setText("");
            txtCapacidadMaxMateria.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("I.E. CIUDADELA DEL SUR");
            alert.setContentText("Materia registrada.");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Ingrese los campos completos.");
            alert.show();
        }
    }

    @FXML
    public void actualizar (ActionEvent actionEvent) {
        Materia materia = this.lstMaterias.getSelectionModel().getSelectedItem();

        if (materia == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debe seleccionar una materia.");
            alert.show();
        } else {
            String nombre = txtNombreMateria.getText();
            String codigo = txtCodigoMateria.getText();
            String capacidadMax = String.valueOf(Integer.parseInt(txtCapacidadMaxMateria.getText()));

            Materia aux = new Materia (nombre, codigo, capacidadMax);

            if (!this.materias.contains(aux)) {
                materia.setNombre(aux.getNombre());
                materia.setCodigo(aux.getCodigo());
                materia.setCapacidadMax(aux.getCapacidadMax());

                this.lstMaterias.refresh();
            }
            System.out.println("¡Materia actualizada!");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("I.E. CIUDADELA DEL SUR");
            alert.setContentText("¡Materia actualizado!");
            alert.show();
        }
    }

    @FXML
    public void eliminar (ActionEvent actionEvent) {
        Materia materia = this.lstMaterias.getSelectionModel().getSelectedItem();

        if (materia == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Debe seleccionar una materia.");
            alert.show();
        } else {
            this.materias.remove(materia);
            this.lstMaterias.refresh();
            System.out.println("¡Materia eliminado!");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("I.E. CIUDADELA DEL SUR");
            alert.setContentText("¡Materia eliminado!");
            alert.show();
        }
    }


    @FXML
    public void limpiar () {
        txtNombreMateria.clear();
        txtCodigoMateria.clear();
        txtCapacidadMaxMateria.clear();
        System.out.println("¡Campos limpios!");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("I.E. CIUDADELA DEL SUR");
        alert.setContentText("¡Campos limpios!");
        alert.show();
    }

    @FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuF.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void seleccionar(MouseEvent event) {
        Materia materia = this.lstMaterias.getSelectionModel().getSelectedItem();

        if (materia != null) {
            this.txtNombreMateria.setText(materia.getNombre());
            this.txtCodigoMateria.setText(materia.getCodigo());
            this.txtCapacidadMaxMateria.setText(materia.getCapacidadMax()+"");
        }
    }
}