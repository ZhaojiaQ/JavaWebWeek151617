<%--
  Created by IntelliJ IDEA.
  User: zjq
  Date: 18-6-21
  Time: 上午10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>
<form action="addServlet" method="get">
    员工编号： <input type="text" name="e_id" size="20"/><br/>
    月份：
    <select name="month">
        <c:forEach var="i" begin="1" end="12" step="1">
            <option value="${i}">${i}月</option>
        </c:forEach>
    </select>
    <br/>
    基本工资：<input type="text" name="basic" id="basic" size="20"><br/>
    奖金：<input type="text" name="more" id="more" size="20"><br/>
    排序值：<input type="text" name="order_value" id="order_value" size="20"><br/>
    <button type="submit" value="添加">添加</button>&emsp;<button type="reset" value="重置">重置</button>
</form>
</body>
</html>
