<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dodaj wycieczkę</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<h2>Dodaj hotel</h2>

<form:form action="/admin/add-trip/${cityId}" modelAttribute="newTrip" method="post">
    Miasto wylotu:
    <form:input path="departureCity"/><br/>

    Lotnisko wylotu:
    <form:input path="departureAirport"/><br/>

    Miasto przylotu:
    <form:input path="arrivalCity"/><br/>

    Lotnisko przylotu:
    <form:input path="arrivalAirport"/><br/>

    Początek wycieczki:
    <form:input path="startDate"/><br/>

    Koniec wycieczki:
    <form:input path="endDate"/><br/>

    Ilość dni:
    <form:input path="daysQuantity"/><br/>

    Wariant wyżywienia:
    <form:input path="type"/><br/>

    Cena za osobę dorosłą:
    <form:input path="adultPrice"/><br/>

    Cena za dziecko:
    <form:input path="childPrice"/><br/>

    Ilość miejsc dla dorosłych:
    <form:input path="adultsQuantity"/><br/>

    Ilość miejsc dla dzieci:
    <form:input path="childrenQuantity"/><br/>

    <input type="submit" value="Dodaj"/>
</form:form>



</body>
</html>