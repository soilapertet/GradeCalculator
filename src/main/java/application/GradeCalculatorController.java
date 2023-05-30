package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class GradeCalculatorController {

    @FXML
    private ChoiceBox<?> OptionalCodingChallengesChoiceBox;

    @FXML
    private TextField projectGradeLabel;

    @FXML
    private ChoiceBox<?> requiredCodingChallengesChoiceBox;

    @FXML
    private Slider quizGradeSlider;

    @FXML
    void calculateGrade(ActionEvent event) {
        System.out.println("Button clicked!");
    }

}
