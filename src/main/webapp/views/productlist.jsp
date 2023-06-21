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


<table>
<c:forEach var="product" items = "${productlist}">
    <form action="/addProductUpdate" method="post" accept-charset="UTF-8">
             <tr>
                <td><input name="id" value="${product.id}" type="hidden"/>
                    <span name="id">${product.id}</span>
                </td>
                <td><span name="name">${product.name}</span></td>
                <td><span name="categoryId">${product.categoryId}</span></td>
                <td><span name="price">${product.price}</span></td>
                <td><span name="makeTime">${product.makeTime}</span></td>
                <td><input name="quantity" value="${product.quantity}" type="hidden"/>
                    <span name="quantity">${product.quantity}</span>
                </td>
                <td><input type="text" name="addQuantity" /></td>
                <td><input type="submit" value="추가"></td>
            </tr>

    </form>
</c:forEach>
</table>