<%--
  Created by IntelliJ IDEA.
  User: zjq
  Date: 18-6-20
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>看看薪水</title>
</head>
<body>
<h1 align="center">薪水列表</h1>
<table border="1" cellpadding="0" cellspacing="0" width="1200" align="center">
    <tr align="center">
        <th>序号</th>
        <th>ID</th>
        <th>员工编号</th>
        <th>月份</th>
        <th>基本工资</th>
        <th>奖金收入</th>
        <th>排序值</th>
        <th>操作</th>

    </tr>
    <c:forEach var="salary" items="${salaryList}" varStatus="vs">
        <tr align="center">
            <td>${vs.count}</td>
            <td>${salary.id}</td>
            <td>${salary.e_id}</td>
            <td>${salary.month}</td>
            <td>${salary.basic}</td>
            <td>${salary.more}</td>
            <td>${salary.order_value}</td>
            <td><a href="editorSalary?id=${salary.id}">修改</a>&emsp;
                <a href="deleteSalary?id=${salary.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<div align="center">
    <input type="button" onclick="location.href='add.jsp'" value="添加">
</div>

</body>
</html>
