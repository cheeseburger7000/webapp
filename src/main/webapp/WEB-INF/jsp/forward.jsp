<%--
  Created by IntelliJ IDEA.
  User: shaohsiung
  Date: 2019/9/17
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>forward</title>
</head>
<body>
    <h1>${name}</h1>
    <button id="btn">测试在jsp中获取jquery</button>

    <script src="${pageContext.request.contextPath}/script/jquery.js"></script>
    <script>
        $('#btn').click(function () {
            console.log('jquery import success...')
        })
    </script>
</body>
</html>
