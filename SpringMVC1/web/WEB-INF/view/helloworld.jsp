<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 17.07.17
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World Respond</title>
</head>
<body>

<h2>${message}</h2>

<form method="get" action="${pageContext.request.contextPath}/">
    <button type="submit">RETURN</button>
</form>

</body>
</html>
