
// 이메일 유효성 검사
let EmailObj = false;
let cNumberObj = false;

const email = document.getElementById("email");
const emailMessage = document.querySelector("#emailMessage");
const regExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;


const cNumberBtn = document.getElementById("cNumberBtn");
const cMessage = document.getElementById("cMessage");

cNumberBtn.addEventListener("click",function(){
EmailObj = true;
    if(EmailObj){

        $.ajax({
            url : "searchId",
            data : {"email" : email.value},
            type : "GET",
            success : function(emailResult){
				  if(emailResult == 1){ // 중복일 경우
				    alert("인증번호가 발송되었습니다. 이메일을 확인해주세요.")
                console.log(emailResult.value);
                 console.log(email.value);
                cNumberObj = true;
                }else{
					 console.log(emailResult.value);
					  alert("가입된 이메일이 다르거나 가입되지않았습니다 .");
					 cNumberObj = false;
				}
            },
            error : function(){
                console.log("뭐임?")
            }     
        });


      
   }
});
