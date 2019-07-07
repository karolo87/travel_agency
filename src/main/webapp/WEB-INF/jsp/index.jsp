<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Super hiper biuro podróży!!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css"/>

</head>
<body>

<div>
<header>
    <%@include file="./fragments/header.jspf" %>
</header>

    <h2>Strona główna</h2>

    <h3>Wycieczki promowane:</h3>
    <div class="trips_section">
        <c:forEach items="${promotedTrips}" var="trip_promoted">
            <div class="all_trips">
                Miasto wylotu: ${trip_promoted.departureCity.name} <br/>
                Miasto docelowe: ${trip_promoted.arrivalCity.name} <br/>
                Cena za osobę dorosłą: ${trip_promoted.adultPrice} <br/>
                Ilość dni: ${trip_promoted.daysQuantity} <br/>
                Wycieczka promowana? ${trip_promoted.isPromoted} <br/>
                Ilość miejsc dla dorosłych: ${trip_promoted.adultsQuantity}
                <a href="/buy-a-trip/${trip_promoted.id}">Kup wycieczkę</a>
                <hr>
            </div>
        </c:forEach>
    </div>

    <h3>Lista wszystkich wycieczek:</h3>
    <div class="trips_section">
        <c:forEach items="${allTrips}" var="trip">
            <div class="all_trips">
                Miasto wylotu: ${trip.departureCity.name} <br/>
                Miasto docelowe: ${trip.arrivalCity.name} <br/>
                Cena za osobę dorosłą: ${trip.adultPrice} <br/>
                Ilość dni: ${trip.daysQuantity} <br/>
                Wycieczka promowana? ${trip.isPromoted} <br/>
                Ilość miejsc dla dorosłych: ${trip.adultsQuantity} <br/>
                <a href="/buy-a-trip/${trip.id}">Kup wycieczkę</a>
                <hr>
            </div>
        </c:forEach>
    </div>

    <h3>Lista wycieczek na dany kontynent:</h3>
    <div class="trips_section">
        <c:forEach items="${tripsOfGivenContinent}" var="trip">
            <div class="all_trips">
                Miasto wylotu: ${trip.departureCity.name} <br/>
                Miasto docelowe: ${trip.arrivalCity.name} <br/>
                Cena za osobę dorosłą: ${trip.adultPrice} <br/>
                Ilość dni: ${trip.daysQuantity} <br/>
                Wycieczka promowana? ${trip.isPromoted} <br/>
                Ilość miejsc dla dorosłych: ${trip.adultsQuantity} <br/>
                <a href="/buy-a-trip/${trip.id}">Kup wycieczkę</a>
                <hr>
            </div>
        </c:forEach>
    </div>

</div>




</body>
</html>