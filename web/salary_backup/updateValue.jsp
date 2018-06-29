<%@ page import="zjq.study.entity.Salary" %>
<%@ page import="zjq.study.dao.SalaryDao" %>
<%@ page import="zjq.study.dao.impl.SalaryDaoImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: zjq
  Date: 18-6-21
  Time: 上午10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    String e_id = request.getParameter("e_id");
    String month = request.getParameter("month");
    String basic = request.getParameter("basic");
    String more = request.getParameter("more");
    String order_value = request.getParameter("order_value");

    Salary salary = new Salary();
    salary.setId(Integer.valueOf(id));
    salary.setE_id(Integer.valueOf(e_id));
    salary.setMonth(Integer.valueOf(month));
    salary.setBasic(Integer.valueOf(basic));
    salary.setMore(Integer.valueOf(more));
    salary.setOrder_value(Integer.valueOf(order_value));

    SalaryDao salaryDao = new SalaryDaoImpl();
    try {
        salaryDao.update(salary);
    } catch (Exception e) {
        e.printStackTrace();
    }

    response.sendRedirect("ListSalary");
%>
</body>
</html>
