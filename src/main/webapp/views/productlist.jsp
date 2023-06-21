<%@ page import="java.util.List" %>
<%@ page import="com.playdata.kiosk.dto.ProductDto" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: parkkyounghee
  Date: 2023/06/20
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/addproduct.css">

<c:import url="/views/header.jsp"/>
<table>
    <tr>
        <th>품번</th>
        <th>상품 이름</th>
        <th>카테고리 번호</th>
        <th>가격</th>
        <th>재조 시간</th>
        <th>수량</th>
        <th></th>
        <th>수량 추가</th>
    </tr>
<c:forEach var="product" items = "${productlist}">
<form action="/addProductUpdate" method="post" accept-charset="UTF-8">
     <tr>
        <td style="text-align: center"><input name="id" value="${product.id}" type="hidden"/>
            <span name="id">${product.id}</span>
        </td>
        <td style="text-align: center"><span name="name">${product.name}</span></td>
        <td style="text-align: center"><span name="categoryId">${product.categoryId}</span></td>
        <td style="text-align: center"><span name="price">${product.price}</span></td>
        <td style="text-align: center"><span name="makeTime">${product.makeTime}</span></td>
        <td style="text-align: center"><input name="quantity" value="${product.quantity}" type="hidden"/>
            <span name="quantity">${product.quantity}</span>
        </td >
        <td style="text-align: center"><input type="text" name="addQuantity" /></td>
        <td style="text-align: center"><input type="submit" value="추가"></td>
    </tr>
</form>
</c:forEach>
</table>