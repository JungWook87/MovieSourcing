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
	private String reviewScore;
}
