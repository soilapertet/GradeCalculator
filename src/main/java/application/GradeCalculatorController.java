package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class GradeCalculatorController {

    @FXML
    private ChoiceBox<Integer> optionalCodingChallengesChoiceBox;

    @FXML
    private TextField projectGradeLabel;

    @FXML
    private ChoiceBox<Integer> requiredCodingChallengesChoiceBox;

    @FXML
    private Slider quizGradeSlider;

    @FXML
    void calculateGrade(ActionEvent event) {
        double courseGrade = 0.0;

        // Weight for each component
        double projectGradeWeight = 0.5;
        double quizGradeWeight = 0.25;
        double weightOfOneCodingChallenge = 1.25;

        // Calculate weighted project grade
        String projectGradeInput = projectGradeLabel.getText();
        double projectGrade = Double.parseDouble(projectGradeInput); // Convert from string to double data type
        double weightedProjectGrade = projectGrade * projectGradeWeight;
        courseGrade += weightedProjectGrade;
        System.out.printf("Weighted Project Grade: %.2f Course Grade: %.2f\n", weightedProjectGrade, courseGrade);

        // Calculate weighted quiz grade
        double averageQuizGrade = quizGradeSlider.getValue();
        double weightedQuizGrade = (averageQuizGrade / 10) * 100 * quizGradeWeight;
        courseGrade += weightedQuizGrade;
        System.out.printf("Weighted Quiz Grade: %.2f Course Grade: %.2f\n", weightedQuizGrade, courseGrade);

        // Calculate weighted coding challenges grade
        int requiredCodingChallengesPassed = requiredCodingChallengesChoiceBox.getValue();
        int optionalCodingChallengesPassed = optionalCodingChallengesChoiceBox.getValue();
        int codingChallengesPassed = requiredCodingChallengesPassed + optionalCodingChallengesPassed;
        double weightedCodingChallengesGrade = codingChallengesPassed * weightOfOneCodingChallenge;
        courseGrade += weightedCodingChallengesGrade;
        System.out.printf("Weighted Coding Challenges Grade: %.2f Course Grade: %.2f\n",weightedCodingChallengesGrade, courseGrade);

        // Output course grade
        System.out.printf("Course Grade: %.2f\n", courseGrade);
    }

}
