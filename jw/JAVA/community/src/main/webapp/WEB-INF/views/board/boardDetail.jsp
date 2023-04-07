<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="detail" value="${boardDetail}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/boardDetail.css">

    <script src="https://kit.fontawesome.com/47910b9f42.js" crossorigin="anonymous"></script>
    

    <title>커뮤니티페이지</title>
</head>
<body>
    <div id="movieSourcing">
        <div id="layout">
            <div id="root">

                <!-- 메인 -->
                <main id="contents">

                    <!-- 상단 커뮤니티 단추 -->
                    <div id="communityBar">
                        <div id="communityHomeBtn">
                            <button class="fa-solid fa-house" id="comHomeImg" type="button" 
                            onClick="location.href='list'">
                                <span>커뮤니티</span>
                            </button >
                        </div>

                        <!-- 수정, 삭제, 신고 메뉴 -->
                        <div class="UD_menu">

                            <!-- 클릭시 나오는 메뉴 -->
                            <div id="popup_menu">
                                <ul class="popup_main_menu">
                                    <!-- session 이용하여 회원 정보 일치시 수정 삭제 버튼 보이고 아니면 안보이게 -->
                                    <li><a href="write?mode=update&comNo=${detail.comNo}">수정</a></li>
                                    <li><a href="">삭제</a></li>
                                    <li><a href="">신고</a></li>
                                </ul>
                            </div>

                            <!-- ... 보이는 메뉴 -->
                            <button id="communityDotImg" class="fa-solid fa-ellipsis-vertical"></button>
                            <!-- <input id="communityDotImg" type="checkbox">
                            <label class="fa-solid fa-ellipsis-vertical" for="communityDotImg" id="communityDotImg"></label> -->
                            
                        </div>

                    </div>

                    <!-- 커뮤니티  -->
                    <div id="communityContents">
                        <div id="mainContent">
                            <div id="contentInfo">
                                <div>
                                    <a><img src="${contextPath}${detail.memPic}" style="width:20px; height:20px"></a>
                                    <a href="#" id="userNick">${detail.memNic}</a>
                                </div>
                                <div>
                                    <span id="howlong">${detail.comDate}</span>
                                </div>
                            </div>

                            <div id="contentSubject">
                                <span class="contentSubject">${detail.comTitle}</span>
                            </div>

                            <div id="contentAll">
 								${detail.comContent}
                            </div>
    
                            <div id="countDiv">
                                <div id="viewCountDiv">
                                    <i class="fa-solid fa-eye" id="viewImg"></i>
                                    <span id="viewCount">${detail.readCount}</span>
                                </div>
                            </div>
    
                        </div>
                        <hr id="line">

                        <!-- 댓글 -->
                        <div id="reply">
                           <div id="replyBar">
                               <span id="replySpan">댓글</span> 
                               <span id="replyCount">${detail.replyCount}</span>
                           </div>
	                    </div>   
	                    
						<c:if test ="${!empty detail.replyList}">
							<c:forEach var="i" begin="0" end="${fn:length(detail.replyList)-1}">
									<div id="replyBox">
										<div id="replyInfo">
											<div>
												<p>${detail.replyList[i].memNic}</p>
											</div>
											
											<div>
											    <span id="howlong">${detail.replyList[i].replyDate}</span>
											</div>
										</div>
										
										<div id="replyContent">
											<span>${detail.replyList[i].replyContent}</span>
										</div>
										
									</div>
							</c:forEach>         
						</c:if>
						<c:if test="${empty detail.replyList}">
							<div id="replyBox-1">
								<p>처음으로 댓글을 달아보세요</p>
							</div>
						</c:if>

                        <hr id="line">
					
						<div id="replyInputDiv">
                            <textarea name="replyInput" id="replyInput" cols="34" rows="1"
                            spellcheck="false" placeholder="댓글을 작성해 주세요"
                            style="resize: none;"></textarea>
                            <button id="replyBtn" onclick="replysubmit()"><span>등록</span></button>
                        </div>

                    </div>
                    
                </main>

            </div>
        </div>
    </div>

    <script src="${contextPath}/resources/js/board/boardDetail.js"></script>
</body>
</html>