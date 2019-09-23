<%--
  Created by IntelliJ IDEA.
  User: shaohsiung
  Date: 2019/9/17
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>guessNumber</title>
</head>
<body>
    <c:if test="${time == 0}">
        您选择的难度：
        <c:if test="${level == 0}">简单</c:if>
        <c:if test="${level == 1}">普通</c:if>
        <c:if test="${level == 2}">困难</c:if>
        <br>
        随机值：${random}<br>
        <form action="/guess" method="post">
            我猜：<input type="text" name="number">
            <br>
            <input type="submit" value="确定">
        </form>
    </c:if>
    <c:if test="${time != 0}">
        <a href="${pageContext.request.contextPath}/level">再玩一次</a>
    </c:if>

    <c:if test="${not empty message}">
        <h3>提示：${message}</h3>
    </c:if>

    <c:if test="${consume != 0}">
        <h3>次数：${consume}</h3>
    </c:if>

    <c:if test="${time != 0}">
        <h3>耗时：${time}</h3>
    </c:if>
</body>
</html>
