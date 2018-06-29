package zjq.study.dao.impl;

import zjq.study.dao.UserDao;
import zjq.study.entity.User;
import zjq.study.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends UserDao {
    @Override
    public User select(String userName, String password) throws Exception {
        User user = new User();
        List<Object> list = new ArrayList<>();
        list.add(userName);
        list.add(password);
        String sql = "select * from user where username = ? and password = ?";
        ResultSet resultSet = JdbcUtil.executeQuery(sql, list);
        while (resultSet != null && resultSet.next()) {
            user.setUserName(resultSet.getString("userName"));
            user.setPassword(resultSet.getString("password"));
        }
        JdbcUtil.close(resultSet, null, null, null);
        return user;
    }

    @Override
    public int insert(User user) throws Exception {
        String sql = "insert  into  user(username, password) values (?,?)";
        List<Object> list = new ArrayList<>();
        list.add(user.getUserName());
        list.add(user.getPassword());
        return JdbcUtil.executeUpdate(sql, list);
    }

    @Override
    public int update(User user) throws Exception {
        return super.update(user);
    }

    @Override
    public int delete(int id) throws Exception {
        Connection connection = JdbcUtil.getConnection();
        String sql = "delete from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int rs = preparedStatement.executeUpdate();
        JdbcUtil.close(null, null, preparedStatement, connection);
        return rs;
    }

    @Override
    public User getOne(int id) throws Exception {
        return super.getOne(id);
    }

    @Override
    public List<User> getList() throws Exception {
        List<User> userList = new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        String sql = "select * from user";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet resultSet = pst.executeQuery();
        while (resultSet != null && resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            userList.add(user);
        }
        JdbcUtil.close(resultSet, null, pst, connection);
        return userList;
    }
}
