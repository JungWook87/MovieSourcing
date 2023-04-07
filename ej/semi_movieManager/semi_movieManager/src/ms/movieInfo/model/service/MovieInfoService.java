package ms.movieInfo.model.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import ms.movieInfo.model.dao.MovieInfoDAO;
import ms.movieInfo.model.vo.MovieInfo;

public class MovieInfoService {
	
	private Scanner sc = new Scanner(System.in);
	
	private MovieInfoDAO dao = new MovieInfoDAO();

	public void movieInfo() {
		
		int input = 0;
		
		do {
			try {
				System.out.println("----- 영화정보 추가/삭제/수정 -----");
				System.out.println("1. 영화 정보 추가");
				System.out.println("2. 영화 정보 삭제");
				System.out.println("3. 영화 정보 수정");
				System.out.println("4. 종료");
				
				
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
				sc.nextLine();
				
				
				System.out.println();				
				
				
				switch(input) {
				case 1:  insertMovie();   break;
				case 2:  deleteMovie();  break;
				case 3:  modifyMovie();   break;
				case 4:  System.out.println("영화 정보수정 종료");   break;
				
				default: System.out.println("번호 다시 입력");
				}
				
			}catch(InputMismatchException e) {
				System.out.println("번호 다시 입력");
				input = -1; 
				sc.nextLine(); 
			}
			
		}while(input != 0);
		
	}

	private void insertMovie() {
		
			System.out.println("<영화 정보 추가>");
			
			
			System.out.print("영화 제목 : ");
			String movieTitle = sc.nextLine();
			
			System.out.print("영화 영문제목 : ");
			String movieEngTitle = sc.nextLine();
			
			System.out.print("상영시간 : ");
			String movieTime = sc.next();
			
			System.out.print("개봉일 : ");
			String movieOpenDate = sc.next();
			
			System.out.print("평점 : ");
			double movieScore = sc.nextDouble();
			
			sc.nextLine();
			
			System.out.print("국가 : ");
			String movieNational = sc.nextLine();
			
			System.out.print("관람등급 : ");
			String movieGrade = sc.nextLine();
			
			System.out.print("포스터 : ");
			String moviePoster = sc.nextLine();
			
			System.out.print("줄거리 : ");
			String moviePreview = sc.nextLine();
			
			
			
			MovieInfo movie = new MovieInfo(movieTitle, movieEngTitle, movieTime,
											movieOpenDate,movieScore, movieNational, movieGrade,
											moviePoster, moviePreview);
			
			int result = dao.insertMovieInfo(movie);
			
			if(result > 0) { 
				System.out.println("추가 성공");
				
			} else { 
				System.out.println("추가 실패");
			}
	}

	private void deleteMovie() {
		
		System.out.println("<사번이 일치하는 사원 정보 삭제>");
		
		System.out.print("삭제할 영화 제목 : ");
		String movieTitle = sc.next();
		
		System.out.print("정말 삭제 하시겠습니까? (Y/N) : ");
		char input = sc.next().toUpperCase().charAt(0);

		
		if(input == 'Y') {
			
			
			int result = dao.deleteMovieInfo(movieTitle);
			
			if(result > 0) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("제목 잘못 입력");
			}
			
		} else {
			System.out.println("취소");
		}
		
	}

	private void modifyMovie() {
		
		System.out.println("<영화 정보 수정>");
		
		System.out.print("영화 제목 : ");
		String movieTitle = sc.next();
		
		System.out.print("영화 영문제목 : ");
		String movieEngTitle = sc.next();
		
		System.out.print("상영시간 : ");
		String movieTime = sc.next();
		
		System.out.print("개봉일 : ");
		String movieOpenDate = sc.next();
		
		System.out.print("평점 : ");
		double movieScore  = sc.nextDouble();
		
		System.out.print("국가 : ");
		String movieNational = sc.next();
		
		System.out.print("관람등급 : ");
		String movieGrade = sc.next();
		
		System.out.print("포스터 : ");
		String moviePoster = sc.next();
		
		System.out.print("줄거리 : ");
		String moviePreview = sc.next();
		
	
		MovieInfo movie = new MovieInfo();
		
		movie.setMovieTitle(movieTitle);
		movie.setMovieEngTitle(movieEngTitle);
		movie.setMovieTime(movieTime);
		movie.setMovieOpenDate(movieOpenDate);
		movie.setMovieScore(movieScore);
		movie.setMovieNational(movieNational);
		movie.setMovieGrade(movieGrade);
		movie.setMoviePoster(moviePoster);
		movie.setMoviePreview(moviePreview);
		
		
		int result = dao.modifyMovieInfo(movie);
		
		if(result > 0) {
			System.out.println("수정 완료");
		} else {
			System.out.println("다시 입력");
		}
	}

}

