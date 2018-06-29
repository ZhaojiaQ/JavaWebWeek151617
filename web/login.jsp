<%--
  Created by IntelliJ IDEA.
  User: zjq
  Date: 18-4-23
  Time: 上午12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>


<html>
<head>
    <title>要登录的</title>
    <meta charset="UTF-8">
    <%--使用bootstrap必要标签--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="JavaScript/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="JavaScript/login.js"></script>
    <link href="bootstrap-3.3.7/css/bootstrap.min.css" type="text/css" rel="stylesheet">

</head>
<body>
<div class="container">

    <form action="loginCheckServlet" id="loginForm" method="post" class="form-horizontal">
        <fieldset>
            <legend><label><span class="glyphicon glyphicon-user"></span>&nbsp;用户登录</label></legend>
            <div class="form-group" id="userNameDiv">
                <label class="col-md-3 control-label" for="userName">用户名：</label>
                <div class="col-md-5">
                    <input type="text" id="userName" class="form-control" name="userName" placeholder="请输入用户名">
                </div>
                <div class="col-md-4" id="userNameSpan"></div>
            </div>
            <%--id是为Javas服务的，而name是为了jsp接受数据服务的--%>
            <div class="form-group" id="passwordDiv">
                <label class="col-md-3 control-label" for="password">密码：</label>
                <div class="col-md-5">
                    <input type="password" id="password" name="password" class="form-control" placeholder="请输入登录密码">
                </div>
                <div class="col-md-4" id="passwordSpan"></div>
            </div>

            <div class="form-group" id="butDiv">
                <div class="col-md-5 col-md-offset-3">
                    <button type="submit" id="subBut" class="btn btn-xs btn-primary">登录</button>
                    <a href="register.jsp">
                        <button type="button" id="regBut" class="btn btn-xs btn-primary">注册</button>
                    </a>
                    <button type="reset" id="rstBut" class="btn btn-xs btn-warning">重置</button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>
