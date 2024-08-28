<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>판매 현황</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .total-sales {
            margin-top: 20px;
            font-weight: bold;
            font-size: 18px;
            text-align: right;
        }
        .total-sales span {
            color: #5c85d6;
        }
        .button {
            padding: 10px 20px;
            background-color: #5c85d6;
            color: white;
            border: none;
            cursor: pointer;
            text-align: center;
            display: block;
            margin: 20px auto;
            width: 200px;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<h1>판매 현황</h1>

<table>
    <thead>
    <tr>
        <th>상품</th>
        <th>판매수량</th>
        <th>매출</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sales" items="${salesList}">
        <tr>
            <td>${sales.name}</td>
            <td>${sales.quantity}</td>
            <td>${sales.totalSales}원</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="total-sales">
    총 매출: <span>${totalSales}원</span>
</div>

<a href="${pageContext.request.contextPath}/order/sales" class="button">새로고침</a>

</body>
</html>
