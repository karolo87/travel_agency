<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista hoteli</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>
<div class="container">
    <%@include file="../fragments/header.jspf" %>

    <c:forEach items="${hotelsList}" var="hotel">
        ${hotel.name} |
        ${hotel.standard} |
        ${hotel.description}
    </c:forEach>
</div>



</body>
</html>