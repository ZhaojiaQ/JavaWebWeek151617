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

@WebServlet("/getEchartDataServlet")
public class GetEchartDateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer basic = new StringBuffer("[");
        StringBuffer more = new StringBuffer("[");
        StringBuffer month = new StringBuffer("[");
        SalaryDao salaryDao = new SalaryDaoImpl();
        try {
            List<Salary> salaryList = salaryDao.getList();
            for (Salary aSalaryList : salaryList) {
                basic.append(aSalaryList.getBasic()).append(",");
                more.append(aSalaryList.getMore()).append(",");
                month.append(aSalaryList.getMonth()).append("月").append(",");
            }
            basic.append(salaryList.get(salaryList.size() - 1).getBasic()).append("]");
            more.append(salaryList.get(salaryList.size() - 1).getMore()).append("]");
            month.append(salaryList.get(salaryList.size() - 1).getMonth()).append("月").append("]");
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("month", month);
        req.setAttribute("basic", basic);
        req.setAttribute("more", more);
        req.getRequestDispatcher("echarts.jsp").forward(req, resp);
    }
}
