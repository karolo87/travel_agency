<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Super hiper biuro podróży!!</title>
</head>
<body>

<div>
<header>
    <%@include file="./fragments/header.jspf" %>
</header>

    <h2>Strona główna</h2>

    <div>
        <h3>Lista wszystkich wycieczek:</h3>
        <c:forEach items="${allTrips}" var="trip">
            <div>
                Miasto wylotu: ${trip.departureCity.name} <br/>
                Miasto docelowe: ${trip.arrivalCity.name} <br/>
                Cena za osobę dorosłą: ${trip.adultPrice} <br/>
                Ilość dni: ${trip.daysQuantity} <br/>
                <a href="/buy-a-trip/${trip.id}">Kup wycieczkę</a>
                <hr>
            </div>
        </c:forEach>
    </div>

</div>




</body>
</html>