package zjq.study.servlet;

import zjq.study.dao.SalaryDao;
import zjq.study.dao.impl.SalaryDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteSalary")
public class DeleteSalaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SalaryDao salaryDao = new SalaryDaoImpl();
        if (id != null && id.length() > 0) {
            try {
                salaryDao.delete(Integer.valueOf(id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("listSalary");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
