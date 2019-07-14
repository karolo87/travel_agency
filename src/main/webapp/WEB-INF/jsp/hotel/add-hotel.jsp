<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dodaj hotel</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>

<div class="container">
    <%@include file="../fragments/header.jspf" %>

    <h2>Dodaj hotel</h2>

    <form:form action="/admin/add-hotel/${cityId}" modelAttribute="newHotel" method="post">
        Nazwa hotelu:
        <form:input path="name"/>
        Standard:
        <form:input path="standard"/>
        Opis:
        <form:input path="description"/>
        <input type="submit" value="Dodaj"/>
    </form:form>
</div>

</body>
</html>