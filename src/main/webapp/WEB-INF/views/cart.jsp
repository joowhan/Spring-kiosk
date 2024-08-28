<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>장바구니</title>
    <style>
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            background-color: #e0e0e0;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        .button.primary {
            background-color: #5c85d6;
            color: white;
        }
        .cart-item {
            margin: 10px 0;
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        .total-price {
            font-weight: bold;
            font-size: 18px;
        }
        .payment-button {
            display: block;
            width: 100%;
            padding: 15px;
            margin: 10px 0;
            background-color: #5c85d6;
            color: white;
            text-align: center;
            cursor: pointer;
            border-radius: 5px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>장바구니</h1>

<!-- 초기화 및 더 주문하기 버튼 -->
<div>
    <button class="button" onclick="clearCart()">초기화</button>
    <button class="button primary" onclick="location.href='${pageContext.request.contextPath}/menu'">더 주문하기</button>
</div>

<!-- 장바구니 목록 -->
<div id="cart-items">
    <c:forEach var="item" items="${cart.items}">
        <div class="cart-item">
            <p>${item.name}</p>
            <p>${item.quantity} x ${item.price}원</p>
        </div>
    </c:forEach>
</div>

<!-- 총 가격 표시 -->
<div class="total-price">
    총 가격: ${totalPrice}원
</div>

<!-- 결제 버튼들 -->
<div>
    <a href="#" class="payment-button" onclick="handlePayment('credit')">신용카드 결제</a>
    <a href="#" class="payment-button" onclick="handlePayment('applepay')">애플페이 결제</a>
    <a href="#" class="payment-button" onclick="handlePayment('cash')">현금 결제</a>
</div>

<script>
    function clearCart() {
        if (confirm("장바구니를 초기화하시겠습니까?")) {
            window.location.href = "${pageContext.request.contextPath}/cart/clear";
        }
    }

    function handlePayment(method) {
        fetch(`${pageContext.request.contextPath}/payment?method=` + method)
            .then(response => response.text())
            .then(data => {
                if (confirm(data)) {
                    // 주문 완료 로직 호출
                    window.location.href = `${pageContext.request.contextPath}/order/complete?method=` + method;
                }
            });
    }
</script>

</body>
</html>
