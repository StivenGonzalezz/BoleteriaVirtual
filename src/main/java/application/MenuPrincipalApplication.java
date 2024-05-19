package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
//private  MenuPrincipalController;
public class MenuPrincipalApplication extends Application{


  //  MenuPrincipalController menuPrincipalController = new MenuPrincipalController(ArrayList<Usuario> DatosUsuarios);
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MenuPrincipalApplication.class.getResource("viewMenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("FUTURE AGENCY");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}