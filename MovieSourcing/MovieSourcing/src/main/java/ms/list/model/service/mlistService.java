package ms.list.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.list.model.dao.mlistDAO;
import ms.list.model.vo.movie;

import static ms.common.JDBCTemplate.*;


public class mlistService {
	
	private mlistDAO dao = new mlistDAO();
	
	
	
	public List<movie> selectMlist() throws Exception {
		
		Connection conn= getConnection();
		
		List<movie> mlist = dao.selectAll(conn);
		
	
		close(conn);
		
		return mlist;
	}
	
	public List<movie> search() throws Exception {
		Connection conn = getConnection();
		
		List<movie> mlist = dao.search(conn);
		
		close(conn);
		
		return mlist;
	}
}
