package ms.list.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class movie {

	private int movieNo;
	private String movieTitle;
	private String movieEngTitle;
	private String movieTime;
	private String movieOpendate;
	private int movieScore;
	private String movieGrade;
	private String movieJanr;
	private String national;
	private String moviePoster;
	
	
}
