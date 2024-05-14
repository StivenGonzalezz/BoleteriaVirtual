package controller;

import clases.Nota;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NotasController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnAsignar;
    @FXML
    private ComboBox <Nota> ComboBoxNotas;
    @FXML
    private TextField txtNota;
    private ObservableList <Nota> notas;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        notas = FXCollections.observableArrayList();

        notas.add(new Nota("Nota 1"));
        notas.add(new Nota("Nota 2"));
        notas.add(new Nota("Nota 3"));
        notas.add(new Nota("Nota 4"));

        ComboBoxNotas.setItems(notas);
    }

    @FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void asignar(ActionEvent actionEvent) {
        String text = txtNota.getText();
        float num = Float.parseFloat(text);

        if (num >= 0.0 && num <= 5.0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("I.E. CIUDADELA DEL SUR");
            alert.setContentText("Nota agregada.");
            alert.show();

        } else if (num < 0.0 || num > 5.0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Ingrese una nota entre el rango de 0.0 a 5.0.");
            alert.show();

        } else if (text.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Ingrese el campo completo.");
            alert.show();
        }
    }
}