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
})
// 버튼 클릭시 클래스 추가, 제거 하는법 추가하기

const homebutton = document.getElementById("homebutton");

homebutton.addEventListener("click", function() {
    window.open("semi-main.html", "_self");

});
