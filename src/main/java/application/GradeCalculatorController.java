package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class GradeCalculatorController {

    @FXML
    private Label courseGradeLabel;

    @FXML
    private TextField projectGradeLabel;

    @FXML
    private ChoiceBox<Integer> requiredCodingChallengesChoiceBox;

    @FXML
    private ChoiceBox<Integer> optionalCodingChallengesChoiceBox;

    @FXML
    private Label errorLabel;

    @FXML
    private Slider quizGradeSlider;

    @FXML
    void calculateGrade(ActionEvent event) {
        double courseGrade = 0.0;

        // Weight for each component
        double projectGradeWeight = 0.5; // Project worth 50%
        double quizGradeWeight = 0.25; // Quizzes worth 25%
        double weightOfOneCodingChallenge = 25.0 / 20; // Coding challenges worth 25%; need to complete 20 CCs

        // Calculate weighted project grade
        double weightedProjectGrade = calculateProjectGrade(projectGradeWeight);
        courseGrade += weightedProjectGrade;

        // Debugging purposes
        System.out.printf("Weighted Project Grade: %.2f Course Grade: %.2f\n", weightedProjectGrade, courseGrade);

        // Calculate weighted quiz grade
        double averageQuizGrade = quizGradeSlider.getValue();
        double weightedQuizGrade = (averageQuizGrade / 10) * 100 * quizGradeWeight;
        courseGrade += weightedQuizGrade;

        // Debugging purposes
        System.out.printf("Weighted Quiz Grade: %.2f Course Grade: %.2f\n", weightedQuizGrade, courseGrade);

        // Calculate weighted coding challenges grade
        int requiredCodingChallengesPassed = requiredCodingChallengesChoiceBox.getValue();
        int optionalCodingChallengesPassed = optionalCodingChallengesChoiceBox.getValue();
        int codingChallengesPassed = requiredCodingChallengesPassed + optionalCodingChallengesPassed;
        double weightedCodingChallengesGrade = codingChallengesPassed * weightOfOneCodingChallenge;
        courseGrade += weightedCodingChallengesGrade;

        // Debugging purposes
        System.out.printf("Weighted Coding Challenges Grade: %.2f Course Grade: %.2f\n",weightedCodingChallengesGrade, courseGrade);

        // Output course grade
        courseGradeLabel.setText("Overall Course Grade: " + courseGrade + "%");
    }

    // Validate project grade input and check if it's a number
    public boolean validateProjectGrade(String gradeAsString) {
        boolean isValid = true;
        int i = 0;
        int decimalPointCount = 0;

        while(isValid && i < gradeAsString.length()) {
            char c = gradeAsString.charAt(i);

            if(!Character.isDigit(c) && c != '-' && c != '.' && c != '%') {
                errorLabel.setText(gradeAsString + " is not a number. Please enter a number.");
                isValid = false;
            } else if(c == '.') {

                if(decimalPointCount >= 1){
                    errorLabel.setText(gradeAsString + " has more than one decimal point. Please use one decimal point");
                    isValid = false;
                } else {
                    decimalPointCount++;
                }
            } else if(c == '%'){
                errorLabel.setText("Do not use " + c + " in project grade.");
                isValid = false;
            }

            i++;

        }

        return isValid;
    }

    // Validate project grade is within the inclusive range 0 - 100
    // Calculate and return weighted projected grade
    public double calculateProjectGrade(double projectGradeWeight){
        double projectGrade = 0.0;
        String gradeInput = projectGradeLabel.getText();
        boolean validInput = validateProjectGrade(gradeInput);

        if(validInput){
            double projectGradeInput = Double.parseDouble(gradeInput);
            if(projectGradeInput < 0 || projectGradeInput > 100){
                errorLabel.setText("Project grade should be between 0 and 100.");
            } else {
                projectGrade = projectGradeInput;
            }
        }

        return projectGrade * projectGradeWeight;
    }

}
