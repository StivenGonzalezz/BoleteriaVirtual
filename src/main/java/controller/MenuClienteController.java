package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuClienteController {
    @javafx.fxml.FXML
    private AnchorPane anchorPane;
    @javafx.fxml.FXML
    private Button btnVolver;
    @javafx.fxml.FXML
    private Button btnEntrarPanelEstudiante;
    @javafx.fxml.FXML
    private Button btnEntrarPanelDocente;

    @javafx.fxml.FXML
    public void EntrarPanelEstudiante(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("/application/viewMenuPrincipal.fxml"));
        anchorPane.getChildren().removeAll();
        anchorPane.getChildren().setAll(fxml);
    }

    @javafx.fxml.FXML
    public void EntrarPanelDocente(ActionEvent actionEvent) {
    }

    @Deprecated
    public void btnEntrarPanelMateria(ActionEvent actionEvent) {
    }

    @Deprecated
    public void gestion(ActionEvent actionEvent) {
    }

    @Deprecated
    public void registro(ActionEvent actionEvent) {
    }
}
