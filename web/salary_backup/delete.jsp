<%@ page import="zjq.study.dao.SalaryDao" %>
<%@ page import="zjq.study.dao.impl.SalaryDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: zjq
  Date: 18-6-22
  Time: 上午9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除页面</title>
</head>
<%
    String id = request.getParameter("id");
    SalaryDao salaryDao = new SalaryDaoImpl();
    if (id != null && id.length() > 0) {
        try {
            salaryDao.delete(Integer.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    response.sendRedirect("salary");
%>
<body>

</body>
</html>
