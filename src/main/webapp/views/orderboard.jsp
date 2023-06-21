<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/orderboard.css">
</head>
<body>
<c:import url="/views/header.jsp"/>

<div class = "container">
    <div class = "info_container">
        <H3>준비중</H3>
        <table class="cart_table">
            <thead>
            <tr>
                <th width="350">고객명</th>
                <th width="150">상품이름</th>
                <th width="150">수량</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="list" items="${incomplete }">
                <tr>
                    <td width="150">${list.userName}</td>
                    <td width="350">${list.productName}</td>
                    <td width="150">${list.amount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class = "info_container">
    <H3>준비완료</H3>
    <table class="cart_table">
        <thead>
        <tr>
            <th width="350">고객명</th>
            <th width="150">상품이름</th>
            <th width="150">수량</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${complete }">
            <tr>
                <td width="150">${list.userName}</td>
                <td width="350">${list.productName}</td>
                <td width="150">${list.amount}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</div>
<div class="cart_buttons">
    <button class="cart_button left"><a href = "/product" class="cart_button a">주문추가</a></button>
    <c:if test = "${cartList ne null && name ne null}">
        <button class="cart_button right"><a href = "/order" class="cart_button a">주문하기</a></button>
    </c:if>
</div>
</body>
</html>