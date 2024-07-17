module com.app.commerce {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.app.commerce to javafx.fxml;
    exports com.app.commerce;
    exports com.app.commerce.controller;
    opens com.app.commerce.controller to javafx.fxml;
}