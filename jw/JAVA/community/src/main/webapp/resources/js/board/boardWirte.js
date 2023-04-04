const input_img_btn = document.getElementById('input_img_btn');

const input = document.getElementById('input_img');

input_img_btn.addEventListener('click', function () {
    input.click();
});


const div = document.getElementById('input_div');

// input 요소에 change 이벤트 핸들러 등록
input.addEventListener('change', () => {
// 선택한 파일 가져오기
const file = input.files[0];

// FileReader 객체 생성
const reader = new FileReader();

// 파일 로드 이벤트 핸들러 등록
reader.addEventListener('load', () => {
    // 이미지 요소 생성
    const image = new Image();
    image.src = reader.result;

    // 이미지 파일 추가
    div.appendChild(image);
});

// 파일을 Data URL로 읽기
reader.readAsDataURL(file);
});

div.addEventListener("input", () => {
    if(div.innerText == ""){
        document.getElementById("placeholder_div").innerText = "여기에 내용을 입력해 주세요.";
    } else{
        document.getElementById("placeholder_div").innerText = "";
    }
})
