package zjq.study.dao.impl;

import zjq.study.dao.SalaryDao;
import zjq.study.entity.Salary;
import zjq.study.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zjq
 * @date 18-6-21
 * @time 上午9:37
 */
public class SalaryDaoImpl extends SalaryDao {

    @Override
    public int delete(int id) throws Exception {
        Connection con = JdbcUtil.getConnection();
        Statement stmt = con.createStatement();
        String sql = "delete from salary where id=" + id;
        int rs = stmt.executeUpdate(sql);
        JdbcUtil.close(null, stmt, null, con);
        return rs;
    }

    @Override
    public int insert(Salary salary) throws Exception {
        Connection con = JdbcUtil.getConnection();
        String sql = "insert into salary(e_id,month, basic, more, order_value) values(?,?,?,?,?) ";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setInt(1, salary.getE_id());
        psmt.setInt(2, salary.getMonth());
        psmt.setInt(3, salary.getBasic());
        psmt.setInt(4, salary.getMore());
        psmt.setInt(5, salary.getOrder_value());
        int rs = psmt.executeUpdate();
        JdbcUtil.close(null, null, psmt, con);
        return rs;
    }

    @Override
    public int update(Salary salary) throws Exception {
        Connection con = JdbcUtil.getConnection();
        String sql = "update salary set e_id=?,month=?,basic=?,more=?,order_value=? where id=?";
        PreparedStatement psst = con.prepareStatement(sql);
        psst.setInt(1, salary.getE_id());
        psst.setInt(2, salary.getMonth());
        psst.setInt(3, salary.getBasic());
        psst.setInt(4, salary.getMore());
        psst.setInt(5, salary.getOrder_value());
        psst.setInt(6, salary.getId());
        int rs = psst.executeUpdate();
        JdbcUtil.close(null, null, psst, con);
        return rs;
    }

    @Override
    public Salary getOne(int id) throws Exception {
        Salary salary = new Salary();
        Connection con = JdbcUtil.getConnection();
        Statement stmt = con.createStatement();
        String sql = "select * from salary where id = " + id;
        ResultSet rs = stmt.executeQuery(sql);
        while (rs != null && rs.next()) {
            salary.setId(rs.getInt("id"));
            salary.setE_id(rs.getInt("e_id"));
            salary.setMonth(rs.getInt("month"));
            salary.setBasic(rs.getInt("basic"));
            salary.setMore(rs.getInt("more"));
            salary.setOrder_value(rs.getInt("Order_value"));
        }
        JdbcUtil.close(rs, stmt, null, con);
        return salary;
    }

    @Override
    public List<Salary> getList() throws Exception {
        List<Salary> salaryList = new ArrayList<>();
        Connection con = JdbcUtil.getConnection();
        Statement stmt = con.createStatement();
        String sql = "select * from salary";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs != null && rs.next()) {
            Salary salary = new Salary();
            salary.setId(rs.getInt("id"));
            salary.setE_id(rs.getInt("e_id"));
            salary.setMonth(rs.getInt("month"));
            salary.setBasic(rs.getInt("basic"));
            salary.setMore(rs.getInt("more"));
            salary.setOrder_value(rs.getInt("Order_value"));
            salaryList.add(salary);
        }
        JdbcUtil.close(rs, stmt, null, con);
        return salaryList;
    }
}
