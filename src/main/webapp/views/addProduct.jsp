<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
  <style>
    body {
      margin-left:500px;
      margin-right:500px;
    }
  </style>
</head>
<body>
<c:import url="/views/header.jsp"/>
<h1>상품추가</h1>
<div style="text-align: center">
  <form action="/addproduct" method="post" accept-charset="UTF-8">
    <input style="text-align: center" type="text" name="name" placeholder="상품명을 입력하세요"><br><br>
    <input style="text-align: center" type="text" name="categoryId" placeholder="카테고리를 입력하세요"><br><br>
    <input style="text-align: center" type="text" name="quantity" placeholder="수량을 입력하세요"><br><br>
    <input style="text-align: center" type="text" name="price" placeholder="가격을 입력하세요"><br><br>
    <input style="text-align: center" type="text" name="makeTime" placeholder="제조 시간을 입력하세요"><br><br>
    <input style="text-align: center" type="url"  name="imgUrl" placeholder="이미지를 넣어주세요"><br><br>
    <button>추가</button>
  </form>
</div>
</body>
</html>
