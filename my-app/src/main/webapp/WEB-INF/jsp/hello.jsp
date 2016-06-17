<%-- 
    Document   : helloIba
    Created on : Jun 16, 2016, 3:50:03 PM
    Author     : Erik Macej,433 744
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach  begin="1" end="${x}">  
            <h3>Hello IBA!</h3>
        </c:forEach>    
    </body>
</html>
