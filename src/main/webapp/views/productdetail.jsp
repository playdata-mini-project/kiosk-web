<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.playdata.kiosk.dto.ProductDetailDto" %>
<% ProductDetailDto productDetail = (ProductDetailDto) request.getAttribute("productDetail"); %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/product.css">
</head>
<body>
<c:import url="/views/header.jsp"/>
<div class="productDetail">
    <img src=<%=productDetail.getImage()%>>
    <H1><%=productDetail.getName()%></H1>
    <H1><%=productDetail.getPrice()%>원</H1>
    <H1>[재고수량 : <%=productDetail.getQuantity()%>개]</H1>
    <form action="/productcart" method="post">
        <input type = "hidden" name="id" value="<%=productDetail.getId()%>">
        <input type = "hidden" name="name" value="<%=productDetail.getName()%>">
        <input type = "hidden" name="price" value="<%=productDetail.getPrice()%>">
        <select name = "quantity">
            <c:forEach begin="1" end="<%=productDetail.getQuantity()%>" var="i">
                <option value = "${i}">${i}</option>
            </c:forEach>
        </select>&nbsp;개
        <input type = "submit" value="장바구니 담기">
    </form>
</div>
</body>
</html>
