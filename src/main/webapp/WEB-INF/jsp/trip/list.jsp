<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista wycieczek</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<h2>Lista wyycieczek</h2>

<c:forEach items="${tripsList}" var="trip">
    Miasto wylotu: ${trip.departureCity.name} |
    Miasto przylotu: ${trip.arrivalCity.name} |
    Lotnisko wylotu: ${trip.departureAirport.name} |
    Lotnisko przylotu: ${trip.arrivalAirport.name} |
    Hotel: ${trip.hotel.name} |
    Początek wycieczki: ${trip.startDate} |
    Koniec wycieczki: ${trip.endDate} |
    Ilość dni: ${trip.daysQuantity} |
    <br/>
</c:forEach>


</body>
</html>