//아이디 닉네임 중복체크 
const id = document.getElementById("id");

document.getElementById("iddupcheck")
.addEventListener("click",function(){
    const regEx = /^[a-zA-Z0-9]{5,12}$/;
    if(regEx.test(id.value)){
        // if(){
        // } else {alert("중복입니다")}
        alert("사용가능한 아이디입니다.");
    } else {
        alert("형식에 맞지않습니다.");
    }
})

const nickname = document.getElementById("nickname");

document.getElementById("namedupcheck")
.addEventListener("click",function(){
    const nickRegEx = /^[가-힣a-zA-Z0-9]{2,15}$/;
    if(nickRegEx.test(nickname.value)){
        // if(){
        // } else {alert("중복입니다")}
        alert("사용가능한 닉네임입니다.");
    } else {
        alert("형식에 맞지않습니다.");
    }
})




// 비밀번호 체크

const pw1 = document.getElementById("pw1");
const regEx = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[a-zA-Z0-9\d$@$!%*#?&]{8,15}$/;
const pw2 = document.getElementById("pw2");
const pwCheck = document.getElementById("pwCheck");


pw2.addEventListener("keyup",function(){
    if(regEx.test(pw1.value)){
        if(pw2.value == pw1.value){
            pwCheck.innerText = "사용가능한 비밀번호 입니다.";
            pwCheck.style.color = "springgreen";
            pwCheck.style.fontWeight = "bold";
        } else {
            pwCheck.innerText = "비밀번호가 일치하지 않습니다.";
            pwCheck.style.color = "tomato";
            pwCheck.style.fontWeight = "bold";
        }
    } else {
        pwCheck.innerText = "비밀번호 형식이 맞지 않습니다";
        pwCheck.style.color = "tomato";
        pwCheck.style.fontWeight = "bold";
    }  
})


// 출생연도
$(document).ready(function(){            
    var now = new Date();
    // var year = now.getFullYear();
    // var mon = (now.getMonth() + 1) > 9 ? ''+(now.getMonth() + 1) : '0'+(now.getMonth() + 1); 

    for(var i = 2023 ; i >= 1920 ; i--) {
        $('#year').append('<option value="' + i + '">' + i + '년</option>');    
    }
    
    for(var i=1; i <= 12; i++) {
        var mm = i > 9 ? i : "0"+i ;            
        $('#month').append('<option value="' + mm + '">' + mm + '월</option>');    
    }
})