module com.application.soilapertetgradecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens application.soilapertetgradecalculator to javafx.fxml;
    exports application.soilapertetgradecalculator;
}