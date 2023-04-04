<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/myProfileChangePg.css">
    
    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
    crossorigin="anonymous"></script>
   <%   session.getAttribute("message"); %>
    <title>프로필수정</title>
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
                 <form action="myPagechangeEnter" method="POST" name="myPage-form" onsubmit="return infoValidate()">
                    <section class="profilebox">
                        <span class="title">프로필수정</span>
                         
                          <c:if test="${empty loginMember.memberImg}">
                        <div> 

                            <i class="fa-solid fa-face-laugh-squint" 
                            id="profileimg"></i>
                            
                        </div>
                           </c:if>
                     <c:if test="${!empty loginMember.memberImg}">
                     
                        <img src="${contextPath}${loginMember.memberImg}" id="profileimg" name="profileimg">
                       </c:if>
                        <a href="#">사진변경</a>
                        <span class="email1">가입시 입력한 email 주소</span>
                        
                        
                        
                        <span class="email2">${loginMember.memberEmail}</span>
                        
                    </section>
                  
                    <section class="passwordbox">
                        <div>
                            <input type="password" name ="currentPw" class="currentPw" id="currentPw"  placeholder="현재 비밀번호">
                        </div>
                        <div>
                            <input type="password" name ="newPw1" class="newPw1" id="newPw1" placeholder="변경할 비밀번호">
                        </div>
                        <div class="passwordboxdiv3">
                            <input type="password"name ="newPw2" class="newPw2" id="newPw2" placeholder="변경할 비밀번호 확인">
                            <span id="pwCheck"></span>
                        </div> 
                    </section>
                   
                    <script>
  
                    </script>
                    <section class="nicknamebox">
                        <div class="nicknamebar">
                            <span class="leftpadding">닉네임</span>
                            <span id="nicknamebite"><span class="nicknameCounter">0</span>/20</span>
                        </div>
                        <div class="nicknameinsert">
                            <textarea id="nicknameArea" name = "nicknameArea" placeholder="바꿔도됩니다">${loginMember.memberNick}</textarea>
                        </div>
                       
                    </section>
                    <section class="introducebox">
                        <div class="introducebar">
                            <span class="leftpadding">소개글</span>
                            <span id="introducebite"><span class="introCounter">0</span>/100</span>
                        </div>
                        <div class="introduceinsert">
                            <textarea name="introduceArea" id="introduceArea" placeholder="아무글이나 적어도 좋습니다.">${loginMember.memberIntro}</textarea>
                        </div>
                    </section>

                    
                    <a href="${contextPath}/member/secession">회원탈퇴 <i class="fa-solid fa-chevron-right"></i> </a>


                    <hr class="line" color="gray">

                    <section class="savebox">
                        <button id="saveBtn" ><span>저장</span></button>
                    
                    </section>
                    
                </main>
                  </form>
            </div>
        </div>

    </div>

    <script src="${contextPath}/resources/js/member/myProfileChangePg.js"></script>
    
</body>
</html>