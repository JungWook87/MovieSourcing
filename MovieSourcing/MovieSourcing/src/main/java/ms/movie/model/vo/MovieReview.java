package ms.movie.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieReview {
	
	private int movieNo;
	private int memNo;
	private String reviewContent;
	private String reviewDate;
	private int reviewScore;
	
	private String memPic;
	private String memNic;
	
	
	public MovieReview(int movieNo, int memNo, String reviewContent, String reviewDate, int reviewScore,
			String memPic, String memNic) {
		this.movieNo = movieNo;
		this.memNo = memNo;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewScore = reviewScore;
		this.memPic = memPic;
		this.memNic = memNic;
	}
	
	

	
	
}
