<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.05.2021
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${sometext}
<h2>This is Manufactory List Page</h2>

<table border="3">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Profit</th>
    </tr>
    <c:forEach items="${manufactoryList}" var="manufactory">
        <td>${manufactory.getId()}</td>
        <td>${manufactory.getName()}</td>
        <td>${manufactory.getProfit()}</td>
        <td>
            <form action="deletemanufactory" method="get">
                <input type="hidden" name="ManufactoryId" value="${manufactory.getId()}">
                <button type="submit" >Delete</button>
            </form>
        </td>
        <td>
            <form action="manufactoryedit" method="get">
                <input type="hidden" name="ManufactoryIdParam" value="${manufactory.getId()}">
                <input type="hidden" name="ManufactoryNameParam" value="${manufactory.getName()}">
                <input type="hidden" name="ManufactoryProfitParam" value="${manufactory.getProfit()}">
                <button type="submit" >Edit</button>

            </form>
        </td>
        </tr>
    </c:forEach>
</table>
<form action="maddmanufactory" method="get">
    <button type="submit">Add new manufactory</button>
</form>

</body>
</html>