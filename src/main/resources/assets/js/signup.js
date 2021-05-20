let input;
let messageText;

onload = function (event) {
    input = document.getElementsByName('password')[0];
};

function onPWChanged() {
    const password = input.value;
    console.log(password);
};