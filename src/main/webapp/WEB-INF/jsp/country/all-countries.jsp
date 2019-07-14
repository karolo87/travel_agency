<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista krajów</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>

<div class="container">

    <%@include file="../fragments/header.jspf" %>

    <h2>Lista krajów</h2>

    <div class="trips_section">
        <div class="trips">
            <c:forEach items="${allCountries}" var="country">
                <div class="trip">
                        ${country.name}
                        ${country.continent.name}<br/>
                    <a href="/city/list/${country.id}" class="details_button">Miasta</a><br/>
                    <a href="/trip/list/${country.id}" class="details_button">Pokaż wycieczki</a>
                </div>
            </c:forEach>
        </div>


    </div>



</div>




</body>
</html>