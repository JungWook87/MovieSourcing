package ms.main.model.service;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ms.main.model.dao.MainDAO;
import ms.main.vo.MovieInfoVO;


public class MainService {

	private MainDAO mainDAO = new MainDAO();
	
	public Map<String, Object> selectMainContent() throws SQLException {
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<MovieInfoVO> movieList = mainDAO.selectMainContent();		// 메인 컨텐츠 조회
		List<Map<String, Object>> communityList = mainDAO.selectMainCommContent();	// 메인 커뮤니티 조회
		List<Map<String, Object>> reviewList = mainDAO.selectMainReviews();	// 메인 리뷰 조회
		
		
		result.put("rankList", movieList.subList(0, 5)); 				// 랭킹 컨텐츠 리스트
		Collections.shuffle(movieList);									// List 랜덤  정렬
		result.put("recommandList", movieList);			// 추천  컨텐츠 리스트
		Collections.shuffle(movieList);									
		result.put("newList", movieList);					// 새로운 컨텐츠  리스트
		Collections.shuffle(movieList);									
		result.put("lifeList1", movieList.subList(0, 5));				// 인생1  컨텐츠 리스트
		Collections.shuffle(movieList);									
		result.put("lifeList2", movieList.subList(0, 5));				// 인생2 컨텐츠  리스트
		result.put("communityList", communityList);						// 커뮤니티 리스트
		result.put("reviewList", reviewList);							// 리뷰 리스트
		
		return result;
	}
	

}
