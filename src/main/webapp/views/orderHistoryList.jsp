<%@ page import="java.util.List" %>
<%@ page import="com.playdata.kiosk.dto.OrderHistoryDto" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: parkkyounghee
  Date: 2023/06/21
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>

</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/orderhistory.css">
<c:import url="/views/header.jsp"/>
<table>
    <thead><h1>주문 내역</h1></thead>
    <tbody>
            <tr>
                <th>고객 이름</th>
                <th>카테고리 이름</th>
                <th>상품 이름</th>
                <th>구매 수량</th>
                <th>가격</th>
                <th>구매 날짜</th>
            </tr>
        <c:forEach var="orderHistory" items = "${orderHistoryList}">
            <tr>
              <td><span>${orderHistory.uname}</span></td>
              <td><span>${orderHistory.cname}</span></td>
              <td><span>${orderHistory.pname}</span></td>
              <td><span>${orderHistory.amount}</span></td>
              <td><span>${orderHistory.price}</span></td>
              <td><span>${orderHistory.orderedAt}</span></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
