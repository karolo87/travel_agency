<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Super hiper biuro podróży!!</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css"/>

</head>
<body>

<%@include file="fragments/header_old.jspf" %>

<div class="row">

<%--    <div class="container">--%>
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
                    <a href="/trip/details/${trip_promoted.id}">Pokaż szczegóły</a>
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
                    <a href="/trip/details/${trip.id}">Pokaż szczegóły</a>
                    <hr>
                </div>
            </c:forEach>
        </div>

        <h3>Lista wycieczek na dany kontynent:</h3>
        <div class="trips_section">
            <c:forEach items="${allContinents}" var="continent">
                <div class="trip-continent">
                        ${continent.name}
                    <c:forEach items="${continent.countries}" var="country">
                        <c:forEach items="${country.cityList}" var="city">
                            <div class="all_trips">
                                <c:forEach items="${city.arrivalTripList}" var="trip">
                                    <div class="trip-city">
                                        -> ${trip.arrivalCity.name}
                                    </div>
                                </c:forEach>
                            </div>
                        </c:forEach>
                    </c:forEach>
                </div>
            </c:forEach>
        </div>

<%--    </div>--%>
</div>



</body>
</html>