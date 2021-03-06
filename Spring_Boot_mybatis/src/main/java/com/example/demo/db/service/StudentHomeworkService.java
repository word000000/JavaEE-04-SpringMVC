package com.example.demo.db.service;



import com.example.demo.db.model.StudentHomework;

import java.util.List;

/**
 * @Author:GQM
 * @Date:created in 15:23 2020/4/21
 * @Description:
 * @Modifyed_By:
 */
public interface StudentHomeworkService {


    /**
     * 学生提交作业
     * @param nsh
     * @return
     */
    String addStudentHomework(StudentHomework nsh);


    /**
     * 查询所有学生提交的作业记录
     * @return
     */
    List<StudentHomework> selectAllStudentHomework();

}
