package ms.main.model.vo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MovieInfoVO {
	
	private String movieNo;
	private String movieTitle;
	private String movieEngTitle;
	private String movieTime;
	private String movieOpenDate;
	private double movieScore;
	private String movieNational;
	private String movieGrade;
	private String moviePoster;
	private String moviePreview;
	
	public MovieInfoVO(String movieNo, String movieTitle, String movieEngTitle, String movieTime, String movieOpenDate, double movieScore, String movieNational, String movieGrade, String moviePoster, String moviePreview) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieEngTitle = movieEngTitle;
		this.movieTime = movieTime;
		this.movieOpenDate = movieOpenDate;
		this.movieScore = movieScore;
		this.movieNational = movieNational;
		this.movieGrade = movieGrade;
		this.moviePoster = moviePoster;
		this.moviePreview = moviePreview;
	}

}
