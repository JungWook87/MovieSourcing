package ms.community.board.model.service;

import ms.community.board.model.dao.ReplyDAO;
import ms.community.board.model.vo.Reply;
import static ms.community.common.JDBCTemplate.*;

import java.sql.Connection;

public class ReplyService {

	public String insertReply(Reply reply) {
		
		String resultStr = "";
		
		int result = 0;
		
		Connection conn = getConnection();
		
		try {
			ReplyDAO replyDao = new ReplyDAO();
			
			result = replyDao.insertReply(conn, reply);
			
			if(result != 0) {
				resultStr = "댓글 등록 성공";
				commit(conn);
			} else {
				resultStr = "댓글 등록 실패";
				rollback(conn);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return resultStr;
	}

}
