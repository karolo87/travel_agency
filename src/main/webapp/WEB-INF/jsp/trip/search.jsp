<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

    <form:form action="/search" modelAttribute="searchedTrip" method="post">

        <form:input path="value"/>
        <form:select path="param">
            <form:option label="Miasto wylotu" value="departureCity"/>
            <form:option label="Lotnisko wylotu" value="departureAirport"/>
            <form:option label="Miasto przylotu" value="arrivalCity"/>
            <form:option label="Lotnisko przylotu" value="arrivalAirport"/>
            <form:option label="Hotel" value="hotel"/>
            <form:option label="Początek wycieczki" value="startDate"/>
            <form:option label="Koniec wycieczki" value="endDate"/>
            <form:option label="Ilość dni" value="daysQuantity"/>
            <form:option label="Wariant wyżywienia" value="type"/>
            <form:option label="Max. cena za osobę dorosłą" value="adultPrice"/>
            <form:option label="Max. cena za dziecko" value="childPrice"/>
            <form:option label="Min. ilość miejsc dla dorosłych" value="isPromoted"/>
            <form:option label="Min. ilość miejsc dla dzieci" value="adultsQuantity"/>
            <form:option label="Wycieczka promowana" value="childrenQuantity"/>
        </form:select>
        <input type="submit" value="Szukaj"/>


    </form:form>
</div>


</body>
</html>