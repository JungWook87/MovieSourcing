package ms.main.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import ms.main.model.dao.MainDAO;
import ms.main.vo.Main;

import static ms.common.JDBCTemplate.*;

public class MainService {

	public void selectDB() {
		
		Connection conn = getConnection();
		
		MainDAO dao = new MainDAO();
		
		try {
			
			List<Main> mList = dao.selectDB(conn);
			
			
			
			
		}catch(Exception e) {
			
		}
	}
	

}
