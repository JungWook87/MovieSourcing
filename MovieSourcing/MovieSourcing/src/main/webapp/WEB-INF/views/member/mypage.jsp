<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/member/basic.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>마이페이지</title>
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
                    <section class="outer-wrap">
                        <div class="inner-wrap">
                            <div class="info-container">
                                <div class="user-wrap">
                                    <div id="userInfo">
                                        <div class="avatar-wrap">
                                        <c:if test="${empty loginMember.memberImg}">
                                            <span>
                                           
                                                <i class="fa-solid fa-face-laugh-squint" title="프로필수">
                                                </i>
     										
                                            
                                            </span>
                                            </c:if>
                                            
                                            <c:if test="${!empty loginMember.memberImg}">
                                            <span>
                                           
                                                
     										
                                            
                                            </span>
                                            </c:if>
                                        </div>
                                        <div class="info-wrap">
                                            <div class="user-name">
                                                <span>${loginMember.memberNick}</span>
    
                                                <!-- 개인창을 벗어나면 display none 으로 제어 -->
                                               
                                            </div>
                                            <div class="user-email"><span>${loginMember.memberEmail}</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="userMenu">
                                     
                                        <a class="fa-regular fa-pen-to-square" href="myPagechangeEnter"></a>
                                        <a class="fa-solid fa-right-to-bracket" href="logout"></a>
                                    </div>
                                   
                                </div>
                                <div id="introduceBox">
                       <c:if test="${empty loginMember.memberIntro}">             
                                    <span id="introduceSpan">
         		                        
                                        default
                                   
                                    </span>
                                      </c:if>
                              <c:if test="${!empty loginMember.memberIntro}">             
                                    <span id="introduceSpan">
         		                        ${loginMember.memberIntro}
                                    </span>
                                      </c:if>
                                </div>
                            </div>

                        </div>
                    </section>

                    <!-- 카운트 -->
                    <section class="contents-wrap">
                        <div class="profile-count-container">
                            <a href="${contextPath}/movielist/wishList?memberNo=${loginMember.memberNo}" >
                                <span id="wannaseeCount" class="countSpan">0</span>
                                <span>찜</span>
                            </a>
                            <a href="${contextPath}/movielist/watchedList?memberNo=${loginMember.memberNo}">
                                <span id="watchedCount" class="countSpan">0</span>
                                <span>본 영화</span>
                            </a>
                            <a href="#" >
                                <span id="lifeMovieCount" class="countSpan">0</span>
                                <span>인생영화</span>
                            </a>
                           
                        </div>

                        <div class="profile-container2">
                            <div class="profile-container-box"  style=" cursor: pointer;" 
                            onclick="location.href='${contextPath}/movielist/reviewList?memberNo=${loginMember.memberNo}'">
                                <a href="#">작성한 리뷰</a>
                                <a href="#">
                                <span id="reviewCount">0</span> <i class="fa-solid fa-chevron-right" id="arrow"></i>
                                </a>
                            </div>
                            <hr id="boxLine" class="boxline" color="gray">
                            <div class="profile-container-box">
                                <a href="#">커뮤니티 작성글</a>
                                <a href="#"><span id="communityCount">0</span> <i class="fa-solid fa-chevron-right" id="arrow"></i></a>
                            </div>
                            
                            <hr id="boxLine2" class="boxline" color="gray">
                            
                            <!-- 개인창을 벗어나면 display none 으로 제어 -->
                            <div class="profile-container-box" id="unlikeBox">
                                <div>
                                    <a href="#">관심없어요</a>
                                    <a class="fa-solid fa-circle-info" id="infoMark" title="관심없는 장르를 제외해줍니다."></a>
                                </div>
                                <a href="#" id="genreBox">
                                    <div class="genreDiv"><span class="genre">액션</span></div>
                                    <div class="genreDiv"><span class="genre">외국영화</span></div>
                                    <div class="genreDiv"><span class="genre">독립영화</span></div>
                                </a>
                            </div>  
                        </div>
                        
                        <div class="lifemovie-container">
                            <div class="lifemovie-top">
                                <span>인생영화</span>

                                <!-- 개인창을 벗어나면 display none 으로 제어 -->
                                <a href="#">관리</a>
                            </div>
                            <div class="lifemovie-bottom">

                                <!-- 타인이 봤을때 없을 경우 -->
                                <div class="lifemovie-empty-foreign">
                                    <span>등록된 인생 영화가 없습니다.</span>
                                </div>

                                <!-- 개인이 봤을때 등록된 인생영화가 없을 경우  -->
                                <div class="lifemovie-empty"><span>인생영화를 등록해주세요</span></div>
                                <button class="lifemovie-button">'인생영화' 등록</button>
                                
                                <!-- 인생영화 div -->
                                <!-- 등록된 인생영화 div append -->
                                <div class="lifemovie-Imgbox"></div>
                            </div>
                            
                        </div>
                        <hr color="gray" border-width="0.5em">
                        <div class="wanttosee-container">
                            <div class="wanttosee-top">
                                <span>찜한영화</span>
                                <a href="#">관리</a>
                            </div>
                            <div class="wanttosee-bottom">
                                <div></div>
                                <div class="wanttosee-empty"><span>찜한 영화목록이에요</span></div>
                                
                                
                            </div>


                        </div>
                    </section>
                </main>
                <header class="navHeader">
                    <nav class="nav">
                        <a href="${contextPath}" class="home">
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
                        <a href="MyPageEnter" class="mypage">
                            <i class="fa-solid fa-user"></i>
                            <span>마이페이지</span>
                        </a>
                    </nav>
                </header>
            </div>
        </div>

    </div>

    <script src="${contextPath}/resources/js/member/myPage.js"></script>
    
</body>
</html>