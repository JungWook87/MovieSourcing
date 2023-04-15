<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/semi-main.css">
    <script src="https://kit.fontawesome.com/0041fb1dcb.js" crossorigin="anonymous"></script>
    <title>semi-main</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
</head>
<body>
    <main>
        <header id="head">

                <div class="main-image">
                    <ul class="main-slides">
                        <li><img src="${contextPath}/resources/images/bg_1.jpg" ></li>
                        <li><img src="${contextPath}/resources/images/bg_1.jpg" ></li>
                        <li><img src="${contextPath}/resources/images/bg_1.jpg" ></li>
                    </ul>
                </div>
            

                <div>
                    <a href="${contextPath}"><img src="${contextPath}/resources/images/img_etc/moviesourcing.png" name="home-logo"></a>
                </div>

                <div>
                    <ul class="home-nav">
                        <li><a href="main" id="homebutton">홈</a></li>
                        <li><a href="${contextPath}/msList" id="janrbutton">장르 검색</a></li>
                        <li><a href="MovieSourcing/boardList">커뮤니티</a></li>
                        <li><a href="simulation/simulEnter">추천 시뮬레이션</a></li>
                    </ul>
                    <ul class="home-nav2">
                        <li><a href="main" id="homebutton"><i class="fa-solid fa-house"></i></a></li>
                        <li><a href="${contextPath}/msList" id="janrbutton"><i class="fa-solid fa-magnifying-glass"></i></a></li>
                        <li><a href="MovieSourcing/boardList"><i class="fa-solid fa-comments"></i></a></li>
                        <li><a href="#"><i class="fa-solid fa-trophy"></i></a></li>
                    </ul>
                </div>

                <div class="head-right">

                    <div class="search-box">
                
                    <input type="text" class="search-txt" placeholder="영화제목,감독,배우" >
                    <a href="#" class="search-btn"><i class="fa-solid fa-magnifying-glass" ></i></a>
                    </div>
                    
                    <c:choose>
						<c:when test="${ loginMember.memberId== null }">
		                    <div><a href="member/login"><i class="fa-solid fa-heart"></i></a></div>
		                    <div><a href="member/login"><i class="fa-solid fa-user"></i></a></div>
						</c:when>
						
						<c:otherwise>
							<div><a href="member/MyPageEnter" ><i class="fa-solid fa-heart"></i></a></div>
							<div> <a href="member/MyPageEnter" ><i class="fa-solid fa-user"></i></a></div>
						</c:otherwise>
					</c:choose>
					
                </div>
          
        </header>

        <section class="main">

            <!-- 영화 정보 -->
            <div class="movie">
                <div class="chart active">
                    <span><i class="fa-solid fa-trophy"></i>&nbsp넷플릭스 랭킹&nbsp
                        <a class="rotate"><i class="fa-solid fa-rotate-right"></i></a>

                    </span>
                    <ul class="charts">
                        <i class="fa-solid fa-1"></i><li><a href="MovieSourcing/movieInfo?movieNo=1"><img src="resources/images/어벤져스1 포스터.jpg"></a></li>
                        <i class="fa-solid fa-2"></i><li><img src="resources/images/어스파2 포스터.jpg"></li>
                        <i class="fa-solid fa-3"></i><li><img src="resources/images/최종병기 활 포스터.jpeg"></li>
                        <i class="fa-solid fa-4"></i><li><img src="resources/images/트랜스포머 포스터.jpg"></li>
                        <i class="fa-solid fa-5"></i><li><img src="resources/images/1987포스터.jpg"></li>
                    </ul>
                </div>

                <div class="chart">
                    <span><i class="fa-solid fa-trophy"></i>&nbsp왓챠 랭킹
                        <a class="rotate"><i class="fa-solid fa-rotate-right"></i></a>
                    </span>
                    <ul class="charts">
                        <i class="fa-solid fa-1"></i><li><img src="resources/images/어스파1 포스터.jpg"></li>
                        <i class="fa-solid fa-2"></i><li><img src="resources/images/검사외전포스터.jpg"></li>
                        <i class="fa-solid fa-3"></i><li><img src="resources/images/수상한그녀 포스터.jpeg"></li>
                        <i class="fa-solid fa-4"></i><li><img src="resources/images/블랙위도우 포스터.jpg"></li>
                        <i class="fa-solid fa-5"></i><li><img src="resources/images/보헤미안 랩소디 포스터.jpg"></li>
                    </ul>
                </div>

                <div class="chart">
                    <span><i class="fa-solid fa-trophy"></i>&nbsp디즈니+ 랭킹
                        <a class="rotate"><i class="fa-solid fa-rotate-right"></i></a>
                    </span>
                    <ul class="charts">
                        <i class="fa-solid fa-1"></i><li><img src="resources/images/백두산 포스터.jpg"></li>
                        <i class="fa-solid fa-2"></i><li><img src="resources/images/밀정 포스터.jpg"></li>
                        <i class="fa-solid fa-3"></i><li><img src="resources/images/명량 포스터.jpeg"></li>
                        <i class="fa-solid fa-4"></i><li><img src="resources/images/곡성 포스터.jpg"></li>
                        <i class="fa-solid fa-5"></i><li><img src="resources/images/기생충 포스터.jpg"></li>
                    </ul>
                </div>


                <div class="m-recommend">
                <span>
                    <p><i class="fa-solid fa-film"></i>회원맞춤<br>&nbsp 영화추천</p> 
                </span>

                <div class="slide_wrapper">
                    <ul class="slides">
                        <li><img src="resources/images/1987포스터.jpg"></li>
                        <li><img src="resources/images/검사외전포스터.jpg"></li>
                        <li><img src="resources/images/겨울왕국1 포스터.jpg"></li>
                        <li><img src="resources/images/곡성 포스터.jpg"></li>
                        <li><img src="resources/images/공조 포스터.jpg"></li>
                        <li><img src="resources/images/기생충 포스터.jpg"></li>
                        <li><img src="resources/images/마스터 포스터.jpg"></li>
                        <li><img src="resources/images/명량 포스터.jpeg"></li>
                    </ul>
                </div>
                 </div>
                <p class="controls">
                   
                    <span class="prev">prev</span>
                    <span class="next">next</span>
                </p>


                <div class="m-contents">
                <span >
                    <p><i class="fa-regular fa-bookmark"></i>&nbsp새로운 <br>&nbsp컨텐츠</p>
                </span>

                
                <div class="slide_wrapper2">
                    
                    <ul class="slides2">
                        <li><img src="resources/images/밀정 포스터.jpg" width="200px" height="300px"></li>
                        <li><img src="resources/images/백두산 포스터.jpg" width="200px" height="300px"></li>
                        <li><img src="resources/images/범죄도시1 포스터.jpg" width="200px" height="300px"></li>
                        <li><img src="resources/images/보헤미안 랩소디 포스터.jpg" width="200px" height="300px"></li>
                        <li><img src="resources/images/블랙위도우 포스터.jpg" width="200px" height="300px"></li>
                        <li><img src="resources/images/설국열차 포스터.jpg" width="200px" height="300px"></li>
                        <li><img src="resources/images/수상한그녀 포스터.jpeg" width="200px" height="300px"></li>
                        <li><img src="resources/images/어스파1 포스터.jpg" width="200px" height="300px"></li>
                    </ul>
                </div>
                </div>
                <p class="controls2">
                   
                    <span class="prev2">prev</span>
                    <span class="next2">next</span>
                </p>

               


                
              
                <div class="community">
                    <span><p><i class="fa-regular fa-comments"></i>&nbsp커뮤니티</p></span>
                    <a><i class="fa-solid fa-chevron-right"></i></a>

                    <div class="community1">
                        <div><img src="resources/images/곡성 포스터.jpg"></div>
                        <div>
                            <div class="user">
                                <img src="resources/images/백두산 포스터.jpg" id="userimg1" class="userimg">
                                <span class="userInfo">
                                    <span class="userNick" id="userNick1">누누</span>
                                    <span class="date" id="date1">20230404</span>
                                </span>
                            </div>
                            
                            <p>단순한 호기심으로 봤는데 타짜 감독이 이런 잡탕영화를 만들어 내다니
                                잡탕도 이런 잡탕이 없다
                            </p>

                        </div>
                        
                    </div>

                    <div class="community2">
                        <div><img src="resources/images/곡성 포스터.jpg"></div>
                        <div>
                            <div class="user">
                                <img src="resources/images/백두산 포스터.jpg" id="userimg2" class="userimg">
                                <span class="userInfo">
                                    <span class="userNick" id="userNick2">누누</span>
                                    <span class="date" id="date2">20230404</span>
                                </span>
                            </div>
                            
                            <p>단순한 호기심으로 봤는데 타짜 감독이 이런 잡탕영화를 만들어 내다니
                                잡탕도 이런 잡탕이 없다
                            </p>

                        </div>
                        
                    </div>
                </div>

                <div class="review">

                    <span><i class="fa-regular fa-circle-user"></i>회원들의 리뷰</span><i class="fa-solid fa-rotate"></i>
                    <a><i class="fa-solid fa-rotate-right"></i></a>

                    <div class="review-content">
                        <div>
                            <div class="r-user">
                                <img src="resources/images/검사외전포스터.jpg" class="userimg2">
                                <span>회원이름</span>
                            </div>

                            <span>영화 이름</span>

                            <div>평점</div>

                            <span>평</span>

                        </div>
                        
                        <div>
                            <div class="r-user">
                                <img src="resources/images/검사외전포스터.jpg" class="userimg2">
                                <span>회원이름</span>
                            </div>

                            <span>영화 이름</span>

                            <div>평점</div>

                            <span>평</span>

                        </div>

                        <div>
                            <div class="r-user">
                                <img src="resources/images/검사외전포스터.jpg" class="userimg2">
                                <span>회원이름</span>
                            </div>

                            <span>영화 이름</span>

                            <div>평점</div>

                            <span>평</span>

                        </div>

                        <div>
                            <div class="r-user">
                                <img src="${contextPath}/resources/images/검사외전포스터.jpg" class="userimg2">
                                <span>회원이름</span>
                            </div>

                            <span>영화 이름</span>

                            <div>평점</div>

                            <span>평</span>
                            
                        </div>

                    </div>

                </div>

               <div class="favorite">
                    <span class="f-title"><i class="fa-regular fa-star"></i>인생영화관</span>
                    <div>
                    <a class="f-rotate"><i class="fa-solid fa-rotate-right"></i></a>
                    <h4 style="color: white ; ">누누님의 인생영화</h4>
                    <div class="f-mlist1">
                       
                        <div><img src="resources/images/블랙위도우 포스터.jpg" width="130px"></div>
                        <div><img src="resources/images/1987포스터.jpg" width="130px"></div>
                        <div><img src="resources/images/어스파2 포스터.jpg" width="130px"></div>
                        <div><img src="resources/images/보헤미안 랩소디 포스터.jpg" width="130px"></div>
                        <div><img src="resources/images/검사외전포스터.jpg" width="130px"></div>
                    </div>
                    <h4 style="color: white;">나나님의 인생영화</h4>
                    <div class="f-mlist2">
                        
                        <div><img src="resources/images/블랙위도우 포스터.jpg" width="130px"></div>
                        <div><img src="resources/images/1987포스터.jpg" width="130px"></div>
                        <div><img src="resources/images/어스파2 포스터.jpg" width="130px"></div>
                        <div><img src="resources/images/보헤미안 랩소디 포스터.jpg" width="130px"></div>
                        <div><img src="resources/images/검사외전포스터.jpg" width="130px"></div>

                    </div>
                    </div>
                </div>



               </fieldset>


            </div>

            <!-- 시뮬,인기검색어 -->
            <div class="side">
                <div class="side-1">
            
                    <div class="game">
                        <a href="#"><img src="resources/images/추천영화테스트.png" width="200px"></a>
                    </div>
                    <div><a class="btn" name="top"><i class="fa-solid fa-up-long"></i>top</a></div>
                </div>

                <div>
                    
                </div>

            </div>

            
        </section>

        
    </main>
    <footer>
        <p><a href="#">이용약관</a></p>
        <p><a href="#">개인정보처리방침</a></p>
        <p><a href="#">고객센터</a></p>
        <p><a href="#">(주)KH</a></p>

    </footer>

    <script src="${contextPath}/resources/js/semi-main.js"></script>

  
</body>
</html>