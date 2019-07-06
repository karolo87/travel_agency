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

<h2>Dodaj wycieczkę</h2>

<form:form action="/admin/add-trip" modelAttribute="newTrip" method="post">


    <table>
        <tr>
            <th>Miasto wylotu:</th>
            <th>
                <form:select path="departureCity">
                    <c:forEach items="${cities}" var="city">
                        <form:option value="${city.name}"/>
                    </c:forEach>
                </form:select>
            </th>
        </tr>
        <tr>
            <th>Lotnisko wylotu:</th>
            <th><form:input path="departureAirport"/></th>
        </tr>
        <tr>
            <th>Miasto przylotu:</th>
            <th>
                <form:select path="arrivalCity">
                    <c:forEach items="${cities}" var="city">
                        <form:option value="${city.name}"/>
                    </c:forEach>
                </form:select>
            </th>
        </tr>
        <tr>
            <th>Lotnisko przylotu:</th>
            <th><form:input path="arrivalAirport"/></th>
        </tr>
        <tr>
            <th>Hotel:</th>
            <th><form:input path="hotel"/></th>
        </tr>
        <tr>
            <th>Początek wycieczki (rrrr-MM-dd):</th>
            <th><form:input path="startDate"/></th>
        </tr>
        <tr>
            <th>Koniec wycieczki (rrrr-MM-dd):</th>
            <th><form:input path="endDate"/></th>
        </tr>
        <tr>
            <th>Ilość dni:</th>
            <th><form:input path="daysQuantity"/></th>
        </tr>
        <tr>
            <th>Wariant wyżywienia:</th>
            <th><form:input path="type"/></th>
        </tr>
        <tr>
            <th>Cena za osobę dorosłą:</th>
            <th><form:input path="adultPrice"/></th>
        </tr>
        <tr>
            <th>Cena za dziecko:</th>
            <th><form:input path="childPrice"/></th>
        </tr>
        <tr>
            <th>Ilość miejsc dla dorosłych:</th>
            <th><form:input path="adultsQuantity"/></th>
        </tr>
        <tr>
            <th>Ilość miejsc dla dzieci:</th>
            <th><form:input path="childrenQuantity"/></th>
        </tr>
        <tr>
            <th></th>
            <th><input type="submit" value="Dodaj"/></th>
        </tr>
    </table>



</form:form>



</body>
</html>