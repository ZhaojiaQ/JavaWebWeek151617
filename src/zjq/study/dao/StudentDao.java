package zjq.study.dao;

import zjq.study.entity.Student;
import zjq.study.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public List<Student> getList() throws Exception {
        List<Student> studentList = new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        String sql = "select * from student";
        PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet resultSet = pst.executeQuery();
        while (resultSet != null && resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setGender(resultSet.getString("gender"));
            student.setAge(resultSet.getInt("age"));
            student.setScore(resultSet.getInt("score"));
            studentList.add(student);
        }
        JdbcUtil.close(resultSet, null, pst, connection);
        return studentList;
    }
}
