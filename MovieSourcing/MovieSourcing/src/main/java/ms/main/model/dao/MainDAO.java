package ms.main.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;

import ms.main.model.vo.MovieInfoVO;

public class MainDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String dbcpDriver = "jdbc:apache:commons:dbcp:dbcp";
	
	
	/**
	 * 메인 영화 컨텐츠 조회
	 * @return List<MovieInfoVO>
	 * @throws SQLException
	 */
	public List<MovieInfoVO> selectMainContent() {
		
		String query = "SELECT MOVIE_NO, MOVIE_TITLE, MOVIE_ENG_TITLE, MOVIE_TIME, MOVIE_OPEN_DATE, MOVIE_SCORE, MOVIE_NATIONAL, MOVIE_GRADE, MOVIE_POSTER, MOVIE_PREVIEW FROM MOVIE_INFORMATION_TABLE";
		List<MovieInfoVO> list = new ArrayList<MovieInfoVO>();
		
		try {
			
			conn = DriverManager.getConnection(dbcpDriver);		// DB호출이 아닌 CP호출
			pstmt = conn.prepareStatement(query);				// pstmt로 query문 제작
			rs = pstmt.executeQuery(query);						// query문 실행
			
			while (rs.next()) {
				MovieInfoVO vo = new MovieInfoVO(
						rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getDouble(6)
						, rs.getString(7)
						, rs.getString(8)
						, rs.getString(9)
						, rs.getString(10)
				);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * 메인 커뮤니티 컨텐츠 조회
	 * @return List<MovieInfoVO>
	 * @throws SQLException
	 */
	public List<Map<String, Object>> selectMainCommContent() {

		String query = "SELECT T1.MEM_NO, T1.MEM_NAME, T1.MEM_IMG, T2.COM_NO, T2.COM_DATE, T2.COM_CONTENT, T4.MOVIE_POSTER FROM MEMBER T1 INNER JOIN COMMUNITY_TABLE T2 ON T1.MEM_NO = T2.MEM_NO\n" + 
				"INNER JOIN WATCHED_MOVIE T3\n" + 
				"    ON T1.MEM_NO = T3.MEM_NO\n" + 
				"INNER JOIN MOVIE_INFORMATION_TABLE T4\n" + 
				"    ON T3.MOVIE_NO = T4.MOVIE_NO";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			conn = DriverManager.getConnection(dbcpDriver);		// DB호출이 아닌 CP호출
			pstmt = conn.prepareStatement(query);				// pstmt로 query문 제작
			rs = pstmt.executeQuery(query);						// query문 실행
			
			while (rs.next()) {
				list.add(
					new HashMap<String, Object>() {{
						put("memNo", rs.getString(1));
						put("memName", rs.getString(2));
						put("memImg", rs.getString(3));
						put("comNo", rs.getString(4));
						put("comDate", rs.getString(5));
						put("comContent", rs.getString(6));
						put("moviePoster", rs.getString(7));
					}}
				);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Map<String, Object>> selectMainReviews() {
		String query = "SELECT\n" + 
				"    T1.MEM_NO\n" + 
				"    , T1.MEM_NAME\n" + 
				"    , T1.MEM_IMG\n" + 
				"    , T2.REVIEW_CONTENT\n" + 
				"    , T2.REVIEW_SCORE\n" + 
				"    , T3.MOVIE_TITLE\n" + 
				"    , T3.MOVIE_POSTER\n" + 
				"FROM MEMBER T1 INNER JOIN REVIEW T2\n" + 
				"    ON T1.MEM_NO = T2.MEM_NO\n" + 
				"INNER JOIN MOVIE_INFORMATION_TABLE T3\n" + 
				"    ON T2.MOVIE_NO = T3.MOVIE_NO";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		try {
			conn = DriverManager.getConnection(dbcpDriver);		// DB호출이 아닌 CP호출
			pstmt = conn.prepareStatement(query);				// pstmt로 query문 제작
			rs = pstmt.executeQuery(query);						// query문 실행
			
			while (rs.next()) {
				list.add(
					new HashMap<String, Object>() {{
						put("memNo", rs.getString(1));
						put("memName", rs.getString(2));
						put("memImg", rs.getString(3));
						put("reviewContent", rs.getString(4));
						put("reviewScore", rs.getString(5));
						put("movieTitle", rs.getString(6));
						put("moviePoster", rs.getString(7));
					}}
				);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}

