package controller;

import Logica.Usuario;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class registroController {
    ArrayList<Usuario> baseDatos= new ArrayList<Usuario>();
    @javafx.fxml.FXML
    private ComboBox comboBoxMaterias;
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Button btnVolver;
    @javafx.fxml.FXML
    private TextField txtUser;
    @javafx.fxml.FXML
    private Button btnRegistrar;
    @javafx.fxml.FXML
    private Button btnBuscar;
//Constructor vacio
    public registroController() {
        //Hacer Visible la clase
    }
//Constructor con arraylist//
    public registroController(ArrayList<Usuario> baseDatosUsuarios) {
        //Hacer Visible la clase
        baseDatos= baseDatosUsuarios;
    }

    @javafx.fxml.FXML
    public void registrar(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void buscar(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void eventKey(Event event) {
    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/application/viewMenuF.fxml")));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @javafx.fxml.FXML
    public void materias(ActionEvent actionEvent) {
    }
}
