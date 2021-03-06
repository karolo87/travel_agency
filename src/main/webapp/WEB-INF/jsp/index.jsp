<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Super hiper biuro podróży!!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>

<div class="wrapper">

    <div class="container">

        <div id="logo">
            <h1>Super Biuro Podróży!</h1>
        </div>
        <%@include file="fragments/header.jspf" %>

        <div class="trips_section">
            <div class="title"><span>Wycieczki promowane</span></div>
            <div class="trips">
                <c:forEach items="${promotedTrips}" var="trip">
                    <div class="trip">
                        <h1>${trip.arrivalCity.name}</h1>
                        <span class="trip_description">Cena za osobę:</span>
                        <p class="price">${trip.adultPrice}</p>
                        <span class="trip_description">Start wycieczki:</span> ${trip.startDate}
                        <a href="/trip/details/${trip.id}" class="details_button">Pokaż więcej</a>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="trips_section">
            <div class="title"><span>Last minute</span></div>
            <div class="trips">
                <c:forEach items="${lastMinute}" var="trip">
                    <div class="trip">
                        <h1>${trip.arrivalCity.name}</h1>
                        <span class="trip_description">Cena za osobę:</span>
                        <p class="price">${trip.adultPrice}</p>
                        <span class="trip_description">Start wycieczki:</span> ${trip.startDate}
                        <a href="/trip/details/${trip.id}" class="details_button">Pokaż więcej</a>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="trips_section">
            <div class="title"><span>First minute</span></div>
            <div class="trips">
                <c:forEach items="${firstMinute}" var="trip">
                    <div class="trip">
                        <h1>${trip.arrivalCity.name}</h1>
                        <span class="trip_description">Cena za osobę:</span>
                        <p class="price">${trip.adultPrice}</p>
                        <span class="trip_description">Start wycieczki:</span> ${trip.startDate}
                        <a href="/trip/details/${trip.id}" class="details_button">Pokaż więcej</a>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
</div>

</body>
</html>