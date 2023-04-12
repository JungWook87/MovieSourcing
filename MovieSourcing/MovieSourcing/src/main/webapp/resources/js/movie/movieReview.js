
const scoreLight = document.getElementById("scoreLight");
var userScore = document.getElementById("userScore").innerText;
var score = Number(userScore);


if (score >= 4.0){
    scoreLight.style.backgroundColor = "springgreen";
} else if (score >= 3.0 && score < 4.0) {
    scoreLight.style.backgroundColor = "yellow";
} else if ( score >= 2.0 && score < 3.0 ) {
    scoreLight.style.backgroundColor = "white";
} else if (score < 2.0) {
    scoreLight.style.backgroundColor = "red";
}
