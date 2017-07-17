<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 17.07.17
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .center {
        margin-top: 50px;
        text-align: center;
    }
    .button {
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        padding: 20px 50px;
        border-radius: 8px;
        margin: 4px 2px;
        cursor: pointer;
        transition-duration: 0.6s;
    }
    .button:hover{
        background-color: white;
        border: 2px solid #4CAF50;
        color: #4CAF50;
    }
</style>
<head>
</head>
<body>
<div class="center">

    <h2>${message}</h2>
    <form method="get" action="${pageContext.request.contextPath}/">
        <button class="button" type="submit">RETURN</button>
    </form>

</div>
</body>
</html>
