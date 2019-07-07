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
        <%@include file="../fragments/header.jspf" %>
    </header>

    <h2>Szczegóły wycieczki</h2>

    <div>
        <h3>${trip.arrivalCity.name}</h3>


        ${newPurchase.id} <br/>

        <a href="/buy-a-trip/${trip.id}">Kup wycieczkę</a>


    </div>

</div>




</body>
</html>