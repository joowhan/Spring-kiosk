<%--
  Created by IntelliJ IDEA.
  User: gimjuhwan
  Date: 8/24/24
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>KOPO 카페 - 메뉴</title>
    <style>
        .category-tab {
            display: inline-block;
            margin: 10px;
            padding: 10px;
            background-color: #e0e0e0;
            cursor: pointer;
            border-radius: 5px;
            text-align: center;
        }
        .category-tab.selected {
            background-color: #5c85d6;
            color: white;
        }
        .menu-item {
            display: none; /* 기본적으로 숨김 */
            width: 150px;
            margin: 10px;
            text-align: center;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 10px;
        }
        .menu-item.active {
            display: inline-block; /* 선택된 카테고리에 맞는 항목만 표시 */
        }
    </style>
</head>
<body>
<h1>KOPO 카페 메뉴</h1>

<!-- 카테고리 탭 -->
<div id="category-tabs">
    <span class="category-tab selected" data-category="커피">커피</span>
    <span class="category-tab" data-category="음료">음료</span>
    <span class="category-tab" data-category="푸드">푸드</span>
</div>

<!-- 메뉴 리스트 -->
<div id="menu-container">
    <c:forEach var="menu" items="${menuList}">
        <a href="${pageContext.request.contextPath}/menu/detail?id=${menu.itemId}"
           class="menu-item ${menu.category == '커피' ? 'active' : ''}"
           data-category="${menu.category}">
            <img src="${pageContext.request.contextPath}/resources/${menu.imgUrl}"
                 alt="${menu.name}" width="100" height="100"/>
            <p>${menu.name}</p>
        </a>
    </c:forEach>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        // 모든 탭 요소를 가져옴
        var tabs = document.querySelectorAll(".category-tab");
        // 모든 메뉴 항목 요소를 가져옴
        var menuItems = document.querySelectorAll(".menu-item");

        // 각 탭에 대해 클릭 이벤트 리스너를 추가
        tabs.forEach(function(tab) {
            tab.addEventListener("click", function() {
                var category = tab.getAttribute("data-category");
                console.log("Selected category:", category);

                // 모든 탭의 선택 클래스 제거
                tabs.forEach(function(t) {
                    t.classList.remove("selected");
                });
                // 클릭된 탭에 선택 클래스 추가
                tab.classList.add("selected");

                // 모든 메뉴 항목을 숨김
                menuItems.forEach(function(item) {
                    item.style.display = "none";
                });

                // 선택된 카테고리의 메뉴 항목만 표시
                menuItems.forEach(function(item) {
                    if (item.getAttribute("data-category") === category) {
                        item.style.display = "inline-block";
                    }
                });
                console.log("Displaying menu items for category:", category);
            });
        });

        // 페이지 로드 시 '커피' 메뉴 표시
        menuItems.forEach(function(item) {
            if (item.getAttribute("data-category") === '커피') {
                item.style.display = "inline-block";
            }
        });
    });
</script>
</body>
</html>