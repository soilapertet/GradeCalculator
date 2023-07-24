module com.application.soilapertetgradecalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens application to javafx.fxml;
    exports application;
    exports oosequence;
}