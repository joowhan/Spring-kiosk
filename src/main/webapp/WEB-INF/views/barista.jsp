<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>바리스타 화면</title>
    <style>
        .order-box {
            border: 1px solid #800080;
            padding: 10px;
            margin: 10px;
            border-radius: 10px;
            display: inline-block;
            width: 200px;
        }
        .order-button {
            background-color: #5c85d6;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>바리스타 화면</h1>

<c:forEach var="entry" items="${orders.entrySet()}">
    <div class="order-box">
        <p>주문번호 : ${entry.key}</p>
        <c:forEach var="item" items="${entry.value.orderItems}">
            <p>${item.name}(${item.selectedSize}) ${item.quantity}개 - ${item.price}원</p>
        </c:forEach>
        <form action="${pageContext.request.contextPath}/order/barista/process" method="post">
            <input type="hidden" name="orderId" value="${entry.key}">
            <c:choose>
                <c:when test="${entry.value.pickUp == 'Eat-in'}">
                    <input type="hidden" name="action" value="제공">
                    <button type="submit" class="order-button">제공</button>
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="action" value="포장">
                    <button type="submit" class="order-button">포장하기</button>
                </c:otherwise>
            </c:choose>
        </form>
    </div>
</c:forEach>

<button class="order-button" onclick="location.reload()">새로고침</button>

</body>
</html>
