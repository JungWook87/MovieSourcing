<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="pagination" value="${map.pagination}" />
<c:set var="boardList" value="${map.boardList}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/boardList.css">
    <script src="https://kit.fontawesome.com/0041fb1dcb.js" crossorigin="anonymous"></script>
    <title>커뮤니티 게시판</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
</head>
<body>
    <main>
    
     	<c:if test="${!empty param.key}">
            <c:set var="sURL" value="&query=${param.query}" />
        </c:if>

        <section class="main">
                        
            <div class="community">

                <div class="search_area">

                    <div>
                        <div class="fa-solid fa-magnifying-glass" style="color: white"></div>
                        <input type="text" id="search_bar" placeholder="커뮤니티 검색">
                    </div>
                    
                </div>

                <div class="commu_area">
					<c:choose>
						<c:when test="${empty boardList}">
							<h3>게시글이 존재하지 않습니다</h5>
						</c:when>
						
						<c:otherwise>
							<c:forEach var="board" items="${boardList}">
								<div class="com_box">
									
			                        <div class="com_member">
			
			                            <div class="user_pic_nic">
			
			                                <a href="#"><img class="memPic" src="${contextPath}${board.memPic}"  style="width:50px; height:30px;"></a>
			
			                                <a href="#">${board.memNic}</a>
			
			                            </div>
			
			                            <div class="com_date">${board.comDate}</div>
			
			                        </div>
			
			                        <div class="com_title">
			                            <a href="detail?comNo=${board.comNo}&cp=${pagination.currentPage}">${board.comTitle}</a>
			                        </div>
			
			                        <div class="com_cont" id="com_cont">
			                            <a href="detail?comNo=${board.comNo}&cp=${pagination.currentPage}">${board.comContent}</a>
			                        </div>

                                    <div class="com_thunmnail">
                                        <img src="">
                                    </div>
			
			                        <div class="readCnt_replyCnt">
			                            <!-- readCnt -->
                                        <div>
                                            <i class="fa-solid fa-eye" id="viewImg"></i>
                                            ${board.readCount}
                                        </div>
                                        <!-- replyCnt -->
			                            <div>
                                            <i class="fa-solid fa-pen-nib" id="viewImg"></i>
                                            ${board.replyCount}
                                        </div>
			                        </div>
			
			                    </div>
							</c:forEach>
						</c:otherwise>
					</c:choose>	
                                
                </div>    
                
            </div>
            
            <div class="pagination-area">

                <!-- 페이지네이션 a태그에 사용될 공통 주소를 저장한 변수 선언 -->
                <c:set var="url" value="list?cp="/>


                <ul class="pagination">
                    <!-- 첫 페이지로 이동 -->
                    <li><a href="${url}1${sURL}">&lt;&lt;</a></li>

                    <!-- 이전 목록 마지막 번호로 이동 -->
                    <li><a href="${url}${pagination.prevPage}${sURL}">&lt;</a></li>

                    <!-- 범위가 정해진 일반 for문 사용 -->
                    <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">

                        <c:choose>
                            <c:when test="${i == pagination.currentPage}">
                                <li><a class="current">${i}</a></li>
                            </c:when>

                            <c:otherwise>
                                <li><a href="${url}${i}${sURL}">${i}</a></li>        
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                    
                    <!-- 다음 목록 시작 번호로 이동 -->
                    <li><a href="${url}${pagination.nextPage}${sURL}">&gt;</a></li>

                    <!-- 끝 페이지로 이동 -->
                    <li><a href="${url}${pagination.maxPage}${sURL}">&gt;&gt;</a></li>

                </ul>
            </div>
            
        </section>
        
        <div class="side">
            
            <div class="side-1">
                <a href="#">
                    <img src="${contextPath}/resources/images/추천영화테스트.png" width="100%">
                </a>

                <div>
                    <button type="button" id="top_btn">
                        <i class="fa-solid fa-arrow-up"></i>
                        top
                    </button>
                </div>
            </div>


        </div>
		
    </main>
    
    <script src="${contextPath}/resources/js/board/boardList.js"></script>
</body>
</html>