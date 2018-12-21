<%--
  Created by IntelliJ IDEA.
  User: lyzdu
  Date: 20/12/2018
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 Mon cookie contient : ${requestScope["lastDate"]}
    <br>
    Mon iD : ${requestScope["iD"]}
    <br>
    createDateSession : ${requestScope["createDateSession"]}
    <br>
    currentDateSession : ${requestScope["currentDateSession"]}
</body>
</html>
