<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/movie/watchedList.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
    crossorigin="anonymous"></script>
    
    <title>본영화</title>
</head>
<body>
 
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">
                <header class="backpageHeader">
                    <div classs="backpageDiv">
                        <a href="#" class="backpage">
                            <i class="fa-solid fa-chevron-left" id="backpageimg"></i>
                        </a>
                    </div>
                </header>
                <main id="contents">
                    <div class="top">
                        <span id="topName">"kakao"님이 본 영화</span>
                    </div>
           
                    <div class="Container">
                        <div class="infomation"> 
                            <span class="Count">105개의 영화를 봤어요</span> 
                            <a href="#"></a>
                        </div>
                        <div class="watched">
                            <div class="watchedInfo">
                                <img src="../이미지/감독영화.jpg" class="watchedImg" alt="">
                                <div class="watchedInfoWrap">
                                    <div><span id="movieName">박쥐</span></div>
                                    <div><span id="date">2018.06.24</span></div>
                                    <div class="score"> 
                                        <span id="score">관객평점 <span id="movieScore">4.8</span>/5.0</span>
                                    </div>
                                </div>
                            </div>
                            <div id="watchedMenu">
                                <a class="fa-regular fa-circle-xmark" id="watchedDelete"></a>

                                <a class="fa-solid fa-ellipsis-vertical" id="watchedDot"></a>
                            </div>
                        </div>
                        
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

    <!-- 모달창 -->
    <div id="modalOverlay" class="modal">
        <div id="modalMenu">
            <div>

            </div>
            <div>   
                <button></button>
                <button></button>
                <button></button>
            </div>


        </div>
    </div>
    
    
    <script src="${contextPath}/resources/js/movie/watchedList.js"></script>

</body>
</html>