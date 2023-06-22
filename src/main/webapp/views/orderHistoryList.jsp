<%@ page import="java.util.List" %>
<%@ page import="com.playdata.kiosk.dto.OrderHistoryDto" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body style="margin-bottom: 100px;">
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
              <td style="text-align: center"><span>${orderHistory.uname}</span></td>
              <td style="text-align: center"><span>${orderHistory.cname}</span></td>
              <td style="text-align: center"><span>${orderHistory.pname}</span></td>
              <td style="text-align: center"><span>${orderHistory.amount}</span></td>
              <td style="text-align: center"><span>${orderHistory.price}</span></td>
              <td style="text-align: center"><span>${orderHistory.orderedAt}</span></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
