<%@ page import="com.example.spring.mvc.bean.TeacherHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.spring.mvc.bean.StudentHomework" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="org.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: guoqi
  Date: 2020/3/7
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>家庭作业</title>
</head>
<body>
<h1 align="center">
    作业列表
</h1>
<table align="center" width="970" border="1" bgcolor="black" cellpadding="1" cellspacing="1">
    <tr bgcolor="aqua">
        <td align="center">作业编号</td>
        <td align="center">作业标题</td>
    </tr>
    <%

//        TeacherHomeworkJdbc teacherHomeworkJdbc = new TeacherHomeworkJdbc();
        JSONObject jsonObject = (JSONObject) request.getAttribute("json");
        List<TeacherHomework> tlist = (List<TeacherHomework>)jsonObject.get("teacherhomeworklist");
//        try {
//            tlist = teacherHomeworkJdbc.selectAllTeacherHomework();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        if(null == tlist||tlist.size()<=0){
            out.println("None data.");
        }else{
            for(TeacherHomework th:tlist){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=th.getHomeworkId()%></td>
        <td><%=th.getHomeworkTitle()%></td>
    </tr>
    <%}}%>
</table>
<h1 align="center">
    作业提交记录
</h1>
<table align="center" width="970" border="1" bgcolor="black" cellpadding="1" cellspacing="1">
    <tr bgcolor="aqua">
        <td align="center">ID</td>
        <td align="center">学号</td>
        <td align="center">作业编号</td>
        <td align="center">作业标题</td>
        <td align="center">作业内容</td>
        <td align="center">创建时间</td>
    </tr>
    <%
        List<StudentHomework> slist = (List<StudentHomework>)jsonObject.get("studenthomeworklist");
        if(null == slist || slist.size()<=0){
            out.println("None data.");
        }else{
            for(StudentHomework sh: slist){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getId()%></td>
        <td><%=sh.getStudentId()%></td>
        <td><%=sh.getHomeworkId()%></td>
        <td><%=sh.getHomeworkTitle()%></td>
        <td><%=sh.getHomeworkContent()%></td>
        <td><%=sh.getCreatTime()%></td>
    </tr>
    <%}}%>
</table>
</body>
</html>
