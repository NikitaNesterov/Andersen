<%--
  Created by IntelliJ IDEA.
  User: r06678
  Date: 05.11.2021
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert New Product</title>
</head>
<body>
<div align="left">
    <h1>Завести в БД новый продукт</h1>
    <form action="<%= request.getContextPath() %>/productController" method="post">
        <%request.getSession().setAttribute("method","insert");%>
        <table style="with: 80%">
            <tr>
                <td>Название</td>
                <td><input type="text" name="productName"/></td>
            </tr>
            <tr>
                <td>Количество</td>
                <td><input type="text" name="productQuantity"/></td>
            </tr>
            <tr>
                <td>Поставщик</td>
                <td><input type="text" name=productSupplier"/></td>
            </tr>
        </table>
        <input type="submit" value="Создать"/>
    </form>
</div>

</body>
</html>
