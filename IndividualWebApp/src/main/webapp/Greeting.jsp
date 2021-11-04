<%--
  Created by IntelliJ IDEA.
  User: r06678
  Date: 03.11.2021
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    h1 {
        color: #FF7F50;
        font-family: serif;
        font-weight: bold;
        font-style: oblique;
        position: relative;
        border-style: dotted;
        border-color: darkblue;
        border-width: thin;
    }

    input {
        background-color: #F5DEB3;
        color: #1E90FF;
    }
</style>

<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h1> "Приветствуем Вас на стартовой странице нашей Базы Данных"</h1>
<div>
    <p>
    <form action="products" method="get"> </form>
        <input type="submit" value="Нажмите, чтобы начать работу с базой данных">
    </form>
</div>
</body>
</html>
