<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Lista użytkowników</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>

</head>
<body>
<div class="container">
    <header>
        <div>
            <%@include file="../fragments/header.jspf"%>
        </div>
    </header>

    <div>
        <c:forEach items="${allUsers}" var="user">
            ${user.id}
            ${user.username}
            <br/>
        </c:forEach>
    </div>


</div>

</body>
</html>
