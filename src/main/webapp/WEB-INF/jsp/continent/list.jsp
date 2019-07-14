<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista kontynentów</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>
</head>
<body>
<div class="container">

    <%@include file="../fragments/header.jspf" %>

    <h2>LISTA</h2>

    <sec:authorize access="hasRole('ADMIN')">
        <a href="/admin/add-continent">Dodaj kontynent</a><br/><br/>
    </sec:authorize>

    <div class="trips_section">
        <div class="trips">
            <c:forEach items="${continentList}" var="continent">
                <div class="trip">
                        ${continent.name} <br/>
                    <a href="/country/list/${continent.id}">Lista krajów</a>
                    <sec:authorize access="hasRole('ADMIN')">
                        <a href="/admin/add-country/${continent.id}">Dodaj kraj</a>
                    </sec:authorize>

                </div>
            </c:forEach>
        </div>
    </div>


</div>


</body>
</html>