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

    <div>
        <h3>Podsumowanie:</h3>

        Imię: ${newTripPurchase.client.firstName} <br/>
        Nazwisko: ${newTripPurchase.client.lastName} <br/>
        Ilość osób dorosłych: ${newTripPurchase.adultsQuantity} <br/>
        Ilość dzieci: ${newTripPurchase.childrenQuantity} <br/>
        Miasto wylotu: ${newTripPurchase.trip.departureCity.name} <br/>

        Kwota za dorosłych: ${financeDetails.adultsCost}<br/>
        Kwota za dzieci: ${financeDetails.childrenCost}<br/>
        <h4>Kwota do zapłaty: ${amountOfMoney} </h4><br/>

    </div>
</div>

</body>
</html>