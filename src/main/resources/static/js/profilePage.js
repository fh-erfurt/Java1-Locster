var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function () {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.display === "block") {
      content.style.display = "none";
    } else {
      content.style.display = "block";
    }
  });
}

function displayprofileEdit() {
  document.getElementById("status").style.display = "none";
  document.getElementById("profiltextEdit").style.display = "block";
}

function displayprofileInfo() {
  document.getElementById("status").style.display = "flex";
  document.getElementById("profiltextEdit").style.display = "none";
}
