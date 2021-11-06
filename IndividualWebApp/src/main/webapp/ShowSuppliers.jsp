<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>

    body {
        background-color: #F8F8FF;
    }

    h2 {
        color: #7B68EE;
        font-family: "Arial Black";

    }

    div {
        color: #00008B;
        font-family: "Arial Rounded MT Bold";
    }

    input {
        background-color: #F5DEB3;
        color: #1E90FF;
    }

</style>
<head>
    <meta charset="UTF-8">
    <title>База данных поставщиков</title>
</head>
<body>

<h2>Список поставщиков</h2>


<div><%= request.getAttribute("suppliers")  %>
</div>
<p>

</p>
<form method="get" action="Greetingmenu">
    <input type="submit" value="Вернуться в главное меню"/>
</form>
</body>
</html>
