<html>
<head>

</head>
<body>
<form action="digit-output" method="GET">
    <label for="number">ENTER NUMBER</label>
    <br>
    <input type="number" id="number" name="digit"
           placeholder="HERE"/>
    <br>
    <input type="submit">

</form>
<form action="${pageContext.request.contextPath}/">
    <br>
    <button>RETURN</button>
</form>
</body>
</html>
