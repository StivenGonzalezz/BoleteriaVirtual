package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TaquillaVirtualController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnVolver;

    @FXML
    private RadioButton RadioButtonCategoriaBronce;
    @FXML
    private TextField txtCantidadBoletas;
    @FXML
    private ToggleGroup Categoria;
    @FXML
    private RadioButton RadioButtonCategoriaOro;
    @FXML
    private Button btnComprar;
    @FXML
    private RadioButton RadioButtonCategoriaPlata;
    @FXML
    private ComboBox ComboBoxNotas;

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void comprar(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewProcesoPago.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }
}