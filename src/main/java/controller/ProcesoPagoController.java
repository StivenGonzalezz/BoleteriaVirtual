package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProcesoPagoController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnVolver;
    @FXML
    private DatePicker datePickerFechaExpiracionTarjeta;
    @FXML
    private ComboBox ComboBoxEntidades;
    @FXML
    private TextField txtCvcTarjeta;
    @FXML
    private Button btnPagar;
    @FXML
    private TextField txtNumeroTarjeta;

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewTaquillaVirtual.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @FXML
    public void pagar(ActionEvent actionEvent) {
    }
}