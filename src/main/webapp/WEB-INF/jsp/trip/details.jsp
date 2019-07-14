<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Super hiper biuro podróży!!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>

<div class="container">
    <header>
        <%@include file="../fragments/header.jspf" %>
    </header>

    <h2>Szczegóły wycieczki</h2>

    <div class="trip_details">
        <h3>${trip.arrivalCity.name}</h3>
        <span class="label">Wylot z: </span>
        <span class="detail"> ${trip.departureCity.name} </span><br/>
        <span class="label">Początek wycieczki: </span>
        <span class="detail">${trip.startDate}  </span><br/>
        <span class="label">Koniec wycieczki: </span>
        <span class="detail">${trip.endDate}  </span><br/>
        <span class="label">Hotel: </span>
        <span class="detail">${trip.hotel.name}  </span><br/>
        <span class="label">Wyżywienie: </span>
        <span class="detail">${trip.type}  </span><br/>


        ${newPurchase.id} <br/>

        <a href="/buy-a-trip/${trip.id}">Kup wycieczkę</a>
        <a href="/admin/edit-trip/${trip.id}">Edytuj wycieczkę</a>


    </div>

</div>




</body>
</html>