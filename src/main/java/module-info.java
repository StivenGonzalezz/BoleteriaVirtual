module com.example.boleteriavirtual {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.boleteriavirtual to javafx.fxml;
    exports com.example.boleteriavirtual;
}