package application;

import controller.MenuPrincipalController;
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
// desde el menuprincipalcontroller se abrirán las demas vistas//
    //public static void main(String[] args) {
      //  launch(MenuPrincipalController(//lanza el que tiene el arraylist por parametro//));
    //}
    public static void main(String[] args) {
        launch();
    }

}