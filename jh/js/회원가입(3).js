
// 이메일 유효성 검사
const EmailObj = false;
const cNumberObj = false;

const memberEmail = document.getElementById("email");
const emailMessage = document.querySelector("#emailMessage");
const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

memberEmail.addEventListener("input", function(){
    if(memberEmail.value.length == 0 ){
        emailMessage.innerText("");
        return;
    }
    if(regExp.test(memberEmail.value)){
        emailMessage.innerText = "유효한 이메일 주소입니다";
        EmailObj = true;
    } else {
        emailMessage.innerText = "유효하지않은 이메일 주소입니다.";
        EmailObj = false;
    }
});


const cNumberBtn = document.getElementById("cNumberBtn");
const cMessage = document.getElementById("cMessage");

cNumberBtn.addEventListener("click",function(){

    if(EmailObj){

        $.ajax({
            url : "sendEmail",
            data : {"memberEmail" : memberEmail.value},
            type : "GET",
            success : function(emailResult){
                cNumberObj = true;
            },
            error : function(){
                console.log("뭐임?")
            }     
        })

    }
})