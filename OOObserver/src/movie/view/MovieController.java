package movie.view;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.fxml.Initializable;

public class MovieController implements Initializable {

    @FXML
    private TextField movieTitle;

    @FXML
    private TextField director;

    @FXML
    private TextField releaseYear;

    @FXML
    private TextField writer;

    @FXML
    private Label ratingText;

    @FXML
    private Slider ratingSlider;

    public MovieController() {
    	
    }
	
	public void initialize(URL location, ResourceBundle resources) {
		releaseYear.textProperty().addListener(new ReleaseYearListener());
	}
	
	private class ReleaseYearListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			try{
				if(!newValue.equals("")){
					Integer.parseInt(newValue);
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid entry");
				releaseYear.setText(oldValue);
			}
		}
	}

}
