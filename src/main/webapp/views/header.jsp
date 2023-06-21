<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String name = null;
  name = (String) session.getAttribute("name");
%>
<link rel="stylesheet" href="/css/header.css">
  <div class="navbar">
    <a class="logo" href="/">
      <h2>kiosk</h2>
    </a>
    <ul>
      <c:choose>
        <c:when test = "${name != null}">
          <li><a href="#">
            <h2>사용자 :${name}님</h2></a>
          </li>
          <li><a href="/logout">
            <h2>로그아웃</h2></a>
          </li>
        </c:when>
        <c:otherwise>
          <li><a href="/views/login.html">
            <h2>로그인 해주세요.</h2></a>
          </li>
        </c:otherwise>
      </c:choose>
    </ul>
  </div>
  <img class="hero_header" src="https://www.mmthcoffee.com/files/download/065b6e0b445e608bf69b78b9f87a41f8.jpg">
  <h1>매머드 커피</h1>
