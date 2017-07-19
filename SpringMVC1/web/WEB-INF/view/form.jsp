<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 18.07.17
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
</head>
<body>

<form:form action="processStudentForm" modelAttribute="student">

    First Name: <form:input path="firstName"/>
    <br><br>
    Last Name: <form:input path="lastName"/>
    <br><br>
    <input type="submit" value="SUBMIT">

</form:form>

</body>
</html>
