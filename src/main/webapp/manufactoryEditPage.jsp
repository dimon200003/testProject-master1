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
${manufactoryOldId}
${manufactoryOldName}
${manufactoryOldProfit}
<h2>This is page for edit Manufactory</h2>
<form action="manufactoryedit" method="post">
    <input type="hidden" name="manufactoryUpdatedId" value="${manufactoryOldId}" readonly/>
    <input type="text" name="manufactoryUpdatedName" value="${manufactoryOldName}"/>
    <input type="number" name="manufactoryUpdatedProfit" value="${manufactoryOldProfit}"/>
    <button type="submit">Save</button>
</form>
<form action="mlistmanufactory" method="get">
    <button type="submit">Cancel</button>
</form>

</body>
</html>
