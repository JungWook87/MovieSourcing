<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="movieInfo" value="${map.movieInfo}" />
<c:set var="moviePeople" value="${map.moviePeople}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/movieInfo.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
    crossorigin="anonymous"></script>

    <title>개별영화페이지</title>
</head>
<body>
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">
                <header class="backpageHeader">
                    <div classs="backpageDiv">
                        <a href="javascript:window.history.back();" class="backpage">
                            <i class="fa-solid fa-chevron-left" id="backpageimg"></i>
                        </a>
                    </div>
                </header>
                <main id="contents">
                    <div class="mainContainer">
                        <div class="poster">
                            <img id=posterImg src="${movieInfo.moviePoster}"></img>
                        </div>
                        <div class="movieInfoBox">
                            <div class="checkBox">
                                <div></div>
                                <span id="watchedText">못 본 영화에요</span>
                                <div class="toggle">
                                    <input type="checkbox" name="toggle1" id="toggle1" value="1">
                                    <label for="toggle1">스위치</label>
                                </div>
                            </div>
                            <div class="titleBox">
                                <div>
                                    <span id="movieTitle">${movieInfo.movieTitle}"</span>
                                </div>
                            </div>
                            <div id="engBar"><span id="engTitle">${movieInfo.movieEngTitle}"</span><span> |</span>
                                <span id="openDate">${movieInfo.movieOpenDate}"</span>
                            </div>
                            <div>
                                <table>
                                    <tr>
                                        <td><span>감독</span></td>
                                        <td><span id="director">${moviePeople.pdName}</span></td>
                                    </tr>
                                    <tr>
                                        <td><span>배우</span></td>
                                        <td>
                                            <span id="actor">${moviePeople.act1}</span>
                                            <span id="actor">${moviePeople.act2}</span>
                                            <span id="actor">${moviePeople.act3}</span>
                                            <span id="actor">${moviePeople.act4}</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span>등급</span></td>
                                        <td><span id="grade">${movieInfo.movieGrade}</span></td>
                                    </tr>
                                </table>
                            </div>
                            <div class="genreBox">
                                <div><span class="genreSpan">#${movieInfo.movieGenre[0]}</span></div>
                                <div><span class="genreSpan">#${movieInfo.movieGenre[1]}</span></div>
                                <div><span class="genreSpan">#${movieInfo.movieGenre[3]}</span></div>
                            </div>
                            <div class="scoreBox">
                                <div id="scoreBar">
                                    <div id="score"><span id="scoreComment">${movieInfo.movieScore}</span></div>
                                </div>
                                <div id="wannasee">
                                    <a href="#" class="fa-solid fa-heart">
                                        <i ></i>
                                    </a>
                                </div>
                            </div>
                            <div class="writeBox">
                                <button id="lifeMovie">'인생영화'설정</button>
                                <button id="reviewWrite">리뷰쓰기</button>
                            </div>
                            
                        </div>
                    </div>
                    <div class="previewContainer">
                        <span class="bold2">줄거리</span>
                        <div class="previewbox">
