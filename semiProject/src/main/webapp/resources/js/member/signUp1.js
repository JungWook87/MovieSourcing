
const checkAll = document.getElementById("checkAll");
const check1 = document.getElementById("check1");
const check2 = document.getElementById("check2");
const check3 = document.getElementById("check3");
const check4 = document.getElementById("check4");

checkAll.addEventListener("change", function() {

  if (checkAll.checked) {
    check1.checked = true;
    check2.checked = true;
    check3.checked = true;
    check4.checked = true;
  } else { 
    check1.checked = false;
    check2.checked = false;
    check3.checked = false;
    check4.checked = false;
  }
});


const nextButton = document.querySelector(".nextbox button");
nextButton.addEventListener("click", function(event) {
 
  if (!check1.checked || !check2.checked || !check3.checked) {
    event.preventDefault(); 
    alert("필수 약관에 모두 동의해주세요.");
  }
});