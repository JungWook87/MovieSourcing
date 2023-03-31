<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name ="google-signin-client_id" 
    content="935814438564-8ocf3d4e2vsp790u21l0vctt9qahq9bj.apps.googleusercontent.com">
    <link rel="stylesheet" href="../resources/css/login.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js" 
    integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" 
    crossorigin="anonymous"></script>

    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    
    <title>로그인</title>

</head>
<body>
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">
                <header>
                    <div>
                        <a href="#" class="backpage">
                            <i class="fa-solid fa-chevron-left" id="backpageimg"></i>
                        </a>
                    </div>
                </header>
                <main id="contents">
                    <section class="logintop">
                        <span class="top">로그인</span>

                    </section>
                    <section class="loginbox">
                        <div class="login">
                            <div class="loginwrap">
                                <form action="login" method="POST" name="login-form" onsubmit="return loginValidate()">
                                 <fieldset id="id-pw-area">
                                        <span>아이디</span>
                                        <div class="id">
                                            <input type="text" id="id"   name="id" placeholder="아이디를 입력해주세요">
                                        </div>
                                        <span>비밀번호</span>
                                        <div class="password">
                                            <input type="password" id="password"  name="password" placeholder="비밀번호를 입력해주세요">
                                        </div>
                                        <div class="keepLogin">
                                            <input type="checkbox" name="keepLogin">
                                            <label for="keepLogin"><span>로그인 상태 유지</span></label>
                                        </div>
                                        <button id="nomalLogin">
                                            <span>로그인</span>
                                        </button>
                                    </fieldset>
                                </form>
                               
                            </div>

                            <div class="btnwrap">
                                
                                <div id="kakaoLogin">
                                    <div>
                                        <i class="fa-solid fa-comment" id="kakaoImg"></i>
                                    </div>
                                    <div><span>카카오 로그인</span></div>
                                    <div></div>
                                </div>
                                <div id="googleLogin">
                                    <div >
                                        <div class="googleBox">
                                            <i class="fa-brands fa-google-plus-g" id="googleImg"></i>
                                        </div>
                                    </div>
                                    <div><span>구글 로그인</span></div>
                                    <div></div>
                                </div>
                                <div class="enderMenu">
                                    <div>
                                        <a href="#"><span>회원가입</span></a>
                                    </div>
                                    <div>
                                        <a href="#"><span>아이디</span></a>
                                        <span> |</span>
                                        <a href="#"><span>비밀번호찾기</span></a>
                                    </div>
                                </div>

                            </div>
                            
                        </div>
                    </section>
                    <section class="under">

                    </section>
                    <button id="logout">로그아웃</button>
                   
                </main>
            </div>
        </div>

    </div>

    <script src="../resources/js/login.js"></script>
    
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script>    
    
    
        Kakao.init('b1d9a2e7a04258418caf62b1eca84f41');
        console.log(Kakao.isInitialized()); 

        document.getElementById("kakaoLogin")
        .addEventListener("click", function kakaoLogin() {
            Kakao.Auth.login({
            success: function (response) {
                Kakao.API.request({
                url: '/v2/user/me',
                success: function (response) {
                    console.log(response)
                },
                fail: function (error) {
                    console.log(error)
                },
                })
            },
            fail: function (error) {
                console.log(error)
            },
            })
        })
        document.getElementById("logout")
        .addEventListener("click", function kakaoLogout() {
            if (Kakao.Auth.getAccessToken()) {
            Kakao.API.request({
                url: '/v1/user/unlink',
                success: function (response) {
                    console.log(response)
                },
                fail: function (error) {
                console.log(error)
                },
            })
            Kakao.Auth.setAccessToken(undefined)
            }
        }  )
    </script>

    <script>
        function init() {
            gapi.load('auth2', function() {
                gapi.auth2.init();
                options = new gapi.auth2.SigninOptionsBuilder();
                options.setPrompt('select_account');
                options.setScope('email profile openid https://www.googleapis.com/auth/user.birthday.read');
                gapi.auth2.getAuthInstance().attachClickHandler('googleLogin', options, onSignIn, onSignInFailure);
            })
        }
        
        function onSignIn(googleUser) {
            var access_token = googleUser.getAuthResponse().access_token
            $.ajax({
                url: 'https://people.googleapis.com/v1/people/me'
                 , data: {personFields:'birthdays', key:'AIzaSyAR3Snhp3uGfBQ0Sw_Bfa82gwbpqr_cFRE', 'access_token': access_token}
                , method:'GET'
            })
            .done(function(e){
               var profile = googleUser.getBasicProfile();
                console.log(profile)
            })
            .fail(function(e){
                console.log(e);
            })
        }
        function onSignInFailure(t){		
            console.log(t);
        }
    </script>
    <script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
</body>
</html>