
function ValidateUser(email, username, password1, password2) {
    if (ValidateEmail(email)) {
        if (ValidateUsername(username)) {
            if (MatchPasswords(password1, password2)) {
                if (ValidatePassword(password1)) {
                    alert("Registered Successfully!");
                }

            }
        }

    }
}

function ValidateEmail(inputText) {
    var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

    if (inputText.match(mailformat)) {
        return true;
    }
    else {
        alert("You have entered an invalid email address!");
        document.emailinput.focus();
        return false;
    }
}

function ValidateUsername(inputText) {
    if (inputText == "") {
        alert("Enter a username");
        document.usernameinput.focus();
        return false;
    }
    else {
        return true;
    }
}

function ValidatePassword(inputText) {
    if (inputText == "") {
        alert("Enter a password");
        document.passwordinput1.focus();
        return false;
    }
    if (inputText.length < 6) {
        alert("Password must be at least 6 characters in length");
        document.passwordinput1.focus();
        return false;
    }
    if (inputText.length > 25) {
        alert("Password must not be more than 25 characters in length");
        document.passwordinput1.focus();
        return false;
    }
    else {
        return true;
    }
}

function MatchPasswords(pw1, pw2) {
    if (pw1 != pw2) {
        alert("Passwords do not match")
        return false;
    } else {
        return true;
    }
}

// Script to hide/show admin password input if toggle switch is activated
var form = $('#registerForm'),
    checkbox = $('#admincheckbox'),
    chInputs = $('#admininputs');

chInputs.hide();

checkbox.on('click', function () {
    if ($(this).is(':checked')) {
        chInputs.show();
        chInputs.find('input').attr('required', true);
    } else {
        chInputs.hide();
        chInputs.find('input').attr('required', false);
    }
})