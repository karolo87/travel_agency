<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista zakupionych wycieczek</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>

</head>
<body>
<%@include file="../fragments/header.jspf" %>

<div class="container">
    <h2>Lista zakupionych wycieczek</h2>

    <form:form modelAttribute="pageForm" action="/admin/purchase-list" method="post">
        Przejdź do strony:<form:input path="page"/>
        Ilość wyników na stronie:<form:input path="size"/>
        Sortuj po:
        <form:select path="sortField">
            <form:option value="id" label="Id zakupu"/>
            <form:option value="client.firstName" label="Imię"/>
            <form:option value="client.lastname" label="Nazwisko"/>
            <form:option value="trip.departureCity.name" label="Miasto wylotu"/>
            <form:option value="trip.arrivalCity.name" label="Miasto przylotu"/>
            <form:option value="adultsQuantity" label="Ilość dorosłych"/>
            <form:option value="childrenQuantity" label="Ilość dzieci"/>
        </form:select>
        <form:select path="sortOrder">
            <form:option value="ASC" label="Sortuj rosnąco"/>
            <form:option value="DESC" label="Sortuj malejąco"/>
        </form:select>
        <input type="submit" value="pokaż">
    </form:form>

    <div class="trips_section">
        <div class="trips">
            <table class="data-sheet">
                <tr>
                    <th>Miasto wylotu</th>
                    <th>Miasto przylotu</th>
                </tr>
                <c:forEach items="${purchaseList}" var="purchase">
                    <tr>
                        <th>${purchase.trip.departureCity.name}</th>
                        <th>${purchase.trip.arrivalCity.name}</th>
                    </tr>
                </c:forEach>
            </table>

        </div>

    </div>
</div>

</body>
</html>