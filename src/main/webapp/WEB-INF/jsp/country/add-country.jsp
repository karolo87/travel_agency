<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dodaj kraj</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>
<div class="container">

    <%@include file="../fragments/header.jspf" %>

    <form:form action="/admin/add-country/${continentId}" modelAttribute="newCountry" method="post">

        Nazwa kraju: <form:input path="name"/>
        <input type="submit" value="Dodaj"/>
    </form:form>

</div>


</body>
</html>