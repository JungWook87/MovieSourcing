package ms.community.board.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import ms.community.board.model.dao.BoardDAO;
import ms.community.board.model.vo.Board;
import ms.community.board.model.vo.Pagination;

import static ms.community.common.JDBCTemplate.*;

import static ms.community.common.JDBCTemplate.*;

public class BoardService {
	
	private BoardDAO dao = new BoardDAO();
	
	private Connection conn;
	
	
	
	
	
	
	public Map<String, Object> searchBoadList(int cp) throws Exception {
		conn = getConnection(); 
		
		int listCount = dao.getListCount(conn);
		
		Pagination pagination = new Pagination(cp, listCount);
		
		List<Board> boardList = dao.selectBoardList(conn); 
		
		
		return null;
	}
	
	
	
	
	
	

	public Map<String, Object> searchBoadList(int cp, String key, String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
