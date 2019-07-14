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
<div class="container">

    <%@include file="../fragments/header.jspf" %>

    <div class="main-page">

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
                    <th>
                        <form:select path="departureAirport">
                            <c:forEach items="${airports}" var="airport">
                                <form:option value="${airport.name}"/>
                            </c:forEach>
                        </form:select>
                    </th>
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
                    <th>
                        <form:select path="arrivalAirport">
                            <c:forEach items="${airports}" var="airport">
                                <form:option value="${airport.name}"/>
                            </c:forEach>
                        </form:select>
                    </th>
                </tr>
                <tr>
                    <th>Hotel:</th>
                    <th>
                        <form:select path="hotel">
                            <c:forEach items="${hotels}" var="hotel">
                                <form:option value="${hotel.name}"/>
                            </c:forEach>
                        </form:select>
                    </th>
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
                    <th>
                        <form:select path="type">
                            <form:option value="BB"/>
                            <form:option value="HB"/>
                            <form:option value="FB"/>
                            <form:option value="AI"/>
                        </form:select>
                    </th>
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
                    <th>Wycieczka promowana?</th>
                    <th>
                        <form:select path="isPromoted">
                            <form:option value="Tak"/>
                            <form:option value="Nie"/>
                        </form:select>

                    </th>
                </tr>
                <tr>
                    <th></th>
                    <th><input type="submit" value="Dodaj"/></th>
                </tr>
            </table>



        </form:form>


    </div>

</div>




</body>
</html>