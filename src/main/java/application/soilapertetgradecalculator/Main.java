package application.soilapertetgradecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    @Override
    /* Stage primaryStage: Initialise the interface of a JavaFX application
       FXMLLoader loader: Opens and reads FXML files
       Scene scene: Represents the physical contents of a JavaFX application
     */
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        VBox root = loader.load(new FileInputStream
                ("src/main/java/application/soilapertetgradecalculator/GradeCalculatorView.fxml"));

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Soila Pertet's Grade Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
