<html>
<head>
    <title>Hello world - Input Form</title>
</head>
<body>
<h2>HELLO WORLD NAME</h2>
<form action="processForm" method="GET">
    <input type="text" name="studentName"
           placeholder="What's your name"/>

    <input type="submit">
</form>

<form method="get" action="${pageContext.request.contextPath}/">
    <button type="submit">RETURN</button>
</form>


</body>
</html>
