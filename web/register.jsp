<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <script type="text/javascript" src="JavaScript/jquery-3.3.1.min.js"></script>
    <script type="text/css" src="bootstrap-3.3.7/css/bootstrap.min.css"></script>
    <script type="text/javascript" src="JavaScript/registerCheck.js"></script>
    <link href="bootstrap-3.3.7/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <title>用户注册</title>
</head>
<body>
<div class="container">
    <form action="registerServlet" id="regForm" name="regForm" method="post" class="form-horizontal"
          onsubmit="return check()">
        <fieldset>
            <legend><span class="glyphicon glyphicon-user"></span>&nbsp;用户注册</legend>
            <div class="form-group" id="userNameDiv">
                <label class="col-md-3 control-label" for="userName">用户名：</label>
                <div class="col-md-5">
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入你的用户名"
                           onblur="checkName()">
                </div>
                <div class="col-md-4" id="userNameSpan"></div>
            </div>

            <div class="form-group" id="password1Div">
                <label class="col-md-3 control-label" for="password1">密码：</label>
                <div class="col-md-5">
                    <input type="password" class="form-control" id="password1" name="password1" placeholder="请输入你的密码"
                           onblur="checkPwd()">
                </div>
                <div class="col-md-4" id="password1Span"></div>
            </div>

            <div class="form-group" id="password2Div">
                <label class="col-md-3 control-label" for="password2">确认密码：</label>
                <div class="col-md-5">
                    <input type="password" class="form-control" id="password2" name="password2" placeholder="请确认你的密码"
                           onblur="checkConfirmPwd()">
                </div>
                <div class="col-md-4" id="password2Span"></div>
            </div>

            <div class="form-group" id="butDiv">
                <div class="col-md-5 col-md-offset-3">
                    <button type="submit" id="subBut" class="btn btn-xs btn-primary">注册</button>
                    <button type="reset" id="rstBut" class="btn btn-xs btn-warning">重置</button>
                </div>
            </div>
        </fieldset>
    </form>
    <a href="login.jsp" >
        <button type="submit" id="logBut" class="btn btn-xs btn-primary">已有账号，登录</button>
    </a>
</div>
</body>
</html>