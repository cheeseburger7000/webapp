<%--
  Created by IntelliJ IDEA.
  User: shaohsiung
  Date: 2019/9/17
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>book</title>
</head>
<body>
    <h1>添加书籍</h1>
    <form action="${pageContext.request.contextPath}/book" method="post">
        <div>
            <label for="name">书籍名称</label>
            <input id="name" type="text" name="name">
        </div>
        <br>
        <div>
            <label for="detail">书籍详情</label>
            <input id="detail" type="text" name="detail">
        </div>
        <br>
        <div>
            <label for="price">书籍价格</label>
            <input id="price" type="text" name="price">
        </div>
        <br>
        <input type="submit" value="添加">
    </form>

    <br><br>
    <h1>我的书柜</h1>
    <c:if test="${empty bookList}">
        <h3>您还没有添加任何书籍！</h3>
    </c:if>
    <c:if test="${not empty bookList}">
        <table border="1px">
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>描述</td>
            </tr>
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td>${book.detail}</td>
                </tr
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
