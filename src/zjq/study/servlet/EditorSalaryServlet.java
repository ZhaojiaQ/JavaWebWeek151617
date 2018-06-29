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
@WebServlet("/editorSalary")
public class EditorSalaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SalaryDao salaryDao = new SalaryDaoImpl();
        if (id != null && id.length() > 0) {
            try {
                Salary salary = salaryDao.getOne(Integer.valueOf(id));
                request.setAttribute("salary", salary);
            } catch (Exception e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
