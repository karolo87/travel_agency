<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista wycieczek</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css"/>

</head>
<body>
<%@include file="../fragments/header.jspf" %>

<h2>Lista wycieczek</h2>

<form:form modelAttribute="pageForm" action="/trip/list" method="post">
    Przejdź do strony:<form:input path="page"/>
    Ilość wyników na stronie:<form:input path="size"/>
    Sortuj po:
    <form:select path="sortField">
        <form:option value="departureCity.name" label="Miasto wylotu"/>
        <form:option value="arrivalCity.name" label="Miasto przylotu"/>
        <form:option value="startDate" label="Data wylotu"/>
        <form:option value="endDate" label="Data przylotu"/>
        <form:option value="daysQuantity" label="Ilość dni"/>
        <form:option value="adultPrice" label="Cena/os. dorosły"/>
        <form:option value="childPrice" label="Cena/os. dziecko"/>
    </form:select>
    <form:select path="sortOrder">
        <form:option value="ASC" label="Sortuj rosnąco"/>
        <form:option value="DESC" label="Sortuj malejąco"/>
    </form:select>
    <input type="submit" value="pokaż">
</form:form>

<div class="trips_section">
    <c:forEach items="${tripsList}" var="trip">
        <div class="trip">
            <ul>
                <li>Miasto wylotu: ${trip.departureCity.name}</li>
                <li>Miasto przylotu: ${trip.arrivalCity.name}</li>
                <li>Lotnisko wylotu: ${trip.departureAirport.name}</li>
                <li>Lotnisko przylotu: ${trip.arrivalAirport.name}</li>
                <li>Hotel: ${trip.hotel.name}</li>
                <li>Początek wycieczki: ${trip.startDate}</li>
                <li>Koniec wycieczki: ${trip.endDate}</li>
                <li>Ilość dni: ${trip.daysQuantity}</li>
                <li>Cena: ${trip.adultPrice}</li>
                <li><a href="/trip/details/${trip.id}">Pokaż szczegóły</a></li>
            </ul>
        </div>

    </c:forEach>
</div>



</body>
</html>