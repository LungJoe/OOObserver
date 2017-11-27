package movie.model;

import java.util.Observable;

public class MovieObserver extends Observable{
	private Movie movie;
	
	public MovieObserver(){
		movie = Movie.getInstance();
	}
	
	public String getMovieTitle() {
		return movie.getMovieTitle();
	}

	public void setMovieTitle(String movieTitle) {
		this.movie.setMovieTitle(movieTitle);
		this.setChanged();
		this.notifyObservers();
	}

	public int getReleaseYear() {
		return movie.getReleaseYear();
	}

	public void setReleaseYear(int releaseYear) {
		this.movie.setReleaseYear(releaseYear);
		this.setChanged();
		this.notifyObservers();
	}

	public String getDirector() {
		return movie.getDirector();
	}

	public void setDirector(String director) {
		this.movie.setDirector(director);
		this.setChanged();
		this.notifyObservers();
	}

	public String getWriter() {
		return movie.getWriter();
	}

	public void setWriter(String writer) {
		this.movie.setWriter( writer);
		this.setChanged();
		this.notifyObservers();
	}

	public int getRating() {
		return movie.getRating();
	}

	public void setRating(int rating) {
		this.movie.setRating(rating);
		this.setChanged();
		this.notifyObservers();
	}
}
