<html>
<head>
    <title>Hello world - Input Form</title>
</head>
<style>

    label[for=name]{
        word-spacing: 10px;
        color: black;
        font-size: 30px;
    }

    input[type=text]{
        width: 30%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit]{
        background-color: #af2c1d; /* Green */
        border: none;
        color: white;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        padding: 25px 63px;
        border-radius: 8px;
        margin: 4px 2px;
        cursor: pointer;
        transition-duration: 0.2s;
    }

    input[type=submit]:hover{
        background-color: white;
        border: 2px solid #af2c1d;
        color: #af2c1d;
    }

    .center {
        margin-top: 25px;
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
        padding: 25px 55px;
        border-radius: 8px;
        margin: 4px 2px;
        cursor: pointer;
        transition-duration: 0.2s;
    }
    .button:hover{
        background-color: white;
        border: 2px solid #4CAF50;
        color: #4CAF50;
    }
</style>
<body>
<div class="center">
    <form action="processForm" method="GET">
        <label for="name">ENTER YOUR NAME</label>
        <br>
        <input type="text" id="name" name="studentName"
               placeholder="HERE"/>
        <br><br>
        <input type="submit">

    </form>
    <form method="get" action="${pageContext.request.contextPath}/">
        <button class="button" type="submit">RETURN</button>
    </form>
</div>
</body>
</html>
