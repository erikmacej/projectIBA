<%-- 
    Document   : result
    Created on : Jun 18, 2016, 12:12:02 AM
    Author     : Erik Macej,433 744
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <text>Meno: ${student.name}</text><br>
        <text>Priezvisko: ${student.surname}</text><br>
        <text>Datum narodenia: <fmt:formatDate pattern="dd.MM.yyyy" value="${student.bornDate}" /></text><br>
        <text>Pohlavie: ${student.sex}</text>
        <form action="${pageContext.request.contextPath}/list">
            <input type="submit" value="Späť">
        </form>
    </body>
</html>
