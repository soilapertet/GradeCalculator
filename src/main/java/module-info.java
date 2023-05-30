module com.application.soilapertetgradecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.application.soilapertetgradecalculator to javafx.fxml;
    exports com.application.soilapertetgradecalculator;
}