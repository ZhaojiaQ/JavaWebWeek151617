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
import java.util.List;

@WebServlet("/listUser")
public class ListUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        List<User> userList;
        try {
            userList = userDao.getList();
            req.setAttribute("userList", userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("userList.jsp").forward(req, resp);
    }
}
