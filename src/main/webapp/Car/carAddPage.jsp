<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.06.2021
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Here we add cars</title>
</head>
<body>
<h2>Here we add cars</h2>

<form action="/webProject/caradd" method="post">
    <input type="text" name="carIdInput" value=""/>
    <input type="text" name="carCarNameInput" value=""/>
    <input type="text" name="carAgeInput" value=""/>
    <button type="submit">Save</button>

</form>

<form action="carlist" method="get">
    <button type="submit">Cancel</button>
</form>


</body>
</html>
