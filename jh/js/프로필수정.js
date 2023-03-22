

const newPw1 = document.getElementById("newPw1");
const regEx = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[a-zA-Z0-9\d$@$!%*#?&]{8,15}$/;
const newPw2 = document.getElementById("newPw2");
const pwCheck = document.getElementById("pwCheck");

newPw2.addEventListener("keyup",function(){
    if(regEx.test(newPw1.value)){
        if(newPw2.value == newPw1.value){
            pwCheck.innerText = "비밀번호 일치";
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


$("#introduceArea").on("input",function(){
    
    $(".introCounter").text($(this).val().length);
})
$("#nicknameArea").on("input",function(){
    
    $(".nicknameCounter").text($(this).val().length);
})



document.getElementById("saveBtn").addEventListener("")