package com.example.demo.db.model;



import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

/**
 * @Author:GQM
 * @Date:created in 18:03 2020/3/7
 * @Description:
 * @Modifyed_By:
 */

@Configuration
public class StudentHomework {

    private Long id;

    private Long studentId;

    private Long homeworkId;


    private String homeworkTitle;


    private String homeworkContent;

    private Timestamp createTime;

    private Timestamp updateTime;

    public StudentHomework(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getHomeworkTitle() {
        return homeworkTitle;
    }

    public void setHomeworkTitle(String homeworkTitle) {
        this.homeworkTitle = homeworkTitle;
    }

    public String getHomeworkContent() {
        return homeworkContent;
    }

    public void setHomeworkContent(String homeworkContent) {
        this.homeworkContent = homeworkContent;
    }

    public Timestamp getCreatTime() {
        return createTime;
    }

    public void setCreatTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
