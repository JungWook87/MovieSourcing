<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/basic.css">
    <%   session.getAttribute("message"); %>
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>마이페이지</title>
</head>
<body>
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">
                <header>
                    <div>
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
                                   <c:if test="${empty loginMember.memberImg}">
                                    <div class="avatar-wrap">
                                     
                                        <span>
                                        
                                            <i class="fa-solid fa-face-laugh-squint">
                                            </i>
                                        </span>
                                      
                                    </div>
                                     </c:if>
                                       <c:if test="${!empty loginMember.memberImg}">
                                    <div class="avatar-wrap">
                                     
                                        <span>
                                                <img src="${contextPath}${loginMember.memberImg}" id="profile-image">
                                        </span>
                                         
                                    </div>
                                     </c:if>
                                     
                              
                                     
                                     
                                    <div class="info-wrap">
                                        <p class="user-name">
                                          <span>${loginMember.memberNick}</span>  
                                        
                                          <span> <a href="${contextPath}/member/myPagechangeEnter"" ><i class="fa-regular fa-pen-to-square"></i></a></span>
                                          
                                        </p>
                                        <p class="user-email"><span>${loginMember.memberEmail}</span></p>
                                    </div>
                                </div>
                                 <a href="#" >
                                <div class="action-wrap"></div>
                                 </a>
                            </div>

                        </div>
                    </section>
                    <section class="contents-wrap">
                        <div class="profile-count-container">
                            <a href="#" >
                                <span class="count">0</span>
                                <span class="countInfo">찜</span>
                            </a>
                            <a href="#" >
                                <span class="count">0</span>
                                <span class="countInfo">본 영화</span>
                            </a>
                            <a href="#" >
                                <span class="count">0</span>
                                <span class="countInfo">인생영화</span>
                            </a>
                           
                        </div>
                        <div class="profile-container2">
                            <div class="profile-container-box">
                                <a href="#">내가 쓴 리뷰</a>
                                
                            </div>
                            <hr color="gray" border-width="0.5em">
                            <div class="profile-container-box">
                                <a href="#">관심없어요</a>
                                <a href="#">
                                    <button><span class="genre">액션</span></button>
                                    <button><span class="genre">외국영화</span></button>
                                    <button><span class="genre">독립영화</span></button>
                                </a>
                            </div>  
                        </div>
                        <div class="lifemovie-container">
                            <div class="lifemovie-top">
                                <span>인생영화</span>
                                <a href="#">관리</a>
                            </div>
                            <div class="lifemovie-bottom">
                                <div></div>
                                <div class="lifemovie-empty"><span>인생영화를 등록해주세요</span></div>
                                <button class="lifemovie-button">'인생영화' 등록</button>
                                
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
            </div>
        </div>

    </div>
    
</body>
</html>