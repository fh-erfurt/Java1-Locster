let inputPassword;
let inputPasswordRepeat;
let messageText;

onload = function (event) {
    inputPassword = document.getElementsByName('password')[0];
    inputPasswordRepeat = document.getElementsByName('passwordRepeat')[0];
};

function onPasswordChanged() {
    const password = inputPassword.value;
    if(password) {
        var regexWeak = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/m;
        var regexMedium = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/m;
        var regexStrong = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/m;
        let string = password;

        if (string.match(regexStrong)) {
            inputPassword.style.border = '2px solid green';
        } else if (string.match(regexMedium)) {
            inputPassword.style.border = '2px solid yellow';
        } else if (string.match(regexWeak)) {
            inputPassword.style.border = '2px solid orange';
        } else {
            inputPassword.style.border = '2px solid red';
        }
    }
};


function onPasswordRepeatChanged() {
    const passwordRepeat = inputPasswordRepeat.value;
    const password = inputPassword.value;
            if (password === passwordRepeat) {
                inputPasswordRepeat.style.border = '2px solid green';
            } else {
                inputPasswordRepeat.style.border = '2px solid red';
            }
};