



const janrbutton = document.getElementById("janrbutton");

janrbutton.addEventListener("click", function() {
    window.open("semi-mlist.html", "_self");
});





// 첫번째 영화추천 슬라이드
let slides = document.querySelector('.slides'),
    slide = document.querySelectorAll('.slides li'),
    currentIdx = 0,
    slideCount = slide.length,
    prevBtn = document.querySelector('.prev'),
    slideWidth = 200,
    slideMargin = 30,
    nextBtn = document.querySelector('.next');

    slides.style.width = (slideWidth + slideMargin)*slideCount - slideMargin + 'px';

makeClone1();

function moveSlide(num) {
    slides.style.left = -num * (slideWidth + slideMargin) + 'px';
    currentIdx = num;
    console.log(currentIdx, slideCount);
    if(currentIdx == slideCount || currentIdx == -slideCount) {
       
        setTimeout(function() {
           slides.classList.remove('animated');
           slides.style.left = '0px';
           currentIdx = 0;
        }, 500);
       
        setTimeout(function() {
       
          slides.classList.add('animated');
       
        }, 700);
        
    }
};
       
function makeClone1() {
    for(var i = 0; i<slideCount; i++) {
        var cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.appendChild(cloneSlide);
    }
    for(var i =  slideCount -1; i>=0; i--){
        var cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.prepend(cloneSlide);
     }
    updateWidth1();
    setInitialPos1();
    setTimeout(function() {
       slides.classList.add('animated');
       
    },100);
}
       
function updateWidth1() {
    var currentSlides = document.querySelectorAll('.slides li');
    var newSlideCount = currentSlides.length;
       
    var newWidth = (slideWidth + slideMargin) * newSlideCount - slideMargin + 'px';
    slides.style.width = newWidth;
       
}
       
function setInitialPos1() {
    var initialTranslateValue = -(slideWidth + slideMargin) * slideCount
       
    slides.style.transform = 'translateX(' + initialTranslateValue + 'px)';
       
}
nextBtn.addEventListener('click', function() {
    moveSlide(currentIdx + 1);
});
prevBtn.addEventListener('click', function() {
    moveSlide(currentIdx -1);
});





/*    
function moveSlide(num) {

    slides.style.left = -num * 230 + 'px';
    
    currentIdx = num;

};
*/

/*// 자동슬라이드
interval = setInterval(function() {
    currentIdx++
    if(currentIdx < slideCount -3 ) {
        moveSlide(currentIdx);

    }else{
        moveSlide(0);
    }

}, 2000);
*/


// 정적인 슬라이드
/*setInterval(function() {
    var from = -(230 * currentIdx);
    var to = from - 230;
    slides.animate({
        marginLeft: [from + "px", to + "px"]
    }, {
        duration: 500,
        easing: "ease-in-out",
        iterations: 0,
        fill: "both"
    });
    currentIdx++;
    if (currentIdx === (slide.length - 3)) {
        currentIdx = 0;
    }
}, 2000);
*/



//수동 슬라이드
nextBtn.addEventListener('click', function() {

    if(currentIdx < slideCount -4 ) {
        moveSlide(currentIdx + 1);
        console.log(currentIdx);
    }else {
        moveSlide(0);
    }
}); 

prevBtn.addEventListener('click', function() {

    if(currentIdx > 0 ) {
        moveSlide(currentIdx - 1);
        
    }else {
        moveSlide(slideCount - 4);
    }
});


// 둦번쨰 영화추천 슬라이드
let slides2 = document.querySelector('.slides2'),
    slide2 = document.querySelectorAll('.slides2 li'),
    currentIdx2 = 0,
    slideCount2 = slide2.length,
    prevBtn2 = document.querySelector('.prev2'),
    slideWidth2 = 200,
    slideMargin2 = 30,
    nextBtn2 = document.querySelector('.next2');

    slides2.style.width = (slideWidth2 + slideMargin2)*slideCount2 - slideMargin2 + 'px';


function moveSlide2(num) {

    slides2.style.left = -num * 230 + 'px';
    
    currentIdx2 = num;

}

nextBtn2.addEventListener('click', function() {

    if(currentIdx2 < slideCount2 -4 ) {
        moveSlide2(currentIdx2 + 1);
        console.log(currentIdx2);
    }else {
        moveSlide2(0);
    }
});

prevBtn2.addEventListener('click', function() {

    if(currentIdx2 > 0 ) {
        moveSlide2(currentIdx2 - 1);
        
    }else {
        moveSlide2(slideCount2 - 4);
    }
});

//메인포스터 슬라이드

let mslides = document.querySelector('.main-slides'),
    mslide = document.querySelectorAll('.main-slides li'),
    mcurrentIdx = 0,
    mslideCount = mslide.length,
    mslideWidth = 1920,
    mslideMargin = 0;

    /*mslides.style.width = (mslideWidth + mslideMargin)*mslideCount - mslideMargin + 'px';*/

    makeClone();

/*function mmoveSlide(mnum) {

    mslides.style.left = -mnum * 1950 + 'px';
    
    mcurrentIdx = mnum;

};*/


function mmoveSlide(mnum) {
 mslides.style.left = -mnum * (mslideWidth + mslideMargin) + 'px';
 mcurrentIdx = mnum;
 if(mcurrentIdx == mslideCount || mcurrentIdx == -mslideCount) {

    setTimeout(function() {
        mslides.classList.remove('animated');
        mslides.style.left = '0px';
        mcurrentIdx = 0;
    }, 500);

    setTimeout(function() {

        mslides.classList.add('animated');

    }, 700);
 
 }
};

function makeClone() {
    for(var i = 0; i<mslideCount; i++) {
        var cloneSlide = mslide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        mslides.appendChild(cloneSlide);
    }
    for(var i =  mslideCount -1; i>=0; i--){
        var cloneSlide = mslide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        mslides.prepend(cloneSlide);
    }
    updateWidth();
    setInitialPos();
    setTimeout(function() {
        mslides.classList.add('animated');

    },100);
}

function updateWidth() {
    var currentSlides = document.querySelectorAll('.main-slides li');
    var newSlideCount = currentSlides.length;

    var newWidth = (mslideWidth + mslideMargin) * newSlideCount - mslideMargin + 'px';
    mslides.style.width = newWidth;

}

function setInitialPos() {
    var initialTranslateValue = -(mslideWidth + mslideMargin) * mslideCount

    mslides.style.transform = 'translateX(' + initialTranslateValue + 'px)';

}

var timer = undefined;

function autoSlide() {
    if(timer == undefined) {
        timer = setInterval(function() {
            mmoveSlide(mcurrentIdx +1);
        }, 2000);
    }
}
autoSlide();
function stopSlide() {
    clearInterval(timer);

    timer = undefined;

}
mslides.addEventListener('mouseenter', function() {
    stopSlide();
});
mslides.addEventListener('mouseleave', function() {
    autoSlide();
});









// 자동슬라이드
/*minterval = setInterval(function() {
    mcurrentIdx++
    if(mcurrentIdx < mslideCount ) {
        mmoveSlide(mcurrentIdx+1);

    }else {
        mmoveSlide(0);
    }

}, 2000);
*/






// 인기순위 슬라이드 실험


/*function chart() {
    let chart = document.querySelectorAll(".charts");

    for(let i=0; i<chart.length; i++) {
        chart[i].toggleAttribute('active');
    }
    setTimeout()
}
*/

