const main = document.querySelector(".main");
const qna = document.querySelector("#qna");
const simul_count_num = document.querySelector("#simul_count_num");
const result = document.querySelector("#result");
const endPoint = 12;


function goResult(){
  qna.style.WebkitAnimation = "fadeOut 0.1s";
  qna.style.animation = "fadeOut 0.1s";
  setTimeout(() => {
    result.style.WebkitAnimation = "fadeIn 0.1s";
    result.style.animation = "fadeIn 0.1s";
    setTimeout(() => {
      qna.style.display = "none";
      result.style.display = "block"
    }, 200)})
   // setResult();
}

function addAnswer(answerText, qIdx){
  var a = document.querySelector('.answerBox');
  var answer = document.createElement('button');
  answer.classList.add('answerList');
  answer.classList.add('my-3');
  answer.classList.add('py-3');
  answer.classList.add('mx-auto');
  answer.classList.add('fadeIn');

  a.appendChild(answer);
  answer.innerHTML = answerText;

  answer.addEventListener("click", function(){
    var children = document.querySelectorAll('.answerList');
    for(let i = 0; i < children.length; i++){
      children[i].disabled = true;
      children[i].style.WebkitAnimation = "fadeOut 0.5s";
      children[i].style.animation = "fadeOut 0.5s";
    }
    setTimeout(() => {
      for(let i = 0; i < children.length; i++){
        children[i].style.display = 'none';
      }
      goNext(++qIdx);
    },200)
  }, false);
}

function goNext(qIdx){
  var q = document.querySelector('.question_p');
  q.innerHTML = qnaList[qIdx].q;
  for(let i in qnaList[qIdx].a){
    addAnswer(qnaList[qIdx].a[i].answer, qIdx);
  }
  var status = document.querySelector('.statusBar');
  status.style.width = (100/endPoint) * (qIdx+1) + '%';
  simul_count_num.innerHTML = "<span id='simul_count_num' style='color:rgb(211, 84, 0);font-size: 25px;'>"+(qIdx+1)+"</span>";
  // 시뮬레이션 카운트 처리 
}

function begin(){
  console.log(randomArray);
  main.style.WebkitAnimation = "fadeOut 1s";
  main.style.animation = "fadeOut 1s";
  setTimeout(() => {
    qna.style.WebkitAnimation = "fadeIn 1s";
    qna.style.animation = "fadeIn 1s";
    setTimeout(() => {
      main.style.display = "none";
      qna.style.display = "block"
    }, 200)
    let qIdx = 0;
    goNext(qIdx);
  }, 200);
}
