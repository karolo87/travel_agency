<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista wycieczek</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>

</head>
<body>
<%@include file="../fragments/header.jspf" %>

<div class="container">
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
        <div class="trips">
            <c:forEach items="${tripsList}" var="trip">
                <div class="trip">
                    <span class="label">Miasto wylotu:</span><span class="detail"> ${trip.departureCity.name}</span><br/>
                    <span class="label">Miasto przylotu:</span><span class="detail"> ${trip.arrivalCity.name}</span><br/>
                    <span class="label">Lotnisko wylotu:</span><span class="detail"> ${trip.departureAirport.name}</span><br/>
                    <span class="label">Lotnisko przylotu:</span><span class="detail"> ${trip.arrivalAirport.name}</span><br/>
                    <span class="label">Hotel:</span><span class="detail"> ${trip.hotel.name}</span><br/>
                    <span class="label">Początek wycieczki:</span><span class="detail"> ${trip.startDate}</span><br/>
                    <span class="label">Koniec wycieczki:</span><span class="detail"> ${trip.endDate}</span><br/>
                    <span class="label">Ilość dni:</span><span class="detail"> ${trip.daysQuantity}</span><br/>
                    <span class="label">Cena:</span><span class="detail"> ${trip.adultPrice}</span><br/>
                        <a href="/trip/details/${trip.id}" class="details_button">Pokaż szczegóły</a>
                </div>
            </c:forEach>
        </div>

    </div>
</div>

</body>
</html>