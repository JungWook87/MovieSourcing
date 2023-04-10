console.log("boardDetail js loaded")

const dotImg = document.getElementById("communityDotImg");
const popup_menu = document.getElementById("popup_menu");

dotImg.addEventListener("click", () => {

    if(popup_menu.style.display === 'flex'){
        popup_menu.style.display='none';
    } else{
        popup_menu.style.display='flex';
    }
});


/* ------------------------- */
/* 댓글 */
/*
const replyInput = document.getElementById("replyInput");

function resize(obj){
    obj.style.height = "1px";
    obj.style.height = (1+obj.scrollHeight)+"px";
    
    if(obj.style.height > "70px"){
       obj.style.height = "70px";
       obj.style.overflow = "visible";
    }
}*/

// 댓글 등록 AJAX

function replysubmit(){
	
    $.ajax({
        url : "reply",
        data : {"comNo" : comNo,
        		"content" : $("#replyInput").val()
        		//"userNic" : "로그인닉값"
        		},
        type : "GET",
        dataType : "JSON",
        success : function(result){
			 document.location.reload();
		}
    })
    
    window.location.reload();
};