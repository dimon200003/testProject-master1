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
<h2>This is Person List Page</h2>

<table border="3">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${personList}" var="person">
        <tr>
            <td>${person.getId()}</td>
            <td>${person.getName()}</td>
            <td>${person.getAge()}</td>
            <td>
                <form action="delete" method="get">
                    <input type="hidden" name="PersonIdParam" value="${person.getId()}"/>
                    <button type="submit">Delete</button>
                </form>
            </td>
            <td>
                <form action="edit" method="get">
                    <br>
                    <label>name</label>
                    <input type="hidden" name="PersonIdParam" value="${person.getId()}" />
                    <input type="hidden" name="PersonNameParam" value="${person.getName()}" />
                    <input type="hidden" name="PersonAgeParam" value="${person.getAge()}" />
                    <button type="submit">Edit</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="/webProject/mvc/person/create" method="get">
    <button type="submit">Add new person</button>
</form>

</body>
</html>
