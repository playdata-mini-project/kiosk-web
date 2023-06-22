<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/cart.css">
</head>
<body>
<c:import url="/views/header.jsp"/>
<div id="content">
    <table class="cart_table">
        <thead>
        <tr>
            <th width="350">상품정보</th>
            <th width="150">상품금액</th>
            <th width="150">수량</th>
            <th width="100">합계</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${cartList.productCartList}">
            <tr>
                <td width="350">
                    <div class="product">
                        <div class="product_image">
                            <img src="${list.image}"/>
                        </div>
                        <div class="pro_nt">${list.name}</div>
                    </div>
                </td>
                <td width="150">${list.price}</td>
                <td width="150">${list.quantity}</td>
                <td width="100">${list.priceTotal}원</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="cart_buttons">
    <button class="cart_button left"><a href="/product" class="cart_button a">주문추가</a></button>
    <c:if test="${cartList.productCartList ne null && name ne null}">
        <button class="cart_button right"><a href="/order" class="cart_button a">주문하기</a></button>
    </c:if>
</div>
</body>
</html>