<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dodaj wycieczkę</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<h2>Dodaj wycieczkę</h2>

    <c:forEach items="${foundTrips}" var="trip">
        ${trip.departureCity.name} <br/>
        ${trip.departureAirport.name} <br/>
        ${trip.arrivalCity.name} <br/>
        ${trip.arrivalAirport.name} <br/>
    </c:forEach>



</body>
</html>