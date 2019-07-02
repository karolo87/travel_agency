<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista krajów</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<h2>Lista krajów</h2>

<c:forEach items="${allCountries}" var="country">
    ${country.name}
    ${country.continent.name}
    <br/>
</c:forEach>



</body>
</html>