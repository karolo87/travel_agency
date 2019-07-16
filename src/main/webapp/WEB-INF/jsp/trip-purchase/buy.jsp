<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tr" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kup wycieczkę</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>

<div class="container">
    <header>
        <%@include file="../fragments/header.jspf" %>
    </header>

    <h2>Szczegóły wycieczki</h2>

    <div>
        <h3>${trip.arrivalCity.name}</h3>


        <form:form modelAttribute="newTripPurchase" action="/buy-a-trip/${tripId}" method="post">
<%--            <form:errors path="*" cssClass="errorblock"/>--%>
            <table>
                <tr>
                    <th>Podaj imię:</th>
                    <th><form:input path="clientFirstName"/></th>
                    <th><form:errors path="clientFirstName" cssClass="error"/></th>

                </tr>
                <tr>
                    <th>Podaj nazwisko:</th>
                    <th><form:input path="clientLastName"/></th>
                    <th><form:errors path="clientLastName" cssClass="error"/></th>
                </tr>
                <tr>
                    <th>Podaj ilość osób dorosłych:</th>
                    <th><form:input path="adultsQuantity"/></th>
                    <th><form:errors path="adultsQuantity" cssClass="error"/></th>
                </tr>
                <tr>
                    <th>Podaj ilość dzieci:</th>
                    <th><form:input path="childrenQuantity"/></th>
                    <th><form:errors path="childrenQuantity" cssClass="error"/></th>
                </tr>
                <tr>
                    <th></th>
                    <th><input type="submit" value="Kup"/></th>
                </tr>
            </table>
        </form:form>
    </div>
</div>

</body>
</html>