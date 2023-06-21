<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="/css/admin.css">
</head>
<body>
<c:import url="/views/header.jsp"/>
<table>
  <tr>
    <td><ul><a href="/productlist"><h1>1.재고관리</h1></a><br><br></ul></td>
    <td><ul><a href="/addproduct"><h1> 2.상품 추가</h1></a><br><br></ul></td>
    <td><ul><a href="/orderHistoryList"><h1> 3.주문 내역</h1></a><br><br></ul></td>
  </tr>
</table>

</body>
</html>
