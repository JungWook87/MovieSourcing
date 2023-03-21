const watchedText = document.getElementById("watchedText");

document.getElementById("toggle1").addEventListener("click",function(){
    if(toggle1.checked == true) {
        watchedText.innerText = "본 영화에요";
        watchedText.style.color = "springgreen";
    } else{
        watchedText.innerText = "못 본 영화에요";
        watchedText.style.color = "rgb(214, 211, 206)";
    }
})

const scoreLight1 = document.getElementById("scoreLight1");
var userScore1 = document.getElementById("userScore1").innerText;
var score1 = Number(userScore1);


if (score1 >= 4.0){
    scoreLight1.style.backgroundColor = "springgreen";
} else if (score1 >= 3.0 && score1 < 4.0) {
    scoreLight1.style.backgroundColor = "yellow";
} else if ( score1 >= 2.0 && score1 < 3.0 ) {
    scoreLight1.style.backgroundColor = "white";
} else if (score1 < 2.0) {
    scoreLight1.style.backgroundColor = "red";
}

const scoreLight2 = document.getElementById("scoreLight2");
var userScore2 = document.getElementById("userScore2").innerText;
var score2 = Number(userScore2);


if (score2 >= 4.0){
    scoreLight2.style.backgroundColor = "springgreen";
} else if (score2 >= 3.0 && score2 < 4.0) {
    scoreLight2.style.backgroundColor = "yellow";
} else if ( score2 >= 2.0 && score2 < 3.0 ) {
    scoreLight2.style.backgroundColor = "white";
} else if (score2 < 2.0) {
    scoreLight2.style.backgroundColor = "red";
}