<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>메뉴 상세 보기</title>
    <style>
        .cart-icon {
            position: fixed;
            top: 20px;
            right: 20px;
            font-size: 24px;
            cursor: pointer;
        }
        .cart-count {
            position: absolute;
            top: -10px;
            right: -10px;
            background-color: red;
            color: white;
            border-radius: 50%;
            padding: 5px 10px;
            font-size: 14px;
        }
        .size-option.selected {
            background-color: #5c85d6;
            color: white;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
</head>
<body>
<h1>${menu.name}</h1>
<img src="${pageContext.request.contextPath}/resources/${menu.imgUrl}" alt="${menu.name}" width="200" height="200"/>
<p>가격: ${menu.price}원</p>

<!-- 장바구니 아이콘 -->
<c:if test="${cartItemCount > 0}">
    <div id="cart-icon" class="cart-icon" onclick="location.href='${pageContext.request.contextPath}/cart'">
        🛒<span id="cart-count" class="cart-count">${cartItemCount}</span>
    </div>
</c:if>

<!-- 수량 선택 -->
<div>
    <label>수량: </label>
    <button type="button" onclick="decreaseQuantity()">-</button>
    <input type="text" id="quantity" value="1" readonly>
    <button type="button" onclick="increaseQuantity()">+</button>
</div>

<!-- 사이즈 선택 (사이즈가 있는 경우에만 보임) -->
<c:if test="${menu.hasSizes()}">
    <div>
        <label>사이즈: </label>
        <c:forEach var="size" items="${menu.sizes}">
            <button type="button" class="size-option" onclick="selectSize('${size}')" id="size-${size}">${size}</button>
        </c:forEach>
    </div>
</c:if>

<%-- <!-- 장바구니 및 주문 버튼 -->
<div>
    <button type="button" onclick="addToCart()">담기</button>
    <button type="button" onclick="location.href='${pageContext.request.contextPath}/cart'">주문하기</button>
</div> --%>

<form id="cartForm" action="${pageContext.request.contextPath}/cart/add" method="post">
    <input type="hidden" name="itemId" value="${menu.itemId}"/>
    <input type="hidden" name="name" value="${menu.name}"/>
    <input type="hidden" name="price" value="${menu.price }">
    <input type="hidden" name="selectedSize" id="selectedSizeInput" value="${menu.sizes[0]}"/>
    <input type="hidden" name="quantity" id="quantityInput" value="1"/>
    <button type="submit">담기</button>
    
     <%-- <button type="button" onclick="location.href='${pageContext.request.contextPath}/cart'">주문하기</button> --%>
</form>

<form id="orderForm" action="${pageContext.request.contextPath}/cart/addAndOrder" method="post">
    <input type="hidden" name="itemId" value="${menu.itemId}"/>
    <input type="hidden" name="name" value="${menu.name}"/>
    <input type="hidden" name="price" value="${menu.price }">
    <input type="hidden" name="selectedSize" id="selectedSizeInput2" value="${menu.sizes[0]}"/>
    <input type="hidden" name="quantity" id="quantityInput2" value="1"/>
     <button type="submit">주문하기</button>
</form>

<a href="${pageContext.request.contextPath}/menu">뒤로 가기</a>

<script>
    var selectedSize = null;
	// 수량 증가
    function decreaseQuantity() {
        var quantityInput = document.getElementById("quantity");
        var quantity = parseInt(quantityInput.value);
        if (quantity > 1) {
            quantityInput.value = quantity - 1;
            document.getElementById("quantityInput").value = quantityInput.value;
            document.getElementById("quantityInput2").value = quantityInput.value;
        }
    }
	// 수량 감소
    function increaseQuantity() {
        var quantityInput = document.getElementById("quantity");
        var quantity = parseInt(quantityInput.value);
        quantityInput.value = quantity + 1;
        document.getElementById("quantityInput").value = quantityInput.value;
        document.getElementById("quantityInput2").value = quantityInput.value;
    }

    function selectSize(size) {
        selectedSize = size;
        document.querySelectorAll(".size-option").forEach(function(button) {
            button.classList.remove("selected");
        });
        document.getElementById("size-" + size).classList.add("selected");
        document.getElementById("selectedSizeInput").value = size; // 선택된 사이즈를 히든 필드에 저장
        document.getElementById("selectedSizeInput2").value = size; // 선택된 사이즈를 히든 필드에 저장
    }
	// 카트 아이콘 표시
    function updateCartIcon(itemCount) {
        if (itemCount > 0) {
            document.getElementById("cart-icon").style.display = "block";
            document.getElementById("cart-count").innerText = itemCount;
        } else {
            document.getElementById("cart-icon").style.display = "none";
        }
    }
</script>
</body>
</html>
