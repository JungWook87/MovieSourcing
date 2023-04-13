console.log("js 들어옴")

const janr = document.querySelectorAll('.btn');

janr.forEach((btn)=>{
// 클릭시 버튼색상이 변하는 효과 주는것 css에 있는 효과를 불러오는것

    btn.addEventListener('click', ()=>{
     
        if(btn.classList.contains('active')) {
            btn.classList.remove('active');
        }else {
            btn.classList.add('active');
        }
        
    })
});

//홈 버튼 클릭시 홈 으로 화면 이동
const homebutton = document.getElementById("homebutton");

homebutton.addEventListener("click", function() {
    window.open("semi-main.html", "_self");

});



//top 버튼 클릭시 위로 이동
/*
$('.elw').click(function() {
    window.scrollTo({top : 0, behavior: 'smooth'});
});
*/

//search box 초기화
var searchtext = document.querySelector('.search-txt');

searchtext.addEventListener('blur', function() {

    searchtext.value= "";
});


//검색필터 (진행중)



const input2 = document.getElementsByClassName("nation-btn");
const input3 = document.getElementsByClassName("grade-btn");





function clickjanr(input1) {
    console.log(input1.value)
	const current = document.getElementById('contents');
	
    $.ajax({

        url : "Searchjanr",
        data : {"input1" : input1.value},
        type : "GET",
        datatype : "JSON",
        
        success : function(mlist) {
	
			console.log(mlist);

            if(mlist != null) {
				current.style.display= none;
			}
        },
        
         error: function(request, status, error) {
			console.log("ajax 에러발생");
			console.log("상태코드 : " + request.status); // 404, 500
        }

    });




};