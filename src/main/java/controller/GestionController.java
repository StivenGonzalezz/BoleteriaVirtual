package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionController {

    @FXML
    private ComboBox comboBoxMaterias;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnAgregarNota;
    @FXML
    private Button btnCerrarMateria;
    @FXML
    private TableView lstEstudiantes;

    @FXML
    public void agregarNota(ActionEvent actionEvent) throws IOException {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/viewNotas.fxml"));
        Parent root = loader.load();
        NotasController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("I.E. CIUDADELA DEL SUR");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuF.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void cerrarMateria(ActionEvent actionEvent) {
    }

    @FXML
    public void materias(ActionEvent actionEvent) {
    }
}
