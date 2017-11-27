package movie.model;

public class Movie {
	private static Movie firstInstanceOfMovie = null;
	private String movieTitle;
	private int releaseYear;
	private String director;
	private String writer;
	private int rating;
	
	public static int count = 0;
	
//	public Movie(String title, int releaseYear, String director, String writer, int rating) {
//		this.movieTitle = title;
//		this.releaseYear = releaseYear;
//		this.director = director;
//		this.writer = writer;
//		this.rating = rating;
//	}

	private Movie(){
		this.movieTitle = "";
		this.releaseYear = 0;
		this.director = "";
		this.writer = "";
		this.rating = 0;
	}
	
	public static Movie getInstance(){
		count++;
		//if(count < 1){
			System.out.println("More than 1");
		//}
		if(firstInstanceOfMovie == null){
			firstInstanceOfMovie = new Movie();
		}
		return firstInstanceOfMovie;
	}
	
	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
