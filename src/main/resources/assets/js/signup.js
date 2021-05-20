let inputPassword;
let inputPasswordRepeat;
let major;
let minor;
let number;
let special;
let messageText;

onload = function () {
    inputPassword = document.getElementsByName('password')[0];
    inputPasswordRepeat = document.getElementsByName('passwordRepeat')[0];
    length = document.querySelector('.inputs div p .length-8');
    major = document.querySelector('.inputs div p .major');
    minor = document.querySelector('.inputs div p .minor');
    number = document.querySelector('.inputs div p .number');
    special = document.querySelector('.inputs div p .special')
};

function onPasswordChanged() {
    const password = inputPassword.value;
    if(password) {
        let regexWeak = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/m;
        let regexMedium = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/m;
        let regexStrong = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/m;
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

        password.length >= 8        ? length.style.color    = 'green'   : length.style.color  = 'red';
        string.match(/[a-z]/m)      ? minor.style.color     = 'green'   : minor.style.color   = 'red';
        string.match(/[A-Z]/m)      ? major.style.color     = 'green'   : major.style.color   = 'red';
        string.match(/[0-9]/m)      ? number.style.color    = 'green'   : number.style.color  = 'red';
        string.match(/[@$!%*?&]/m)  ? special.style.color   = 'green'   : special.style.color = 'red';
    }
}


function onPasswordRepeatChanged() {
    const passwordRepeat = inputPasswordRepeat.value;
    const password = inputPassword.value;
            if (password === passwordRepeat) {
                inputPasswordRepeat.style.border = '2px solid green';
            } else {
                inputPasswordRepeat.style.border = '2px solid red';
            }
}
