package ms.community.board.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자
public class Board {
	
	private int comNo;
	private String comTitle;
	private String comDate;
	private String comContent;
	private int readCount;
}
