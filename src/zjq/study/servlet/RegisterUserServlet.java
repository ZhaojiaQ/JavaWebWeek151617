package zjq.study.servlet;

import zjq.study.dao.UserDao;
import zjq.study.dao.impl.UserDaoImpl;
import zjq.study.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password2 = req.getParameter("password2");
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password2);
        try {
            int rs = userDao.insert(user);
            if (rs > 0) {
                req.getRequestDispatcher("listUser").forward(req, resp);
            } else
                resp.sendRedirect("register.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
