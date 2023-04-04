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


const homebutton = document.getElementById("homebutton");

homebutton.addEventListener("click", function() {
    window.open("semi-main.html", "_self");

});



//top 버튼 클릭시 위로 이동
$(window).scroll(function() {
    if($(this).scrollTop() > 100) {
        $('.elw').addClass('on');
    }else {
        $('.elw').removeClass('on');
    }
});

$('.elw').click(function() {
    window.scrollTo({top : 0, behavior: 'smooth'});
});
