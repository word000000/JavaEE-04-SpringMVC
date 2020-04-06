package com.example.spring.mvc.jdbc;

import com.example.spring.mvc.bean.Student;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:GQM
 * @Date:created in 22:15 2020/3/7
 * @Description:
 * @Modifyed_By:
 */
public class StudentJdbc {
    private  static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static List<Student> selectAllStudent() throws ClassNotFoundException {
        String sqlString = "select * from student ";
        List<Student>list=new ArrayList<>();
        try (Connection connection = context.getBean("dataSourceHikari", HikariDataSource.class).getConnection()) {
            //通过连接获取statement
            try (Statement statement = connection.createStatement()) {
                //statement （增、删、改、查）
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        Student student = (Student) context.getBean("student");
                        student.setStudentId(resultSet.getLong("student_id"));
                        student.setStudentName(resultSet.getString("student_name"));
                        list.add(student);
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean addStudent(Student newStudent) throws ClassNotFoundException {

        List<Student>list=new ArrayList<>();
        boolean isSuccess = true;
        try (Connection connection = context.getBean("dataSourceHikari", HikariDataSource.class).getConnection()) {
            //通过连接获取statement
                //Preparestatement （增、删、改、查）
                String sqlString = "insert into student(student_id,student_name) values (?,?)";
                PreparedStatement ps = connection.prepareStatement(sqlString);
                ps.setLong(1,newStudent.getStudentId());
                ps.setString(2,newStudent.getStudentName());
                //成功返回false 失败返回true
                isSuccess = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //为了方便后面操作 返回相反的结果
        return !isSuccess;
    }
    public static void main(String[] args) throws ClassNotFoundException {

        List<Student> list=selectAllStudent();
        for(Student student:list){
            System.out.println(student.getStudentId());
        }
    }
}
