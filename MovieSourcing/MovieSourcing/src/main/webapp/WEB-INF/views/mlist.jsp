<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/semi-mlist.css">
    <script src="https://kit.fontawesome.com/0041fb1dcb.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <title>seml-mlist</title>
</head>
<body>
    <main>
        <header id="head">

          
            <div>
                <a href="#"><img src="${contextPath}/resources/images/LogoMakr-9dgAJM.png" name="home-logo"></a>
            </div>

            <div>
                <ul class="home-nav">
                    <li><a href="#" id="homebutton">홈</a></li>
                    <li><a href="${contextPath}/mlist.jsp" id="janrbutton">장르 검색</a></li>
                    <li><a href="${contextPath}/footer.jsp">커뮤니티</a></li>
                    <li><a href="${contextPath}/header.jsp">추천 시뮬레이션</a></li>
                </ul>
                <ul class="home-nav2">
                    <li><a href="#" id="homebutton"><i class="fa-solid fa-house"></i></a></li>
                    <li><a href="#" id="janrbutton"><i class="fa-solid fa-magnifying-glass"></i></a></li>
                    <li><a><i class="fa-solid fa-comments"></i></a></li>
                    <li><a><i class="fa-solid fa-trophy"></i></a></li>
                </ul>
            </div>

            <div class="head-right">

                <div class="search-box">
            
                <input type="text" class="search-txt" placeholder="영화제목,감독,배우" >
                <a href="#" class="search-btn"><i class="fa-solid fa-magnifying-glass" ></i></a>
                </div>

                <div><a href="#"><i class="fa-solid fa-heart"></i></a></div>
                <div><a href="#"><i class="fa-solid fa-user"></i></a></div>

            </div>

      
    </header>

        <section class="main">
            <div class="content">
                <div id="janr">
                    
                    <ul>
                        <p name="janr-name">장르</p>
                        <li><button type="button" onclick="clickjanr(this)" value="가족" class="janr-btn">가족</button></li> <li><button type="button" class="btn" value="미스터리">미스터리</button></li> <li><button type="button" class="btn" value="애니메이션">애니메이션</button></li>
                        <li><button type="button" onclick="clickjanr(this)" value="공포" class="janr-btn">공포</button></li> <li><button type="button" class="btn" value="범죄">범죄</button></li> <li><button type="button" class="btn" value="액션">액션</button></li>
                        <li><button type="button" onclick="clickjanr(this)" value="드라마" class="janr-btn">드라마</button></li> <li><button type="button" class="btn" value="판타지">판타지</button></li> <li><button type="button" class="btn" value="어드벤처">어드벤처</button></li>
                        <li><button type="button" onclick="clickjanr(this)" value="멜로/로맨스" class="janr-btn">멜로/로맨스</button></li> <li><button type="button" class="btn" value="코미디">코미디</button></li> <li><button type="button" class="btn" value="전쟁">전쟁</button></li>
                        <li><button type="button" onclick="clickjanr(this)" value="SF" class="janr-btn">SF</button></li> <li><button type="button" class="btn" value="스릴러">스릴러</button></li> <li><button type="button" class="btn" value="기타">기타</button></li>
                    </ul>

                    <hr class="hr">

                    <ul>
                        <p class="janr-name2">국가</p>
                        <li><button type="button" value="한국" id="korea" class="nation-btn">한국</button></li>
                        <li><button type="button" value="미국" id="america" class="nation-btn">미국</button></li>
                        <li><button type="button" value="일본" id="japan" class="nation-btn">일본</button></li>
                        <li><button type="button" value="중국" id="china" class="nation-btn">중국</button></li>
                        <li><button type="button" value="기타" id="etc2" class="nation-btn">기타</button></li>
                    </ul>

                    <hr class="hr">

                    <ul>
                        <p class="janr-name3">연령</p>
                        <li><button type="button" class="grade-btn" value="전체 관람가" id="all">전체 관람가</button></li>
                        <li><button type="button" class="grade-btn" value="12세 이상" id="12y">12세 이상</button></li>
                        <li><button type="button" class="grade-btn" value="15세 이상" id="15y">15세 이상</button></li>
                        <li><button type="button" class="grade-btn" value="청소년 관람불가" id="19y">청소년 관람불가</button></li>
                    

                    </ul>
                    
					<hr class="hr">

                </div >
                
					
			    <div class="mlist">
			        <div>
                        <c:forEach var="mlist" items="${mlist}">
                        	
			                <div><a href="movieInfo" id="contents"><img src="${contextPath}${mlist.moviePoster}" width="130px"><br><h3><c:out value="${mlist.movieTitle}"/></h3></a><br><p><c:out value="${mlist.national}/${mlist.movieGrade}"/></p></div>
                        	
                        </c:forEach>
                    </div>
		        </div>
            </div>   	

            <div class="side">
                <div class="side-1">
    
                    <div class="game">
                        <a href="#"><img src="${contextPath}/resources/images/추천영화테스트.png" width="200px"></a>
                    </div>
                    <div><a class="elw" name="top"><i class="fa-solid fa-up-long"></i>top</a></div>
                </div>

            </div>

        </section>
        
        <c:set var="movie" value="${mlist}"></c:set>
	<script>
		
			const test = [
				{testNo : 1, testName : 'test1'},
				{testNo : 2, testName : 'test2'}
			
			];
				
		console.log("test:::" + test);
		console.log("movie:::" + movie.movieNo);
		console.log("movie:::",movie);
		
	</script>


    </main>

    <footer>
        <p><a href="#">이용약관</a></p>
        <p><a href="#">개인정보처리방침</a></p>
        <p><a href="#">고객센터</a></p>
        <p><a href="#">(주)KH</a></p>

    </footer>

    <script src="${contextPath}/resources/js/semi-mlist.js"></script>
    
</body>
</html>