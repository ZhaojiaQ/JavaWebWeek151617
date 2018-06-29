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
import java.util.List;

/**
 * @author zjq
 * @date 18-6-21
 * @time 上午9:35
 */
@WebServlet("/listSalary")
public class ListSalaryServlet extends HttpServlet {

    public ListSalaryServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SalaryDao salaryDao = new SalaryDaoImpl();
        List<Salary> salaryList;
        try {
            salaryList = salaryDao.getList();
            //salaryList.forEach(x -> System.out.println(x));
            req.setAttribute("salaryList", salaryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
