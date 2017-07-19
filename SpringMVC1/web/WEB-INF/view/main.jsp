<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 17.07.17
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .center {
        margin-top: 50px;
        text-align: center;
    }
</style>
<head>
    <title>Main</title>
</head>
<body>
<div class="center">
    <h2>MENU</h2>
    <h3>
        1. <a href="${pageContext.request.contextPath}/showForm">
        @Mapping annotations</a><br>
        2. <a href="${pageContext.request.contextPath}/digit-input">
        @RequestParam</a><br>
        3. <a href="${pageContext.request.contextPath}/student/showStudentForm">
        MVC Spring Tags</a><br>
    </a>
    </h3>
</div>
</body>
</html>
