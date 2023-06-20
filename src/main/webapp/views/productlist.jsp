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
<table>
<c:forEach var="product" items = "${productlist}" >
    <tr>
        <td><c:out value="${product.id}"/></td>
        <td><c:out value="${product.name}"/></td>
        <td><c:out value="${product.categoryId}"/></td>
        <td><c:out value="${product.quantity}"/></td>
        <td><c:out value="${product.price}"/></td>
        <td><c:out value="${product.makeTime}"/></td>
        <td><input type="text"></td>
        <td><input type="submit" value="추가"></td>
    </tr>
</c:forEach>
</table>