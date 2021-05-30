function handleProfileStatistics() {
  console.log("function läuft");
  let coll = document.getElementsByClassName("collapsible");
  let i;

  for (i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click", function () {
      this.classList.toggle("active");
      //   let content = this.nextElementSibling;
      let content = document.getElementsByClassName("collapsible_content");
      if (content.style.display === "block") {
        content.style.display = "none";
        console.log("disolay none");
      } else {
        content.style.display = "block";
        console.log("disolay block");
      }
    });
  }
}
