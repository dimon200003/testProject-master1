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
<h2>This is manufactory add page</h2>
<form action="maddmanufactory" method="post">
    <input type="text" name="manufactoryIdInput" value=""/>
    <input type="text" name="manufactoryNameInput" value=""/>
    <input type="number" name="manufactoryProfitInput" value=""/>
    <button type="submit">Save</button>
</form>
<form action="list" method="get">
    <button type="submit">Cancel</button>
</form>

</body>
</html>
