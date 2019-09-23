<%--
  Created by IntelliJ IDEA.
  User: shaohsiung
  Date: 2019/9/17
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>selectLevel</title>
</head>
<body>
    <form action="/level" method="post">
        请选择难度：简单1-10，普通1-30，困难1-50：
        <select name="level" id="level">
            <option value="0">简单</option>
            <option value="1">普通</option>
            <option value="2">困难</option>
        </select>
        <br>
        <input type="submit" value="确定">
    </form>
</body>
</html>
