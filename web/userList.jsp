<%--
  Created by IntelliJ IDEA.
  User: zjq
  Date: 18-6-29
  Time: 上午8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>看看用户</title>
</head>
<body>
<h1 align="center">用户列表</h1>
<table border="1" cellpadding="0" cellspacing="0" width="1200" align="center">
    <tr align="center">
        <th>序号</th>
        <th>ID</th>
        <th>用户姓名</th>
        <th>用户密码</th>
        <th>操作</th>
    </tr>
    <c:forEach var="userList" items="${userList}" varStatus="vs">
        <tr align="center">
            <td>${vs.count}</td>
            <td>${userList.id}</td>
            <td>${userList.userName}</td>
            <td>${userList.password}</td>
            <td><a href="editorSalary?id=${userList.id}">修改</a>&emsp;
                <a href="deleteSalary?id=${userList.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
</body>
</html>
