const main = document.querySelector(".main");
const qna = document.querySelector("#qna");
const simul_count_num = document.querySelector("#simul_count_num");

//★시뮬레이션 + 질문들 카운트 ★
const result = document.querySelector("#result");
1
const endPoint = 12;
//총 질문이 12개라서 프로그래서바의 총 값이 12로 endPoint변수설정.
const select = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
//사용자가 버튼을 선택했을때 어떤값을 눌렀는지 그 값을 배열에 추가해주는 용도.

function calResult(){
 

var result = select.indexOf(Math.max(...select));
//select배열의 최대값가지고 있는 index 반환
//...select  == 전개구문. select의 구문을 펼쳐줌 
return result;
}   

function setResult(){
let point = calResult();
//point변수에 calResult의 리턴값인 result값을 저장

const resultName = document.querySelector('.resultname');
resultName.innerHTML = infoList[point].name;
  //infoList의 point값의 name을 넣어줌 

  var resultImg = document.createElement('img');
  const imgDiv =  document.querySelector('.resultImg');
  var imgURL = 'img/image-' + point + '.png';
  resultImg.src = imgURL;
  resultImg.alt = point;
  resultImg.classList.add('img-fluid');
  imgDiv.appendChild(resultImg);

  const resultDesc = document.querySelector('.resultDesc');
  resultDesc.innerHTML = infoList[point].desc;

}
function goResult(){
  qna.style.WebkitAnimation = "fadeOut 1s";
  qna.style.animation = "fadeOut 1s";
  //qna세션이 꺼지고 result세션이 켜져야함 
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
    //answer 라는 변수에 버튼 생성 
    answer.classList.add('answerList');
    answer.classList.add('fadeIn');
    answer.classList.add('fadeOut');

    //answer라는 변수에 answerList라는 클래스를 생성해줌.
    a.appendChild(answer);
    //answer라는 변수가 a에 소속될수있게 만듬 
    //결국 div안에 버튼이 만들어진거임 
    answer.innerHTML = answerText;
    answer.addEventListener('click', function(){
      //answer(버튼)에 버튼이벤트를 연결.
      var children = document.querySelectorAll('.answerList');
      //children라는 클래스 리스트에 answerList라는 클래스복수값을 넣어줌.
      //이렇게 하면 버튼 3개가 동시에 선택됨 
      for(let i = 0; i<children.length; i++){
        children[i].disabled = true;
            //버튼을 돌면서 비활성화 시킴 
        children[i].style.WebkitAnimation = "fadeOut 1s";
        children[i].style.animation = "fadeOut 1s";
        //버튼을 돌면서 애니메이션 효ㅅ과.
      }
      setTimeout(() => {
        var target = randomArray[qIdx].a[idx].type;
        //qnaList에서 qIdx째 질문에 해당하는 a의 배열에서 선택한 질문(idx)의 type.

        for(let i = 0; i < target.length; i++){
          select[target[i]] += 1;
          //select배열에서 target의 i번째에 1을 증가시킴 
          //사용자가 선택한 슌서대로 12간지의 값이 1씩 증가함 
        }
      
       
        for(let i = 0; i<children.length; i++){
          children[i].disabled = true;
              //버튼을 돌면서 비활성화 시킴 
          children[i].style.WebkitAnimation = "fadeOut 1s";
          children[i].style.animation = "fadeOut 1s";
          //버튼을 돌면서 애니메이션 효ㅅ과.
          children[i].style.display = 'none';
           // 버튼들이 감춰짐 
          
        }
        goNext(++qIdx);
      },450)

    
      //반복문 끝날때 qIdx를 1증가하여 호출한다. 

    }, false);
}

function goNext(qIdx){
    if(qIdx === endPoint){
      goResult();
      return;
      //만약 인덱스값과 엔딩포인트의 값이 같으면 결과페이지로 이동 
    }
    var q = document.querySelector('.question_p');
    q.innerHTML = randomArray[qIdx].q;
    //qnalist에 인덱스값으로 0을 넣어서 q를 가져와서 뿌려줌 
 //인덱스값을 qIdx 변수로 할당 
 for(let i in randomArray[qIdx].a){
        //  let i는  qnaList에서 qIdx의 인덱스값에 a를 돌겠다 
        addAnswer(randomArray[qIdx].a[i].answer, qIdx,i);
      //addAnswer를 호출할때는 qnaList[qIdx]의 a의 i번째의 anwser를 가져와라. qIdx가져와라
      // 몇번째 버튼을 눌렀는지 확인하기 위해 i도 보내줌 
    }
     var status = document.querySelector('.statusBar');
     

     

     //프로그래스바 status변수 선언.
     status.style.width = (100/endPoint) * (qIdx+1) + '%';
     simul_count_num.innerHTML = "<span id='simul_count_num' style='color:rgb(211, 84, 0);font-size: 25px;'>"+(qIdx+1)+"</span>";
     
    
     //프로그래스바의 상태가 총질문갯수를 100으로나누고 질문인덱스값에 +1해주고 % 붙임 
     
     
   
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
      //인덱스값을 변수로 할당 qIdx
      goNext(qIdx);
    }, 450);
  }