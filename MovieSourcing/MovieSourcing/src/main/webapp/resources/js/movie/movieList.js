const scoreCircle = document.getElementById("scoreCircle");
const movieScore = document.getElementById("movieScore");
let userScore = document.getElementById("movieScore").innerText;
var score = Number(userScore);


if (score >= 10.0){
    scoreCircle.style.color = "springgreen";
    movieScore.style.color = "springgreen";
} else if (score >= 5.5 && score < 7.5) {
    scoreCircle.style.color = "yellow";
    movieScore.style.color = "yellow";
} else if ( score >= 3.5 && score < 5.5 ) {
    scoreCircle.style.color = "white";
    movieScore.style.color = "white";
} else if (score < 3.5) {
    scoreCircle.style.color = "red";
    movieScore.style.color = "red";
}
