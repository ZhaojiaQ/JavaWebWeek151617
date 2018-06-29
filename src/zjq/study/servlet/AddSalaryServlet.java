package zjq.study.servlet;

import zjq.study.dao.SalaryDao;
import zjq.study.dao.impl.SalaryDaoImpl;
import zjq.study.entity.Salary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addServlet")
public class AddSalaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String e_id = request.getParameter("e_id");
        String month = request.getParameter("month");
        String basic = request.getParameter("basic");
        String more = request.getParameter("more");
        String order_value = request.getParameter("order_value");

        Salary salary = new Salary();
        salary.setE_id(Integer.valueOf(e_id));
        salary.setMonth(Integer.valueOf(month));
        salary.setBasic(Integer.valueOf(basic));
        salary.setMore(Integer.valueOf(more));
        salary.setOrder_value(Integer.valueOf(order_value));

        SalaryDao salaryDao = new SalaryDaoImpl();
        try {
            salaryDao.insert(salary);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("listSalary");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
