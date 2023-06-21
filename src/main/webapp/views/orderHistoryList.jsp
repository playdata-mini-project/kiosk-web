<%--
  Created by IntelliJ IDEA.
  User: parkkyounghee
  Date: 2023/06/21
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
  <c:forEach var="orderHistory" items = "${orderHisrotyList}">
      <tr>
        <td><span name="uname">${orderHistory.uname}</span></td>
        <td><span name="cname">${orderHistory.cname}</span></td>
        <td><span name="pname">${orderHistory.pname}</span></td>
        <td><span name="amount">${orderHistory.amount}</span></td>
        <td><span name="price">${orderHistory.price}</span></td>
        <td><span name="orderedAt">${orderHistory.orderedAt}</span></td>
      </tr>
  </c:forEach>
</table>