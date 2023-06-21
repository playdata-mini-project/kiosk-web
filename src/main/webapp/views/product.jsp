<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/css/product.css">
    <title>Product</title>
    <script src="/js/product.js" defer></script>
</head>
<body>
<c:import url="/views/header.jsp"/>
<div class="container">
    <ul class="tab-container">
        <li class="tab-container__item" data-tab="tab">
            <a class="tab-container__item--title" href="javascript:sendPost('0')">전체</a>
        </li>
        <li class="tab-container__item" data-tab="tab">
            <a class="tab-container__item--title" href="javascript:sendPost('1')">커피</a>
        </li>
        <li class="tab-container__item" data-tab="tab">
            <a class="tab-container__item--title" href="javascript:sendPost('2')">티</a>
        </li>
        <li class="tab-container__item" data-tab="tab">
            <a class="tab-container__item--title" href="javascript:sendPost('3')">스무디</a>
        </li>
    </ul>
    <section class="content-container">
        <article id="tab" class="content-container__content target">
            <div class="products">
                <c:forEach var="list" items="${productList }">
                        <c:choose>
                            <c:when test = "${list.quantity == 0}">
                                <a href ="/product">
                                <img src=/SOLDOUT.png>
                            </c:when>
                            <c:otherwise>
                                <a href="/productdetail?id=${list.id}">
                                <img src=${list.image}>
                            </c:otherwise>
                        </c:choose>
                        <p>${list.name}</p>
                        <div class="price">
                            <p>${list.price}원</p>
                            <p>[재고수량 : ${list.quantity}개]</p>
                        </div>
                    </a>
                </c:forEach>
                <div class="clearfix"></div>
            </div>
        </article>
    </section>
    <a href = "/productcart" class = "button"><h1>장바구니 보기</h1></a>
</div>
</body>
</html>
