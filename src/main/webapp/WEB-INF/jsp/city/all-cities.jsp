<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista miast</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>
<div class="container">

    <%@include file="../fragments/header.jspf" %>

    <div class="trips_section">
        <div class="trips">
            <c:forEach items="${allCities}" var="city">
                <div class="trip">
                    <h2>${city.name}</h2> <br/>
                        ${city.country.name}<br/>
                        ${city.country.continent.name}
                </div>

            </c:forEach>
        </div>

    </div>


</div>



</body>
</html>