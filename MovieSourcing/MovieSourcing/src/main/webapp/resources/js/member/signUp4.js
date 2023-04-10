
// 이메일 유효성 검사
const EmailObj = true;
const cNumberObj = false;

const memberEmail = document.getElementById("email");
const emailMessage = document.querySelector("#emailMessage");
const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;


const cNumberBtn = document.getElementById("cNumberBtn");
const cMessage = document.getElementById("cMessage");

cNumberBtn.addEventListener("click",function(){

    if(EmailObj){

        $.ajax({
            url : "sendIdEmail",
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


        alert("인증번호가 발송되었습니다. 이메일을 확인해주세요.")
    }
});
