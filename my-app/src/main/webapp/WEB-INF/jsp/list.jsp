<%-- 
    Document   : list
    Created on : Jun 19, 2016, 12:55:30 AM
    Author     : Erik Macej,433 744
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Študenti</h1>
        <table border="1" style="width:60%">
            <thead>
                <tr>
                    <th>Meno</th>
                    <th>Priezvisko</th>
                    <th>Dátum narodenia</th>
                    <th>Pohlavie</th>
                </tr>                
            </thead>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td><c:out value="${student.name}"/></td>
                    <td><c:out value="${student.surname}"/></td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${student.bornDate}" /></td>
                    <td><c:out value="${student.sex}"/></td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/delete?id=${student.id}">
                            <input type="submit" value="Smazať">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/update?id=${student.id}">
                            <input type="submit" value="Upraviť">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/detail?id=${student.id}">
                            <input type="submit" value="Detail">
                        </form>
                    </td>                    
                </tr>
            </c:forEach>
        </table>
            <form action="${pageContext.request.contextPath}/create">
                <input type="submit" value="Vytvoriť študenta">
            </form>
    </body>
</html>
