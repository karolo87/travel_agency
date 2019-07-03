<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dodaj lotnisko</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<form:form action="/admin/add-airport/${cityId}" modelAttribute="newAirport" method="post">

    Nazwa lotniska: <form:input path="name"/>
    <input type="submit" value="Dodaj"/>
</form:form>

</body>
</html>