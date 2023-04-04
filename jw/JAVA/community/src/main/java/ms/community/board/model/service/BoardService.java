package ms.community.board.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.community.board.model.dao.BoardDAO;
import ms.community.board.model.vo.Board;
import ms.community.board.model.vo.BoardDetail;
import ms.community.board.model.vo.Pagination;

import static ms.community.common.JDBCTemplate.*;

import static ms.community.common.JDBCTemplate.*;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();
	
	
	/** boardList 조회
	 * @param cp
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectBoadList(int cp) throws Exception {
		
		Connection conn = getConnection(); 
		
		int listCount = dao.getListCount(conn);
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Board> boardList = dao.selectBoardList(conn, pagination); 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		return map;
	}
	
	
	/** boardDetail
	 * @param boardNo
	 * @param comNo
	 * @return detail
	 * @throws Exception
	 */
	public BoardDetail selectBoardDetail(int comNo) throws Exception{
		
		Connection conn = getConnection();
		
		BoardDetail boardDetail = dao.selectBoardDetail(conn, comNo);
	
		close(conn);
		
		return boardDetail;
	}
	

	public Map<String, Object> selectBoadList(int cp, String query) {
		return null;
	}

}
