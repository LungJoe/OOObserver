package movie.view;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import movie.model.MovieObserver;

public class MovieController implements Initializable, Observer {

	@FXML private TextField movieTitle;

	@FXML private TextField director;

	@FXML private TextField releaseYear;

	@FXML private TextField writer;

	@FXML private Label ratingText;

	@FXML private Slider ratingSlider;
	private MovieObserver movieObserver;

	public MovieController(MovieObserver movieObserver) {
		this.movieObserver = movieObserver;
	}

	public void initialize(URL location, ResourceBundle resources) {
		movieTitle.setText("");
		director.setText("");
		releaseYear.setText("");
		writer.setText("");
		ratingSlider.setValue(0);

		ratingText.textProperty().bind(ratingSlider.valueProperty().asString("%,.1f"));
		releaseYear.textProperty().addListener(new ReleaseYearListener());
		movieTitle.textProperty().addListener(new MovieTitleListener());
		director.textProperty().addListener(new MovieDirectorListener());
		writer.textProperty().addListener(new MovieWriterListener());
	}

	public void update(Observable arg0, Object arg1) {
		if (!movieTitle.getText().equals(movieObserver.getMovieTitle()))
			movieTitle.setText(movieObserver.getMovieTitle());

		if (!director.getText().equals(movieObserver.getDirector()))
			director.setText(movieObserver.getDirector());

		if (releaseYear.getText().equals("") || Integer.parseInt(releaseYear.getText()) != movieObserver.getReleaseYear())
			releaseYear.setText(String.valueOf(movieObserver.getReleaseYear()));

		if (!writer.getText().equals(movieObserver.getWriter()))
			writer.setText(movieObserver.getWriter());

		// if(!movieTitle.getText().equals(movieObserver.getMovieTitle()))
		// movieTitle.setText(movieObserver.getMovieTitle());

	}

	private class ReleaseYearListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			try {
				if (!newValue.equals("")) {
					Integer.parseInt(newValue);
					movieObserver.setReleaseYear(Integer.parseInt(newValue));
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry " + e.getMessage());
				releaseYear.setText(oldValue);
			}
		}
	}

	private class MovieTitleListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			movieObserver.setMovieTitle(newValue);
		}
	}
	
	private class MovieDirectorListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			movieObserver.setDirector(newValue);
		}
	}
	
	private class MovieWriterListener implements ChangeListener<String> {
		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
			movieObserver.setWriter(newValue);
		}
	}
}
