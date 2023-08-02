package application;

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
        VBox root = loader.load(new FileInputStream("src/main/java/application/GradeCalculatorView.fxml"));

        // Get the controller after loading FXML loader file (we need to type cast)
        GradeCalculatorController controller = (GradeCalculatorController)loader.getController();

        // "Give" the primary stage to the controller; allows us to access the main stage of the application
        controller.applicationStage = primaryStage;

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Soila Pertet's Grade Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {launch(args);}
}
