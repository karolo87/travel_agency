<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dodaj wycieczkę</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>

</head>
<body>
<%@include file="../fragments/header.jspf" %>
<div class="container">
    <h2>Dodaj wycieczkę</h2>

    <div class="trips_section">
        <div class="trips">
            <c:forEach items="${foundTrips}" var="trip">
                <div class="trip">
                        ${trip.departureCity.name} <br/>
                        ${trip.departureAirport.name} <br/>
                        ${trip.arrivalCity.name} <br/>
                        ${trip.arrivalAirport.name} <br/>
                    <a href="/trip/details/${trip.id}" class="details_button">Pokaż szczegóły</a>
                </div>
            </c:forEach>
        </div>



    </div>


</div>


</body>
</html>