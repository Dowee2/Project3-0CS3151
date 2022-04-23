package edu.westga.CS3151.AnimalGuessing.view;

import edu.westga.CS3151.AnimalGuessing.model.Guesser;
import edu.westga.CS3151.AnimalGuessing.model.Guesser.YesOrNo;
import javafx.event.ActionEvent;
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
    
    private Guesser animalGuesser;
    
    private boolean isGuessing;

    @FXML
    void OnNoButtonClick(ActionEvent event) {
    	if (this.isGuessing) {
    		this.setActivePane(this.wrongGuessPane);
    	} else {
    		this.isGuessing = this.animalGuesser.questionAnswered(YesOrNo.NO);
    		this.setGuessTextArea();
    	}
    	
    }

    @FXML
    void OnStartButtonClick(ActionEvent event) {
    	this.setActivePane(this.questionGuessPane);
    	this.setGuessTextArea();
    }

    @FXML
    void OnYesButtonClick(ActionEvent event) {
    	if (this.isGuessing) {
    		this.setActivePane(this.startPane);
    	} else {
    		this.isGuessing = this.animalGuesser.questionAnswered(YesOrNo.YES);
    		this.setGuessTextArea();
    	}
    }

    @FXML
    void onPlayerSubmit(ActionEvent event) {
    	this.animalGuesser.guessedWrong(this.playerAnimalTextField.getText(), this.playerQuestionTextField.getText(), this.getSelectedRadioButton());
    	this.playerAnimalTextField.setText("");
    	this.playerQuestionTextField.setText("");
    	this.setActivePane(startPane);
    	this.isGuessing = false;
    }
    
    private YesOrNo getSelectedRadioButton() {
    	if(this.noRadioButton.isSelected()) {
    		return YesOrNo.NO;
    	}
    	
    	return YesOrNo.YES;
    }

    private void setActivePane(Pane displayedPane) {
    	
    	if (displayedPane == this.startPane) {
    		this.disablePane(this.questionGuessPane);
    		this.disablePane(this.wrongGuessPane);
    		this.enablePane(this.startPane);
    	} else if (displayedPane == this.questionGuessPane) {
    		this.disablePane(this.startPane);
    		this.disablePane(this.wrongGuessPane);
    		this.enablePane(this.questionGuessPane);
    	} else {
    		this.disablePane(this.questionGuessPane);
    		this.disablePane(this.startPane);
    		this.enablePane(this.wrongGuessPane);
    	}
    }
    
    private void disablePane(Pane pane) {
    	pane.setDisable(true);
    	pane.setVisible(false);
    }
    
    private void enablePane(Pane pane) {
    	pane.setDisable(false);
    	pane.setVisible(true);
    }

    @FXML
	private void initialize() {
		this.animalGuesser = new Guesser();
		this.setActivePane(startPane);
		this.isGuessing = this.animalGuesser.guessMade;
	}
    
    private void setGuessTextArea() {
    	this.guessTextArea.setText(this.animalGuesser.getCurrentValue());
    }
}