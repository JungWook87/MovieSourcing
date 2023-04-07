


// 비밀번호 바꾸기

const newPw1 = document.getElementById("newPw1");
const regEx = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[a-zA-Z0-9\d$@$!%*#?&]{8,15}$/;
const newPw2 = document.getElementById("newPw2");
const pwCheck = document.getElementById("pwCheck");
const newPwObj = {
    "newPwCheck" : false
}

newPw2.addEventListener("keyup",function(){
    if(regEx.test(newPw1.value)){
        if(newPw2.value == newPw1.value){
            pwCheck.innerText = "사용가능";
            pwCheck.style.color = "springgreen";
            pwCheck.style.fontWeight = "bold";

            newPwObj.newPwCheck = true;

            console.log(newPwObj.newPwCheck);
        } else {
            pwCheck.innerText = "비밀번호가 일치하지 않습니다.";
            pwCheck.style.color = "tomato";
            pwCheck.style.fontWeight = "bold";
            
            newPwObj.newPwCheck = false;

            console.log(newPnewPwObj.newPwCheckwObj);
        }
    } else {
        pwCheck.innerText = "비밀번호 형식이 맞지 않습니다";
        pwCheck.style.color = "tomato";
        pwCheck.style.fontWeight = "bold";
        
        newPwObj.newPwCheck = false;
        
        console.log(newPwObj.newPwCheck);
    }  
})


// 타이핑숫자
$("#nicknameArea").on("input",function(){
    $(".nicknameCounter").text($(this).val().length);
})


$("#introduceArea").on("input",function(){ 
    $(".introCounter").text($(this).val().length);
})

const newPwOverlay = document.getElementById("newPwOverlay");
const changePw = document.getElementById("changeA");
const changeBtn = document.getElementById("changeBtn");

changePw.addEventListener("click", function(){
    newPwOverlay.style.display = "flex"; 
})

changeBtn.addEventListener("click", function(){
    if(newPwObj) {

        newPwOverlay.style.display = "none";
    } else {
        
        alert("형식에 맞지 않습니다")
    }
})

newPwOverlay.addEventListener("click", e =>{
    const evTarget = e.target;
    if(evTarget.classList.contains("newPwOverlay")){
        newPwOverlay.style.display = "none";
    }
})

