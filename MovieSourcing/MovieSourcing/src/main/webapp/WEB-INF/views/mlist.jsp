<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resource/css/semi-mlist.css">
    <script src="https://kit.fontawesome.com/0041fb1dcb.js" crossorigin="anonymous"></script>
    <title>seml-mlist</title>
</head>
<body>
    <main>
        <header id="head">

          
            <div>
                <a href="#"><img src="${contextPath}/resource/image/LogoMakr-9dgAJM.png" name="home-logo"></a>
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
                        <li><button href="#" id="action" class="btn" onclick="janrclick()">액션</button></li> <li><button href="#" class="btn" id="pan">판타지</button></li> <li><button href="#" class="btn" id="criminal">범죄</button></li>
                        <li><button href="#" id="sf" class="btn">SF</button></li> <li><button href="#" class="btn" id="thril">스릴러</button></li> <li><button href="#" class="btn" id="comedy">코미디</button></li>
                        <li><button href="#" id="drama"class="btn">드라마</button></li> <li><button href="#" class="btn" id="horror">공포(호러)</button></li> <li><button href="#" class="btn" id="animation">애니메이션</button></li>
                        <li><button href="#" id="melo" class="btn">멜로/로맨스</button></li> <li><button href="#" class="btn" id="mist">미스터리</button></li> <li><button href="#" class="btn" id="family">가족</button></li>
                        <li><button href="#" id="adven" class="btn">어드벤처</button></li> <li><button href="#" class="btn" id="war">전쟁</button></li> <li><button href="#" class="btn" id="etc">기타</button></li>
                    </ul>

                    <hr class="hr">

                    <ul>
                        <p class="janr-name2">국가</p>
                        <li><button href="#" id="korea" class="btn">한국</button></li>
                        <li><button href="#" id="america" class="btn">미국</button></li>
                        <li><button href="#" id="japan" class="btn">일본</button></li>
                        <li><button href="#" id="china" class="btn">중국</button></li>
                        <li><button href="#" id="etc2" class="btn">기타</button></li>
                    </ul>

                    <hr class="hr">

                    <ul>
                        <p class="janr-name3">연령</p>
                        <li><button href="#" class="btn" id="all">전체 관람가</button></li>
                        <li><button href="#" class="btn" id="12y">12세 이상</button></li>
                        <li><button href="#" class="btn" id="15y">15세 이상</button></li>
                        <li><button href="#" class="btn" id="19y">청소년 관람불가</button></li>
                        <li><button href="#" class="btn" id="etc3">기타</button></li>

                    </ul>

                </div >

                <div class="mlist">
                    <div>
                        <div><a href="#"><img src="${contextPath}/resource/image/검사외전포스터.jpg" width="130px"><br><h3>어메이징 스파이더맨1</h3></a><br><p>장르/개봉연도</p></div>
                        <div><a href="#"><img src="${contextPath}/resource/image/겨울왕국1 포스터.jpg" width="130px"><br><h3>검사외전</h3></a><br><p>장르/개봉연도</p></div>
                        <div><a href="#"><img src="${contextPath}/resource/image/곡성 포스터.jpg" width="130px"><br><h3>설국열차</h3></a><br><p>장르/개봉연도</p></div>
                        <div><a href="#"><img src="${contextPath}/resource/image/공조 포스터.jpg" width="130px"><br><h3>겨울왕국1</h3></a><br><p>장르/개봉연도</p></div>
                        <div><a href="#"><img src="${contextPath}/resource/image/기생충 포스터.jpg" width="130px"><br><h3>곡성</h3></a><br><p>장르/개봉연도</p></div>

                    </div>
                    
                    <div>
                        <div><a href="#"><img src="${contextPath}/resource/image/1987포스터.jpg" width="130px"><br><h3>1987</h3></a><br><p>장르/개봉연도</p></div>
                        <div><a href="#"><img src="${contextPath}/resource/image/기생충 포스터.jpg" width="130px"><br><h3>기생충</h3></a><br><p>장르/개봉연도</p></div>
                        <div><a href="#"><img src="${contextPath}/resource/image/마스터 포스터.jpg" width="130px"><br><h3>마스터</h3></a><br><p>장르/개봉연도</p></div>
                        <div><a href="#"><img src="${contextPath}/resource/image/명량 포스터.jpeg" width="130px"><br><h3>명량</h3></a><br><p>장르/개봉연도</p></div>
                        <div><a href="#"><img src="${contextPath}/resource/image/밀정 포스터.jpg" width="130px"><br><h3>밀정</h3></a><br><p>장르/개봉연도</p></div>

                    </div>

                    <div>
                        <div><a href="#"><img src="${contextPath}/resource/image/백두산 포스터.jpg" width="130px"><br>
                            <h3>백두산</h3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                        <div><a href="#"><img src="${contextPath}/resource/image/범죄도시1 포스터.jpg" width="130px"><br>
                            <h3>범죄도시1</h3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                        <div><a href="#"><img src="${contextPath}/resource/image/보헤미안 랩소디 포스터.jpg" width="130px"><br>
                            <h3>보헤미안 랩소디</h3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                        <div><a href="#"><img src="${contextPath}/resource/image/블랙위도우 포스터.jpg" width="130px"><br>
                            <h3>블랙위도우</h3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                        <div><a href="#"><img src="${contextPath}/resource/image/설국열차 포스터.jpg" width="130px"><br>
                            <h3>설국열차</h3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                    </div>

                    <div>
                        <div><a href="#"><img src="${contextPath}/resource/image/어벤져스1 포스터.jpg" width="130px"><br>
                            <h3>어벤져스1</h3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                        <div><a href="#"><img src="${contextPath}/resource/image/수상한그녀 포스터.jpeg" width="130px"><b3>
                            <h3>수상한그녀</h3></b3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                        <div><a href="#"><img src="${contextPath}/resource/image/어스파2 포스터.jpg" width="130px"><br>
                            <h3>어메이징 스파이더맨2</h3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                        <div><a href="#"><img src="${contextPath}/resource/image/최종병기 활 포스터.jpeg" width="130px"><br>
                            <h3>최종병기 활</h3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                        <div><a href="#"><img src="${contextPath}/resource/image/트랜스포머 포스터.jpg" width="130px"><br>
                            <h3>트랜스포머</h3></a><br>
                            <p>장르/개봉연도</p>
                        </div>

                    </div>

                    <div>
                        <a></a>
                        <a></a>
                        <a></a>
                        <a></a>
                        <a></a>
                        <a></a>
                    </div>

                </div>
            </div>

            <div class="side">
                <div class="side-1">
    
                    <div class="game">
                        <a href="#"><img src="${contextPath}/resource/image/추천영화테스트.png" width="200px"></a>
                    </div>
                    <div><a class="elw" name="top"><i class="fa-solid fa-up-long"></i>top</a></div>
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

    <script src="${contextPath}/resource/js/semi-mlist.js"></script>
    
</body>
</html>