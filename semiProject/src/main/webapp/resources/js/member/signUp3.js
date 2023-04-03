
// 이메일 유효성 검사

const cNumberObj = false;

const memberEmail = document.getElementById("email");
const emailMessage = document.querySelector("#emailMessage");
const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

memberEmail.addEventListener("input", function(){
	const EmailObj = false;
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
console.log("dd");
    if(EmailObj){

        $.ajax({
            url : "sendEmail",
            data : {"memberEmail" : memberEmail.value},
            type : "GET",
            success : function(emailResult){
                console.log(emailResult);
                cNumberObj = true;
            },
            error : function(){
                console.log("뭐임?")
            }     
        });

        cMessage.innerText = "3:00";
        min = 2;
        sec = 59;

        checkInterval = setInterval(function(){
            if(sec<10) sec = "0" + sec;
            cMessage.innerText = min + ":" + sec;
            if(Number(sec) === 0 ){
                min--;
                sec = 59;
            } else {
                sec--; 
            }

            if(min === -1){
                cMessage.innerText = "인증번호 만료";

                clearInterval(checkInterval);
            }
                
        }, 1000);

        alert("인증번호가 발송되었습니다. 이메일을 확인해주세요.")
    }
})