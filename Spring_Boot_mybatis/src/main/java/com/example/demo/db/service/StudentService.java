package com.example.demo.db.service;



import com.example.demo.db.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author:GQM
 * @Date:created in 15:23 2020/4/21
 * @Description:
 * @Modifyed_By:
 */
public interface StudentService {

    /**
     * 查找所有学生名单
     * @return
     */
    List<Student> selectAllStudent();

    /**
     * 新增学生
     * @param newStudent
     * @return
     */
    String addStudent(Student newStudent) throws SQLException;
}
