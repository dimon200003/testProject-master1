
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11.06.2021
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>I am car page</title>
</head>
<body>
<h2>I am car page</h2>
<table border="3">

    <tr>
        <th>Id</th>
        <th>CarName</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${carList}" var="car">
    <tr>
        <td>${car.getId()}</td>
        <td>${car.getCarName()}</td>
        <td>${car.getAge()}</td>
        <td>
            <form action="cardelete" method="get">
                <input type="hidden" name="CarIdParam" value="${car.getId()}">
                <button type="submit">Delete</button>
            </form>
        </td>
        <td>
            <form action="caredit" method="get">
                <input type="hidden" name="CarIdParam" value="${car.getId()}"/>
                <input type="hidden" name="CarCarNameParam" value="${car.getCarName()}"/>
                <input type="hidden" name="CarAgeParam" value="${car.getAge()}"/>
                <button type="submit">Edit</button>
            </form>

        </td>
    </tr>
        </c:forEach>
</table>
<form action="/webProject/caradd" method="get">
    <button type="submit">Add new car</button>
</form>


</body>
</html>
