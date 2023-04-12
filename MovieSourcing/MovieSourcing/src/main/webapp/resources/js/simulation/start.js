const main = document.querySelector(".main");
const qna = document.querySelector("#qna");
const simul_count_num = document.querySelector("#simul_count_num");
const movieRightBtn = document.querySelector(".movie_recommend_right_btn");




const result = document.querySelector("#result");

const endPoint = 12;

const select = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0 , 0 , 0];
var jsonGenre = JSON.stringify(select);
function calResult(){
 
  let copySelect = select.slice();
  //배열복사해서 copySelect에 저장 
    let top3 = [];
    //3순위까지 배열로 넣을 배열선언 

    for(let i=0; i<3; i++){
      let maxIndex = copySelect.indexOf(Math.max(...copySelect));
      top3.push({index: maxIndex, value: copySelect[maxIndex]});
      
      copySelect[maxIndex] = -1; // 이미 처리한 값을 -1로 변경하여 중복 선택을 방지합니다.
      //많은 선택을 받은 아이를 찾아서 저장하는 회전을 3번반복하면서 3순위까지 찾음 
      
 
  }

  return top3
  
//찾은걸 리턴 





} 





function setResult() {
  let top3 = calResult();
  let imgDiv = document.querySelector('.resultImg');


  for (let i = 0; i < top3.length; i++) {
    let index = top3[i].index;
    let value = top3[i].value;
//3순위 찾은걸 돌리면서 출력할 내용 지정해서 출력해줌
    let resultText = document.createElement('div');
    resultText.innerHTML = `${i+1}위: 선택 횟수 ${value}, 인덱스 ${index}`;
     ajaxt(value, index);
    imgDiv.appendChild(resultText);
	let graphElement = document.getElementById(`graph-${index}`);//id부여한 인덱스 그래
    let graphContainer = document.createElement('div');
    graphContainer.classList.add('graph-container');
    graphContainer.id = `graph-${index}`; // 인덱스에 따른 고유한 id 부여
    let canvas = document.createElement('canvas');
    canvas.width = 60;
    canvas.height = 40;
    graphContainer.appendChild(canvas);
    imgDiv.appendChild(graphContainer);
//막대그래프 생성 
    let ctx = canvas.getContext('2d');
    ctx.fillStyle = 'green';
    ctx.fillRect(0, 0, value * 6, 40);
//막대그래프 사이즈와 디자인 
    let percentText = document.createElement('div');
    percentText.innerHTML = `${value*10}%`;
    percentText.style.display = 'inline-block';
    percentText.style.marginLeft = '10px';
    percentText.style.fontSize = '20px';
    graphContainer.appendChild(percentText);
    resultText.style.color = 'white';
    percentText.style.color = 'white';
    //퍼센테이지 화면에 뿌림
    
    
    
    

  }
  
//  ajaxSelect();

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
  movieRightBtn.addEventListener('click',function(){

//결과값이 같은 장르의 영화이미지를 가져와 랜덤으로 뿌려주면서 슬라이드로 보여줌 는 아직 못함
//실제로는 sql로 조인해서 가져와야하는건데 그걸 임의로 어떻게 구현.....할까요?
  
    

  });
  
  
  

     
  function ajaxSelect(){
      

      $.ajax({
	
	
  type: "GET",
  url: "simulProcess", // 서블릿 주소
  data: { select: select }, // select 배열값을 data로 넘겨줍니다.
  success: function(response) {
    // 서블릿에서 처리한 결과를 받아서 처리합니다.
    console.log(response);
  },
  error: function(xhr, status, error) {
    // 오류 처리
    console.log(xhr.responseText);
  }
});





}




function ajaxt(value, index) {
	
	
	$.ajax({
  type: 'POST',
  url: 'proseeServlet',
  data: { index: index, value: value },
  success: function(response) {
    console.log(response);
  },
  error: function(xhr, status, error) {
    console.log(error);
  }
});
 
}



let graphElement1 = document.getElementById(`graph-${1}`);

graphElement1.addEventListener('click', function() {
	
	
	