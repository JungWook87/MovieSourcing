const main = document.querySelector(".main");
const qna = document.querySelector("#qna");
const simul_count_num = document.querySelector("#simul_count_num");
const movieRightBtn = document.querySelector(".movie_recommend_right_btn");


const result = document.querySelector("#result");
1
const endPoint = 12;

const select = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

function calResult(){
 

var result = select.indexOf(Math.max(...select));

return result;
}   

function setResult(){
let point = calResult();


  var resultImg = document.createElement('img');
  const imgDiv =  document.querySelector('.resultImg');
  var imgURL = 'img/image-' + point + '.png';
  resultImg.src = imgURL;
  resultImg.alt = point;
  resultImg.classList.add('img-fluid');
  imgDiv.appendChild(resultImg);



}
function goResult(){
  qna.style.WebkitAnimation = "fadeOut 1s";
  qna.style.animation = "fadeOut 1s";

  setTimeout(() => {
    result.style.WebkitAnimation = "fadeIn 1s";
    result.style.animation = "fadeIn 1s";
    setTimeout(() => {
      qna.style.display = "none";
      result.style.display = "block"
    }, 100)})
   setResult();
  
 
}

function addAnswer(answerText,qIdx, idx){
    var a = document.querySelector('.answerBox');
    var answer = document.createElement('button');
  
    answer.classList.add('answerList');
    answer.classList.add('fadeIn');
    answer.classList.add('fadeOut');

    a.appendChild(answer);

    answer.innerHTML = answerText;
    answer.addEventListener('click', function(){
  
      var children = document.querySelectorAll('.answerList');

      for(let i = 0; i<children.length; i++){
        children[i].disabled = true;

        children[i].style.WebkitAnimation = "fadeOut 1s";
        children[i].style.animation = "fadeOut 1s";
       
      }
      setTimeout(() => {
        var target = randomArray[qIdx].a[idx].type;
    

        for(let i = 0; i < target.length; i++){
          select[target[i]] += 1;

        }
      
       
        for(let i = 0; i<children.length; i++){
          children[i].disabled = true;
            
          children[i].style.WebkitAnimation = "fadeOut 1s";
          children[i].style.animation = "fadeOut 1s";
        
          children[i].style.display = 'none';
       
          
        }
        goNext(++qIdx);
      },450)

    
   

    }, false);
}

function goNext(qIdx){
    if(qIdx === endPoint){
      goResult();
      return;
     
    }
    var q = document.querySelector('.question_p');
    q.innerHTML = randomArray[qIdx].q;
   
 for(let i in randomArray[qIdx].a){
      
        addAnswer(randomArray[qIdx].a[i].answer, qIdx,i);
     
    }
     var status = document.querySelector('.statusBar');
     

     

  
     status.style.width = (100/endPoint) * (qIdx+1) + '%';
     simul_count_num.innerHTML = "<span id='simul_count_num' style='color:rgb(211, 84, 0);font-size: 25px;'>"+(qIdx+1)+"</span>";
     
    
    
     
     
   
   }


function begin(){
    main.style.WebkitAnimation = "fadeOut 1s";
    main.style.animation = "fadeOut 1s";
    setTimeout(() => {
      qna.style.WebkitAnimation = "fadeIn 1s";
      qna.style.animation = "fadeIn 1s";
      setTimeout(() => {
        main.style.display = "none";
        qna.style.display = "block"
      }, 450)
      let qIdx = 0;
    
      goNext(qIdx);
    }, 450);
  }
  movieRightBtn.addEventListener('click',function(){

    

  });