<pre class="preview">
${movieInfo.moviePreview}
</pre>
                        </div>
                    </div>
                    <div class="actorContainer">
                        <span class="bold2">배우/제작진</span>
                        <div class="everyone">
                            <!-- 개별 배우 박스 -->
                            
                            <a class="actorbox" href="#">
                                <div><img src="${contextPath}/resources/images/img_pd/" id="directorBox"></div>
                                <span id="director">${moviePeople.pdName}</span>
                                <span>감독</span>
                            </a>
                            <a class="actorbox" href="#">
                                <div><img src="${moviePeople.act1Picture}" id="directorBox"></div>
                                <span id="director">${moviePeople.act1}</span>
                                <span>배우</span>
                            </a>
                            <a class="actorbox" href="#">
                                <div><img src="${moviePeople.act2Picture}" id="directorBox"></div>
                                <span id="director">${moviePeople.act2}</span>
                                <span>배우</span>
                            </a>
                            <a class="actorbox" href="#"> 
                                <div><img src="${moviePeople.act3Picture}" id="directorBox"></div>
                                <span id="director">${moviePeople.act3}</span>
                                <span>배우</span>
                            </a>
                            <a class="actorbox" href="#">
                                <div><img src="${moviePeople.act4Picture}" id="directorBox"></div>
                                <span id="director">${moviePeople.act4}</span>
                                <span>배우</span>
                            </a>
                        </div>
                    </div>
                    <div class="reviewContainer">
                        <div class="review1"> 
                            <span class="bold2">회원들의 리뷰</span> 
                            <a href="#">더보기</a>
                        </div>
                        <div class="reviewbox">
                            <div class="reviewInfo">
                                <div>
                                    <div>
                                        <i class="fa-solid fa-face-laugh-squint" id="profileImg">
                                        </i>
                                        <span id="userName">한현</span>
                                    </div>
                                    <div id="scoreLight1"></div>
                               
                                    <div id="userScore1">
                                        <span id="userScore1">4.5</span>
                                    </div>
                                </div>
                                <div>
                                    <span>3주전</span>
                                </div>
                            </div>
                            <div class="reviewContent">
                                <span id="reviewContent">원래는 4.0였다. 박찬욱 특유의 뒤틀린 유머나 수위 높은 장면이 없는 게 좋으면서도 아쉬워지는 부분이었는데, 안개가 울려퍼지자 우는 탕웨이를 보며 0.5를 매꾸기로 했다.
                                </span>
                            </div>
                        </div>
                        <div class="reviewbox">
                            <div class="reviewInfo">
                                <div>
                                    <div>
                                        <i class="fa-solid fa-face-laugh-squint" id="profileImg">
                                        </i>
                                        <span id="userName">Konauki</span>
                                    </div>
                                    <div id="scoreLight2"></div>
                               
                                    <div id="userScore2">
                                        <span id="userScore2">1.5</span>
                                    </div>
                                </div>
                                <div>
                                    <span>오늘</span>
                                </div>
                            </div>
                            <div class="reviewContent">
                                <span  id="reviewContent">
                                    영화가 쓸데없이 넘 어려움
                                </span>
                            </div>
                        </div>
                       
                    </div>
                    <div class="recommendContainer">
                        <span class="bold2">이런영화는 어때요??</span> 
                        <div class="everyone">
                            <a href="#" class="recommendMovieBox">
                                <img src="/이미지/같은 장르.jpg" id="recommendMovie">
                            </a>
                            <a href="#" class="recommendMovieBox">
                                <img src="/이미지/감독영화.jpg" id="recommendMovie">
                            </a>
                            <a href="#" class="recommendMovieBox"> 
                                <img src="/이미지/주연영화.jpg" id="recommendMovie">  
                            </a>
                            <a href="#" class="recommendMovieBox">    
                                <img src="/이미지/같은 장르 (2).jpg" id="recommendMovie">  
                            </a>
                        </div>
                </main>
                <header class="navHeader">
                    <nav class="nav">
                        <a href="#" class="home">
                            <i class="fa-solid fa-house"></i>
                            <span>홈</span>
                        </a>
                        <a href="#" class="community">
                            <i class="fa-solid fa-comments"></i>
                            <span>커뮤니티</span>
                        </a>
                        <a href="#" class="search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                            <span>탐색</span>
                        </a>
                        <a href="#" class="mypage">
                            <i class="fa-solid fa-user"></i>
                            <span>마이페이지</span>
                        </a>
                    </nav>
                </header>
                
            </div>
        </div>
    </div>

    <div id="reviewOverlay" class="reviewOverlay">
        <div id="reviewWriteBox">
            <div id="modalTitle">
                <span>리뷰를 작성해주세요</span>
            </div>
            <div id="modalScore">
                <div>
                    <span>별점 평가</span>
                </div>
                <div id="starBox">
                    <span class="star">
                        ★★★★★
                        <span>★★★★★</span>
                        <input type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10">
                    </span>
                </div>
            </div>
            <div id="modalDiv1">
                <div id="modalDiv2">
                    <div >
                        <span>간단히 작성해 보세요</span>
                    </div>
                    <div>
                        <span id="reviewCounter">0</span>
                        <span>/100</span>
                    </div>
                </div>
                <div>
                    <textarea name="review" id="reviewArea" spellcheck="false" ></textarea>
                </div>
                <div>
                    <button id="reviewSubmit"><span>저 장</span></button>
                </div>
            </div>
        </div>
    </div>
    
    <script src="${contextPath}/resources/js/movie/movieInfo.js"></script>
</body>
</html>