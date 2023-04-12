console.log("movieInfo js 들어옴")

const watchedText = document.getElementById("watchedText");

document.getElementById("toggle1").addEventListener("click", function(){
        document.getElementById("submit1").click()
});

function submit_1(loginMemberNo, movieNo){
	
	if(!loginMemberNo){
		
		window.alert("로그인을 해주세요");
		toggle1.checked = false;
		
		return false;
	} else{
		
		if(toggle1.checked == true) {
	        watchedText.innerText = "본 영화에요";
	        watchedText.style.color = "springgreen";
	        
	        const mode = "insert";
	        
			$.ajax({
				 url : "watchedMovie",
				 data : {"memNo" : loginMemberNo,
				 		"movieNo" : movieNo,
				 		"mode" : mode
				 },
				 type : "GET",
				 dataType : "JSON"
			 });
			 
	         return false;
	    } else{
	        watchedText.innerText = "못 본 영화에요";
	        watchedText.style.color = "rgb(214, 211, 206)";
	        
	        const mode = "delete";
			$.ajax({
				 url : "watchedMovie",
				 data : {"memNo" : loginMemberNo,
				 		"movieNo" : movieNo,
				 		"mode" : mode
				 },
				 type : "GET",
				 dataType : "JSON"
			 });
			
			 return false;
		}
		
	}
	return false;
}


const wannaheart = document.getElementById("wannaheart");

wannaheart.addEventListener("click", function(){
	document.getElementById("submit2").click()
})

function submit_2(loginMemberNo, movieNo){
	if(!loginMemberNo){
		window.alert("로그인을 해주세요");
		return false;
	} else{
		if(wannaheart.style.color == "white"){
			wannaheart.style.color = "pink";
			const mode = "insert";
			
			$.ajax({
				url : "wannaMovie",
				data : {"memNo" : loginMemberNo,
						"movieNo" : movieNo,
						"mode" : mode
				},
				type : "GET",
				dataType : "JSON"
			});
			
		} else{
			wannaheart.style.color = "white";
			
			const mode = "delete";
			
			$.ajax({
				url : "wannaMovie",
				data : {"memNo" : loginMemberNo,
						"movieNo" : movieNo,
						"mode" : mode
				},
				type : "GET",
				dataType : "JSON"
			});
			
			
			
		}
		return false;
	}
}







/*
if(!movieReview){
	console.log("비어있음")
} else{
	
	const userScore = document.getElementsByClassName("userScore1");
	const scoreLight1 = document.getElementById("scoreLight1");
	var userScore1 = document.getElementById("userScore1").innerText;
	var score1 = Number(userScore1);
	
	for(let i = 0; i < userScore.length; i++){
		
		if (score1 >= 4.0){
		    scoreLight1.style.backgroundColor = "springgreen";
		} else if (score1 >= 3.0 && score1 < 4.0) {
		    scoreLight1.style.backgroundColor = "yellow";
		} else if ( score1 >= 2.0 && score1 < 3.0 ) {
		    scoreLight1.style.backgroundColor = "white";
		} else if (score1 < 2.0) {
		    scoreLight1.style.backgroundColor = "red";
		}
	}
}
*/
	



// 모달창 변수 선언

const reviewWrite = document.getElementById("reviewWrite");
const reviewOverlay = document.getElementById("reviewOverlay");
const reviewWriteBox = document.getElementById("reviewWriteBox");
const nav = document.getElementsByClassName("nav");

reviewWrite.addEventListener("click", function() {
	
	
    reviewOverlay.style.display = "flex";
    reviewOverlay.style.position = "fixed";
    // nav[0].style.display = "none";
})


// 리뷰모달 작성글 숫자

const reviewSubmit = document.getElementById("reviewSubmit");
const reviewObj = {
    "reviewCheck" : false
}


$("#reviewArea").on("input",function(){
    $("#reviewCounter").text($(this).val().length);
    if($("#reviewCounter").text($(this).val().length)<=100){
        reviewObj.reviewCheck = true;
    } else {
        reviewObj.reviewCheck = false;
    }
})

reviewSubmit.addEventListener("click", function(){
    if(reviewObj.reviewCheck) {
        
    } else {
        alert("100자이내로 작성해주세요")
    }
})


// 별점 모달
const drawStar = (target) => {
    document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
    console.log(target.value*0.5);
}


// 모달 오버레이 클릭시

reviewOverlay.addEventListener("click", e => {
    const evTarget = e.target;
        if(evTarget.classList.contains("reviewOverlay")){
            reviewOverlay.style.display = "none ";
        }

})

