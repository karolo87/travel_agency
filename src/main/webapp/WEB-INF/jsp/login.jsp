<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Zaloguj</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css"/>

</head>
<body>
<div class="container">
    <header>
        <%@include file="fragments/header.jspf"%>
    </header>

        <form name="loginForm" action="/login" method="post">
            Login:<input name="username"/>
            Hasło:<input type="password" name="password"/>
            <input type="submit" value="Zaloguj"/>
        </form>

</div>

</body>
</html>
