<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista lotnisk</title>
</head>
<body>
<%@include file="../fragments/header.jspf" %>

<c:forEach items="${airportsList}" var="airport">
    ${airport.name} |
    ${airport.city.name}
    <br/>
</c:forEach>

</body>
</html>