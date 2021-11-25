<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.05.2021
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>This is page for edit person</h2>
<form action="/webProject/mvc/person/edit" method="post">
    <input type="hidden" name="personUpdatedId" value="${personOldId}" readonly/>
    <input type="text" name="personUpdatedName" value="${personOldName}"/>
    <input type="number" name="personUpdatedAge" value="${personOldAge}"/>
    <button type="submit">Save</button>
</form>
<form action="/webProject/mvc/person/list" method="get">
    <button type="submit">Cancel</button>
</form>

</body>
</html>
