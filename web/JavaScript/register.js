$(function () {//页面加载的操作处理
    //针对于userName或者是password输入的字段丢失焦点的事件处理
    $("#userName").on("blur", function () {
        validataUserName();
    });
    $("#password1").on("blur", function () {
        validataPassword();
    });
    $("#regForm").on("submit", function () {
        return validataUserName() && validataPassword() ;
    });
});

function validataUserName() {
    return validataEmpty("userName");
}

function validataPassword() {
    return validataEmpty("password1");
}

/*
* 本函数的只要功能是验证传入的数据是否为空，如果为空，则显示错误，同时显示错误信息
* 如果输入的内容为空，那么对于整个层的要求进行错误显示：has-error，通过has-success
* 在xxSpan中显示为空的错误信息
* eleId要判断的元素的ID编号
* */
function validataEmpty(eleId) {
    if ($("#" + eleId).val() === "") {//如果输入的内容为空
        $("#" + eleId + "Div").attr("class", "form-group has-error");
        $("#" + eleId + "Span").html("<span class='text-danger'>该字段内容不能为空!</span>");
        return false;
    }
    else {
        //内容不为空
        $("#" + eleId + "Div").attr("class", "form-group has-success");
        $("#" + eleId + "Span").html("<span class='text-success'>该字段内容合理!</span>");
        return true;
    }
}