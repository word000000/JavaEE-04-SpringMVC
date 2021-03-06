package com.example.demo.controller;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.core.response.DataResponse;
import com.example.demo.db.model.StudentHomework;
import com.example.demo.db.model.TeacherHomework;
import com.example.demo.db.service.StudentHomeworkService;
import com.example.demo.db.service.TeacherHomeworkService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:GQM
 * @Date:created in 18:03 2020/4/21
 * @Description:
 * @Modifyed_By:
 */
@RequestMapping("/")
@RestController
@ComponentScan("com.example.demo.*")
public class TeacherHomeworkController {

    @Autowired
    TeacherHomework teacherHomework;
    @Autowired
    TeacherHomeworkService teacherHomeworkService;
    @Autowired
    StudentHomeworkService studentHomeworkService;
    /**
     *跳转界面 发布作业
     */
    @RequestMapping("addHomework")
    private String addHomework(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        List<TeacherHomework> teacherHomeworkList = null;
        try {
            teacherHomeworkList = teacherHomeworkService.selectAllTeacherHomework();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("teacherhomeworklist",teacherHomeworkList);
        return "/addhomework.jsp";
    }




    /**
     * 教师发布作业
     * @param homeworkId
     * @param homeworkTitle
     * @param resp
     * @throws IOException
     */
    @RequestMapping("createHomework")
    private DataResponse<String> createHomework(@RequestBody TeacherHomework homework) {
        DataResponse<String> response = new DataResponse<>();
//        TeacherHomework nth = new TeacherHomework();
//        nth.setHomeworkId(Long.parseLong(homeworkId));
//        nth.setHomeworkTitle(homeworkTitle);
        System.out.println();
        try {
            response.setData(teacherHomeworkService.createHomework(homework));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }



    /**
     * 跳转界面 查看作业记录
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("searchallhomework")
    private Map<String,Object> searchAllHomework(){
        Map<String,Object> map = new HashMap<>(2);
        List<StudentHomework> studentHomeworkList = null;
        List<TeacherHomework> teacherHomeworkList = null;

        try {
            studentHomeworkList = studentHomeworkService.selectAllStudentHomework();
            teacherHomeworkList = teacherHomeworkService.selectAllTeacherHomework();
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("studenthomework",studentHomeworkList);
        map.put("teacherhomework",teacherHomeworkList);
        return map;
    }
}
