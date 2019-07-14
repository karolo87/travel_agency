<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dodaj lotnisko</title>
<<<<<<< HEAD
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css"/>

=======
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
>>>>>>> view
</head>
<body>
<div class="container">
    <%@include file="../fragments/header.jspf" %>

<<<<<<< HEAD

<div class="container">

    <form:form action="/admin/add-airport/${cityId}" modelAttribute="newAirport" method="post">

        Nazwa lotniska: <form:input path="name"/>
        <input type="submit" value="Dodaj"/>
    </form:form>

</div>
=======
        <div class="main-page">

        <h1>Dodaj lotnisko</h1>
        <form:form action="/admin/add-airport/${cityId}" modelAttribute="newAirport" method="post">

        Nazwa lotniska: <form:input path="name"/>
        <input type="submit" value="Dodaj"/>
    </form:form>
        </div>
</div>

>>>>>>> view

</body>
</html>