<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
     <%@ page import="ms.movie.model.vo.MovieInfo" %>
     
     
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/simulation/semiTestMain.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/simulation/semiQue.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/simulation/semiAns.css"> 
    <link rel="stylesheet" href="${contextPath}/resources/css/simulation/animation.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
 <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/0041fb1dcb.js" crossorigin="anonymous"></script>
  
    <title>영화 성향 테스트</title>
</head>
<body>

    <main>
        <header>

            <div>
                <a href="#"><img src="${contextPath}/resources/images/LogoMakr-9dgAJM.png" name="home-logo"></a>
            </div>

            <div>
                <ul class="home-nav">
                    <li><a href="#">홈</a></li>
                    <li><a href="#">장르 검색</a></li>
                    <li><a href="#">커뮤니티</a></li>
                    <li><a href="#">추천 시뮬레이션</a></li>
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
            <div class="test_main">
               
                <img src="${contextPath}/resources/images/추천영화테스트.png" class="test_main_img"  >
                
            <div class="test_start_btn" onclick="begin()">시뮬레이션 시작<img src="${contextPath}/resources/images/play (1).png" class="test_start_btn_img"></div>
        </div>
             
            

        </section>
       
        <section id="qna" >
            
            <div class="test_page">
                <div class="simulation_top">
                    <span id="simul_count_num" ></span><span class="simul_total_num">/12</span>
                </div>
             <div class="status">
                <div class="statusBar">

                </div>
             </div>


            <div class="question_p">

            </div>
            <div class="answerBox">

            </div>
        
        </div>

            
       
        </section>


        <section id="result">
            <p class="main_Center">당신을 위한 오늘의 영화는??</p>
            <div class="test_finall_main">
                <div class="arrow">
                </div>
           
                <div class="resultParent">
               </div>
 	
 			
 			   <img src='${contextPath}${movie.moviePoster}'  id="movieImg"  alt="Movie Poster" width="300">
                <div class="resultImg" id="resultSort">
                    <div class="resultText" id="resultSort"></div>
                  
            </div>
            
                <div class="arrow">
                </div>
            </div>

        </section>
        <script src="${contextPath}/resources/js/simulation/data.js" charset="utf-8"></script>
        <script src="${contextPath}/resources/js//simulation/start.js" charset="utf-8"></script>
     




    </main>
    <footer>
        <p><a href="#">이용약관</a></p>
        <p><a href="#">개인정보처리방침</a></p>
        <p><a href="#">고객센터</a></p>
        <p><a href="#">(주)KH</a></p>
    </footer>
    
</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
     <%@ page import="ms.movie.model.vo.MovieInfo" %>
     
     
<!DOCTYPE html>
<html lang="en">
<head> 
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/simulation/semiTestMain.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/simulation/semiQue.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/simulation/semiAns.css"> 
    <link rel="stylesheet" href="${contextPath}/resources/css/simulation/animation.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
 <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/0041fb1dcb.js" crossorigin="anonymous"></script>
  
    <title>�쁺�솕 �꽦�뼢 �뀒�뒪�듃</title>
</head>
<body>

    <main>
        <header>

            <div>
                <a href="#"><img src="${contextPath}/resources/images/LogoMakr-9dgAJM.png" name="home-logo"></a>
            </div>

            <div>
                <ul class="home-nav">
                    <li><a href="#">�솃</a></li>
                    <li><a href="#">�옣瑜� 寃��깋</a></li>
                    <li><a href="#">而ㅻ�ㅻ땲�떚</a></li>
                    <li><a href="#">異붿쿇 �떆裕щ젅�씠�뀡</a></li>
                </ul>
            </div>

            <div class="head-right">

                <div class="search-box">
                
                <input type="text" class="search-txt" placeholder="�쁺�솕�젣紐�,媛먮룆,諛곗슦" >
                <a href="#" class="search-btn"><i class="fa-solid fa-magnifying-glass" ></i></a>
                </div>

                <div><a href="#"><i class="fa-solid fa-heart"></i></a></div>
                <div><a href="#"><i class="fa-solid fa-user"></i></a></div>

            </div>

        </header>

        <section class="main">
            <div class="test_main">
               
                <img src="${contextPath}/resources/images/異붿쿇�쁺�솕�뀒�뒪�듃.png" class="test_main_img"  >
                
            <div class="test_start_btn" onclick="begin()">�떆裕щ젅�씠�뀡 �떆�옉<img src="${contextPath}/resources/images/play (1).png" class="test_start_btn_img"></div>
        </div>
             
            

        </section>
       
        <section id="qna" >
            
            <div class="test_page">
                <div class="simulation_top">
                    <span id="simul_count_num" ></span><span class="simul_total_num">/12</span>
                </div>
             <div class="status">
                <div class="statusBar">

                </div>
             </div>


            <div class="question_p">

            </div>
            <div class="answerBox">

            </div>
        
        </div>

            
       
        </section>


        <section id="result">
            <p class="main_Center">�떦�떊�쓣 �쐞�븳 �삤�뒛�쓽 �쁺�솕�뒗??</p>
            <div class="test_finall_main">
                <div class="arrow">
                </div>
           
                <div class="resultParent">
               </div>
 	
 			
 			   <img src='${contextPath}${movie.moviePoster}'  width='300px' id="movieImg"  alt="Movie Poster" >
                <div class="resultImg" id="resultSort">
                    <div class="resultText" id="resultSort"></div>
                  
            </div>
            
                <div class="arrow">
                </div>
            </div>

        </section>
        <script src="${contextPath}/resources/js/simulation/data.js" charset="utf-8"></script>
        <script src="${contextPath}/resources/js//simulation/start.js" charset="utf-8"></script>
     




    </main>
    <footer>
        <p><a href="#">�씠�슜�빟愿�</a></p>
        <p><a href="#">媛쒖씤�젙蹂댁쿂由щ갑移�</a></p>
        <p><a href="#">怨좉컼�꽱�꽣</a></p>
        <p><a href="#">(二�)KH</a></p>
    </footer>
    
</body>
>>>>>>> e835c5caaf0bcedaacdd97100902a0d425438a07
</html>