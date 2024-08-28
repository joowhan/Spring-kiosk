<%--
  Created by IntelliJ IDEA.
  User: gimjuhwan
  Date: 8/23/24
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello world</h1>
<h1>어서오세요 KOPO 카페입니다.</h1>
<div class="button-container">
    <form action="selectPickUpType" method="post">
        <button type="submit" name="pickUpType" value="Eat-in" class="button">매장</button>
        <button type="submit" name="pickUpType" value="Take-out" class="button">포장</button>
    </form>
</div>
</body>
</html>
