
// DB에서 가져온 커뮤니티 전체 테이블, JSON -> JS
const communityTableJson = '{"memberID" : "user01", "memberPw" : "pass01", "age" : 20}';
// const communityTable = JSON.parse(communityTableJson);
const str= "시설에서 수많은 이들이 죽은 의문의 사고. 그날 밤 홀로 탈출한 후 모든 기억을 잃고 살아온 고등학생 ‘자윤’ 앞에 의문의 인물들이 등장하기 시작하고, 자신이 기억하지 못하는 과거를 "
+ "알고 있는 그들의 등장으로 자윤은 혼란에 휩싸이게 되는데...! '마녀'는 이 영화의 감독인 '박훈정' 감독에게나, 영화를 제작한 '워너'에게나 꽤나 중요한 작품이 아니었을까 싶다. "
+ "박훈정 감독은 '신세계'(2012)의 대성공 이후 '대호'(2015)와 '브이아이피'(2017)를 연달아 내놓았지만 모두 실망스러운 성적을 거뒀고,  워너 역시 '밀정'(2016)의 대성공 이후 내놓은 '싱글라이더'(2017)와 '브이아이피(2017)' 모두 부진했다. "
+ "여러 방향에서 중요한 이정표가 될 '마녀'는, 다행히도 꽤나 만족스러운 결과물을 보여준다. '마녀'는 이미 마르고 닳도록 쓰인 소재를..." 

const communityTable = {"poster":"../img/마녀.jpg", "memPic":"", "memNic":"다미여신", "comDate":"2023.03.02",
    "comTitle":"기대되는 신인배우 김다미", "comCont": str}
const comTableArr = communityTable;


// 테이블 JS 객체 전환 후 각 요소 접근하여 대입
    // 포스터
    // 포스터 위치 배열
    const postImg = document.getElementsByClassName("com_img");

    for(let i =0; i < 10; i++){
        postImg[i].setAttribute("src", communityTable.poster);
    }

    // 프로필 이미지
    // 회원 프로필 사진 위치 배열
    const memberPic = document.getElementsByClassName("com_member_pic");
    
    for(let i =0; i < 10; i++){
        memberPic[i].setAttribute("src", communityTable.memPic);
    }


    // 회원 닉네임
    // 닉네임 위치 배열
    const memberNic = document.getElementsByClassName("com_member_nic");

    for(let i =0; i < 10; i++){
        memberNic[i].firstElementChild.firstElementChild.innerText= communityTable.memNic;
    }

    // 작성일
    const comDate = document.getElementsByClassName("com_member_date");
    for(let i =0; i < 10; i++){
        comDate[i].firstElementChild.innerText = communityTable.comDate;
    }

    // 커뮤니티 제목
    const communityTitle = document.getElementsByClassName("com_title");
    for(let i =0; i < 10; i++){
        communityTitle[i].firstElementChild.innerText = communityTable.comTitle;
    }

    const comCont = document.getElementsByClassName("com_cont");
    for(let i =0; i < 10; i++){
        comCont[i].firstElementChild.innerText = communityTable.comCont;
    }


// ----------------------------------------------------------------------------------

// 검색창
const searchBar = document.getElementById("search_bar");

// 리셋 버튼
const resetBtn = document.getElementById("com_reset_btn");

// 검색 바 '엔터키' 입력 실행
searchBar.addEventListener("keyup", function() {
    if(window.event.key == "Enter"){
        console.log(searchBar.value);
    }
});

// ----------------------------------------------------------------------------------------

// 리셋버튼 클릭시
resetBtn.addEventListener("click", function() {

    // 포스터
    // DB에서 전체 테이블을 JSON형태로 가져오고
    // JSON에서 JS타입으로 변경 후 각 포스터 이미지 자리에 대입

    for(let i = 0; i < postImg.length; i++){
        postImg[i].removeAttribute("src");
        postImg[i].setAttribute("src", "../img/에브리씽.jpg");
    }

    // 프로필 사진
    for(let i =0; i < 10; i++){
        memberPic[i].setAttribute("src", communityTable.memPic);
    }
    
    // 회원 닉네임
    // 닉네임 위치 배열
    const memberNic = document.getElementsByClassName("com_member_nic");

    for(let i =0; i < 10; i++){
        memberNic[i].firstElementChild.firstElementChild.innerText= communityTable.memNic;
    }

    // 작성일
    const comDate = document.getElementsByClassName("com_member_date");
    for(let i =0; i < 10; i++){
        comDate[i].firstElementChild.innerText = communityTable.comDate;
    }

    // 커뮤니티 제목
    const communityTitle = document.getElementsByClassName("com_title");
    for(let i =0; i < 10; i++){
        communityTitle[i].firstElementChild.innerText = communityTable.comTitle;
    }

    const comCont = document.getElementsByClassName("com_cont");
    for(let i =0; i < 10; i++){
        comCont[i].firstElementChild.innerText = communityTable.comCont;
    }


});