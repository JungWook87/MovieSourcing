package ms.list.model.vo;



public class movie {

	private int movieNo;
	private String movieTitle;
	private String movieGrade;
	private String movieJanr;
	private String national;
	private String moviePoster;
	
	public movie() {}
	
	
	public movie(int movieNo, String movieTitle, String movieGrade, String movieJanr, String national, String moviePoster) {
		
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieGrade = movieGrade;
		this.movieJanr = movieJanr;
		this.national = national;
		this.moviePoster = moviePoster;
	}


	public int getMovieNo() {
		return movieNo;
	}


	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}


	public String getMovieTitle() {
		return movieTitle;
	}


	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}


	public String getMovieGrade() {
		return movieGrade;
	}


	public void setMovieGrade(String movieGrade) {
		this.movieGrade = movieGrade;
	}


	public String getMovieJanr() {
		return movieJanr;
	}


	public void setMovieJanr(String movieJanr) {
		this.movieJanr = movieJanr;
	}


	public String getNational() {
		return national;
	}


	public void setNational(String national) {
		this.national = national;
	}


	public String getMoviePoster() {
		return moviePoster;
	}


	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	
	
	
}