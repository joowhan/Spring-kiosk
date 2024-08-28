<%--
  Created by IntelliJ IDEA.
  User: gimjuhwan
  Date: 8/26/24
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>주문 완료</title>
</head>
<body>
<h1>주문 완료</h1>
    <p>${message}</p>
    <p>${orderId}</p>
    <a href="${pageContext.request.contextPath}/">홈으로 가기</a>
</body>
</html>
