<%--
  Created by IntelliJ IDEA.
  User: r06678
  Date: 04.11.2021
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>
table, th, td {
    border: 1px solid black;
}
</style>
<head>
<meta charset="UTF-8">
<title>База данных продуктов</title>
</head>
<body>

<h2>Список продуктов</h2>

<c:forEach items="${products}" var="product">

<table>
  <tr>
    <th>Название продукта</th>
    <th>Количество продукта</th>
    <th>Название поставщика</th>
  </tr>
  <tr>
    <td>${product.productName}</td>
    <td>${product.productQuantity}</td>
    <td>${product.productSupplier}</td>
  </tr>

</table>

</c:forEach>

</body>
</html>
