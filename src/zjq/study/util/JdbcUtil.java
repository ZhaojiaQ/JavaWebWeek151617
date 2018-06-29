package zjq.study.util;

import java.sql.*;
import java.util.List;

public class JdbcUtil {
    private static String Driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/zjq?characterEncoding=utf8&useSSL=true";
    private static String user = "debian-sys-maint";
    private static String password = "mPIvHaRvRqW1WxnX";

    public static Connection getConnection() throws Exception {
        Class.forName(Driver);
        return DriverManager.getConnection(url, user, password);
    }

    public static ResultSet executeQuery(String sql, List<Object> list) throws Exception {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        if (list != null && list.size() > 0) {
            JdbcUtil.bindParams(pst, list);
        }
        return pst.executeQuery();
    }

    public static int executeUpdate(String sql, List<Object> list) throws Exception {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        if (list != null && list.size() > 0) {
            JdbcUtil.bindParams(pst, list);
        }
        int result = pst.executeUpdate();
        JdbcUtil.close(null, null, pst, connection);
        return result;
    }

    private static void bindParams(PreparedStatement preparedStatement, List<Object> list) {
        for (int i = 0; i < list.size(); i++) {
            try {
                preparedStatement.setObject(i + 1, list.get(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, PreparedStatement pst, Connection con) throws Exception {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (pst != null) pst.close();
        if (con != null) con.close();
    }
}