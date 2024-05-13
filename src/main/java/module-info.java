module com.example.boleteriavirtual {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.boleteriavirtual to javafx.fxml;
    exports com.example.boleteriavirtual;
}