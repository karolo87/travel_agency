<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista krajów</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<h2>Lista miast</h2>

<c:choose>
    <c:when test="${empty cityList}">
        Lista miast pusta.
        <a href="/admin/add-city/${countryId}">Dodaj miasto.</a>
    </c:when>
    <c:otherwise>
        <c:forEach items="${cityList}" var="city">
            ${city.name}
            <a href="/hotel/list/${city.id}">Lista hoteli</a>
            <a href="/admin/add-hotel/${city.id}">Dodaj hotel</a>
            <a href="/airport/list/${city.id}">Lista lotnisk</a>
            <a href="/admin/add-airport/${city.id}">Dodaj lotnisko</a>
        </c:forEach>

    </c:otherwise>
</c:choose>



</body>
</html>