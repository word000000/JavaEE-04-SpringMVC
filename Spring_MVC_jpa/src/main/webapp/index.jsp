<%--
  Created by IntelliJ IDEA.
  User: guoqi
  Date: 2020/2/28
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>作业系统</title>
  </head>
  <body align="center">
    <h1 >
      作业系统
    </h1>
      <a href="${pageContext.request.contextPath}/searchallhomework" >
        <button >教师---作业列表</button>
      </a>
      <br/>
      <br/>
      <a href="${pageContext.request.contextPath}/searchstudent" >
        <button>教师---学生列表</button>
      </a>
    <br/>
    <br/>
      <a href="${pageContext.request.contextPath}/addHomework" >
        <button>教师---发布作业</button>
      </a>
    <br/>
    <br/>
    <a href="${pageContext.request.contextPath}/submitHomework" >
      <button>学生---提交作业</button>
    </a>
    <br/>
  </body>
</html>
