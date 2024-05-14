module com.example.boleteriavirtual {
    requires javafx.controls;
    requires javafx.fxml;
    opens application to javafx.fxml;
    exports application;
    exports controller;
    opens controller to javafx.fxml;
    opens clases;
}

