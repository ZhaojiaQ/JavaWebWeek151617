package zjq.study.servlet;

import zjq.study.dao.UserDao;
import zjq.study.dao.impl.UserDaoImpl;
import zjq.study.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCheckServlet")
public class LoginCheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        UserDao userDao = new UserDaoImpl();
        try {
            User user = userDao.select(userName, password);
            if (user != null) {
                String abc;
                if (user.getUserName().equals("zjq"))
                    abc = "是帅的";
                else
                    abc = "是丑的";
                req.setAttribute("abc", abc);
                req.setAttribute("userName", userName);
                req.getRequestDispatcher("getStudentEchart").forward(req, resp);
            } else
                resp.sendRedirect("login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
