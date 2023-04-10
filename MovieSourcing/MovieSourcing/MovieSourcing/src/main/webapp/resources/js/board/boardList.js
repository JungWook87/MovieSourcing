
const com_cont = document.getElementsByClassName("com_cont");

for(let i = 0; i < 10; i++){
    com_cont[i].addEventListener("click", () => {
        com_cont[i].firstElementChild.click();
    })
    
    if(com_cont[i].getElementsByTagName("a")[0].getElementsByTagName("img")[0] != null){
        const img = com_cont[i].getElementsByTagName("a")[0].getElementsByTagName("img")[0].getAttribute("src");
        const com_thunmnail = document.getElementsByClassName("com_thunmnail");
        com_thunmnail[i].getElementsByTagName("img")[0].setAttribute("src", img);
    }

}



