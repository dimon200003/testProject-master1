<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.06.2021
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Here we edit car</title>
</head>
<body>
<h2>Here we edit car</h2>

<form action="caredit" method="post">
    <input type="hidden" name="CarUpdatedId" value="${carOldId}" readonly>
    <input type="text" name="CarUpdatedCarName" value="${carOldCarName}">
    <input type="number" name="CarUpdatedAge" value="${carOldAge}">
    <button type="submit">Save</button>
</form>
<form action="carlist" method="get">
    <button type="submit">Cancel</button>
</form>








</body>
</html>
