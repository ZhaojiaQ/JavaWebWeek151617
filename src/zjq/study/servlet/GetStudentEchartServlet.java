package zjq.study.servlet;

import zjq.study.dao.StudentDao;
import zjq.study.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getStudentEchart")
public class GetStudentEchartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao studentDao = new StudentDao();
        StringBuffer name = new StringBuffer("['");
        StringBuffer age = new StringBuffer("[");
        StringBuffer score = new StringBuffer("[");
        try {
            List<Student> studentList = studentDao.getList();
            for (int i = 0; i < studentList.size() - 1; i++) {
                name.append(studentList.get(i).getName()).append("','");
                age.append(studentList.get(i).getAge()).append(",");
                score.append(studentList.get(i).getScore()).append(",");
            }
            name.append(studentList.get(studentList.size() - 1).getName()).append("']");
            age.append(studentList.get(studentList.size() - 1).getAge()).append("]");
            score.append(studentList.get(studentList.size() - 1).getScore()).append("]");

            /*System.out.println(name.toString());
            System.out.println(age.toString());
            System.out.println(score.toString());*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("name", name);
        req.setAttribute("age", age);
        req.setAttribute("score", score);
        req.getRequestDispatcher("echarts2.jsp").forward(req, resp);
    }
}