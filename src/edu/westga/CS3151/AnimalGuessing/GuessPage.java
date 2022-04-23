package edu.westga.CS3151.AnimalGuessing;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GuessPage {

    @FXML
    private Pane startPane;

    @FXML
    private Button startButton;

    @FXML
    private Pane questionGuessPane;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    private Text guessTextArea;

    @FXML
    private Pane wrongGuessPane;

    @FXML
    private TextField playerQuestionTextField;

    @FXML
    private TextField playerAnimalTextField;

    @FXML
    private RadioButton yesRadioButton;

    @FXML
    private ToggleGroup group1;

    @FXML
    private RadioButton noRadioButton;

    @FXML
    private Button playerGuessSubmitButton;

    @FXML
    void OnNoButtonClick(ActionEvent event) {

    }

    @FXML
    void OnStartButtonClick(ActionEvent event) {

    }

    @FXML
    void OnYesButtonClick(ActionEvent event) {

    }

    @FXML
    void onPlayerSubmit(ActionEvent event) {

    }

    private void disableAllPaneExcept(Pane displayedPane) {

        switch (displayedPane) {
            case this.startPane:
                
                break;
            
            case this.questionGuessPane:
                
                break;
            
            case this.wrongGuessPane:
                
                break;
        
            default:
                break;
        }
        
    }

}
