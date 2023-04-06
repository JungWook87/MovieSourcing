console.log("boardDetail js loaded")

const dotImg = document.getElementById("communityDotImg");
const popup_menu = document.getElementById("popup_menu");

dotImg.addEventListener("click", () => {

    if(popup_menu.style.display === 'flex'){
        popup_menu.style.display='none';
    } else{
        popup_menu.style.display='flex';
    }
});
