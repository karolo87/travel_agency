<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Super hiper biuro podróży!!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css"/>

</head>
<body>

<div>
    <header>
        <%@include file="./fragments/header.jspf" %>
    </header>


    <form:form method="post" action="/register" modelAttribute="userForm">
        Nazwa użytkownika:
        <form:input path="username"/>
        <form:errors path="username"/>
        Hasło:
        <form:password path="password"/>
        <form:errors path="password"/>
        Potwierdź hasło:
        <form:password path="confirmPassword"/>
        <form:errors path="confirmPassword"/>

        <input type="submit" value="Zarejestruj"/>
    </form:form>

</div>


</body>
</html>