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

        let hasLength       = password.length >= 8;
        let hasLowerCase    = password.match(/[a-z]/m);
        let hasUpperCase    = password.match(/[A-Z]/m);
        let hasNumber       = password.match(/[0-9]/m);
        let hasSpecial      = password.match(/[@$!%*?&]/m);


        if (hasLength && hasLowerCase && hasUpperCase && hasNumber && hasSpecial) {
            inputPassword.style.border = '2px solid green';
        } else if (hasLowerCase && hasUpperCase && hasNumber && hasSpecial) {
            inputPassword.style.border = '2px solid yellow';
        } else if (hasLowerCase && hasUpperCase) {
            inputPassword.style.border = '2px solid orange';
        } else {
            inputPassword.style.border = '2px solid red';
        }

        hasLength       ? length.style.color    = 'green'   : length.style.color  = 'red';
        hasLowerCase    ? minor.style.color     = 'green'   : minor.style.color   = 'red';
        hasUpperCase    ? major.style.color     = 'green'   : major.style.color   = 'red';
        hasNumber       ? number.style.color    = 'green'   : number.style.color  = 'red';
        hasSpecial      ? special.style.color   = 'green'   : special.style.color = 'red';
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
