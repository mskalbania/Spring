<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<style>



</style>
<head>
</head>
<body>
<div>
<form:form action="processStudentForm" method="get" modelAttribute="student">

    First Name: <form:input path="firstName" />
    <br><br>
    Last Name: <form:input path="lastName"/>
    <br><br>
    <input type="submit" value="SUBMIT">

</form:form>
</div>
</body>
</html>
