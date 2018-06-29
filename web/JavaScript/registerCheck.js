function $(id) {//获取指定id的html页面元素对象
    return document.getElementById(id);
}

function checkName() {
    var name = $("userName").value;
    var name_prompt = $("userNameSpan");
    var nameReg = /^[a-zA-Z][a-zA-Z0-9]{2,15}$/;
    if (!nameReg.test(name)) {
        name_prompt.innerHTML = "错误，英文字母和数字组成的3-16位字符，以字母开头";
        return false;
    }
    name_prompt.innerHTML = "格式正确";
    return true;
}

function checkPwd() {
    var pwd = $("password1").value;
    var pwd_prompt = $("password1Span");
    var pwdReg = /^[a-zA-Z0-9]{3,9}$/;
    if (!pwdReg.test(pwd)) {
        pwd_prompt.innerHTML = "错误，由英文字母和数字组成的4—10位字符";
        return false;
    }
    pwd_prompt.innerHTML = "格式正确";
    return true;
}

function checkConfirmPwd() {
    var confirmPwd = $("password2").value;
    var pwd = $("password1").value;
    var confirmPwd_prompt = $("password2Span");
    if (pwd !== confirmPwd) {
        confirmPwd_prompt.innerHTML = "错误，两次输入的密码不一致";
        return false;
    }
    confirmPwd_prompt.innerHTML = "密码正确";
    return true;
}

function check() {
    if (checkName() && checkPwd() && checkConfirmPwd()) {
        return true;
    }
    return false;
}